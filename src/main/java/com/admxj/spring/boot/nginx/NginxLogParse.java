package com.admxj.spring.boot.nginx;

import com.admxj.spring.boot.nginx.entity.LogEntity;
import com.admxj.spring.boot.utils.JsonUtils;
import org.elasticsearch.client.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author admxj
 */
public class NginxLogParse {

    private final static Logger logger = LoggerFactory.getLogger(NginxLogParse.class);

    private static final String PATTERN = "(?<ip>\\d+\\.\\d+\\.\\d+\\.\\d+)( - - \\[)(?<datetime>[\\s\\S]+)(?<t1>\\][\\s\"]+)(?<request>[A-Z]+) (?<url>[\\S]*) (?<protocol>[\\S]+)[\"] (?<code>\\d+) (?<sendbytes>\\d+) [\"](?<refferer>[\\S]*)[\"] [\"](?<useragent>[\\S\\s]+)[\"]";

    private static final EsClient esClient = new EsClient("127.0.0.1", 9200);

    public static void main(String[] args) {

        String fileName = "/Users/admxj/Downloads/wordpress.log";

        Path path = Paths.get(fileName);
        try {
            List<String> logs = Files.readAllLines(path);
            List<LogEntity> list = logs.stream().map(s -> parse(s, "${projectName}")).collect(Collectors.toList());

            list.stream().parallel().forEach(logEntity -> {
                Response response = null;
                try {
                    response = esClient.post("/text_index/_doc/", JsonUtils.objectToJson(logEntity));
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    logger.info("response code: {} ", response.getStatusLine().getStatusCode());
                }

            });


            System.out.println(list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 解析转换逻辑
     *
     * @param text    单条的日志记录
     * @param project 项目名称
     * @return 解析成功则返回具体的对象，解析失败返回<code>null</code>
     */
    public static LogEntity parse(String text, String project) {
        Pattern r = Pattern.compile(PATTERN);
        Matcher m = r.matcher(text);

        while (m.find()) {
            LogEntity log = new LogEntity();
            log.setIp(m.group("ip"));
            log.setProject(project);
            String datetime = m.group("datetime");
            log.setTime(convertTime(datetime));
            log.setRequest(m.group("request"));
            log.setUrl(m.group("url"));
            log.setProtocol(m.group("protocol"));
            log.setCode(Integer.valueOf(m.group("code")));
            log.setSendByteSize(Integer.valueOf(m.group("sendbytes")));
            log.setRefferer(m.group("refferer"));
            log.setUseAgent(m.group("useragent"));
            log.setBot(isBot(log.getUseAgent()));
            log.setResource(isResource(log.getUrl()));

            return log;
        }
        logger.error(String.format("%s 格式化错误", text));
        return null;
    }

    /**
     * 提取转换时间
     *
     * @param s 格式化的时间文本：26/Jan/2019:06:51:27 +0800]
     * @return LocalDateTime 时间
     */
    private static LocalDateTime convertTime(String s) {
        String t = s.substring(0, s.indexOf(" "));
        return LocalDateTime.parse(t, DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH));
    }

    /**
     * 通过 userAgent 字段判断是不是爬虫或机器人的访问记录
     *
     * @param userAgent 访问者的用户代理
     * @return 是否是爬虫或机器人的访问记录
     */
    private static boolean isBot(String userAgent) {
        String t = userAgent.toLowerCase();
        return t.contains("bot") || t.contains("spider");
    }

    /**
     * 通过 url 字段判断访问的是不是静态资源文件
     *
     * @param url 访问的url路径
     * @return 访问的是否是静态资源文件
     */
    private static boolean isResource(String url) {
        String t = url.toLowerCase();
        return t.contains(".js")
                || t.contains(".css")
                || t.contains(".png")
                || t.contains(".ico")
                || t.contains(".gif")
                || t.contains(".txt")
                || t.contains(".woff")
                || t.contains(".eot")
                || t.contains(".jpg");
    }
}
