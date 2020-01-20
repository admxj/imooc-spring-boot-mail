package com.admxj.spring.boot.nginx;

import com.admxj.spring.boot.nginx.entity.LogEntity;
import com.admxj.spring.boot.utils.JsonUtils;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author admxj
 */
public class RestClientUtils {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private EsClient esClient;

    public RestClientUtils(RestClient restClient) {
        this.esClient = new EsClient("127.0.0.1", 9200);
    }

    public void post(LogEntity logEntity) throws IOException {
        Response response = esClient.post("/text_index/_doc/", JsonUtils.objectToJson(logEntity));
        logger.info("response code: {} ", response.getStatusLine().getStatusCode());
        logger.info("response str: {} ", EntityUtils.toString(response.getEntity()));
    }
}
