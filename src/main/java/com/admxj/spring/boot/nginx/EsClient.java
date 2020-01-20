package com.admxj.spring.boot.nginx;

import groovy.util.logging.Slf4j;
import lombok.Builder;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseListener;
import org.elasticsearch.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

@Slf4j
public class EsClient implements Closeable {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private RestClient client;

    @Builder
    public EsClient(String targetUrl, Integer port) {
        Objects.requireNonNull(targetUrl, "targetUrl can't be null");
        Objects.requireNonNull(port, "pathPrefix can't be null");
        constructRestClient(targetUrl, port);
    }

    /**
     * 根据申请时提供的域名地址和二级目录构造 RestClient
     *
     * @param targetUrl nginx地址
     * @param port      端口
     */
    private void constructRestClient(String targetUrl, Integer port) {
        client = RestClient.builder(new HttpHost(targetUrl, port)).setRequestConfigCallback(builder -> {
            // 设置rest client的相关配置
            return builder;
        }).setFailureListener(new RestClient.FailureListener() {

            @Override
            public void onFailure(HttpHost host) {
                logger.error("error to construct rest client {} ", host);
            }
        }).build();
    }

    /**
     * 同步删除
     *
     * @param resource
     * @return
     * @throws IOException
     */
    public Response delete(String resource) throws IOException {
        checkRestClientNotNull();
        return client.performRequest("DELETE", resource);
    }


    /**
     * search 查询获取结果
     *
     * @param resource
     * @return
     * @throws IOException
     */
    public Response search(String resource, String body) throws IOException {
        checkRestClientNotNull();
        return client.performRequest("POST", resource, Collections.emptyMap(), new NStringEntity(body, ContentType.APPLICATION_JSON));
    }


    /**
     * 获取resource
     *
     * @param resource
     * @return
     * @throws IOException
     */
    public Response get(String resource) throws IOException {
        checkRestClientNotNull();
        return client.performRequest("GET", resource);
    }

    /**
     * 同步post
     *
     * @param resource
     * @param body
     * @return
     * @throws IOException
     */
    public Response post(String resource, String body) throws IOException {
        checkRestClientNotNull();
        return client.performRequest("POST", resource, Collections.emptyMap(), new NStringEntity(body, ContentType.APPLICATION_JSON));
    }

    /**
     * 异步删除
     *
     * @param resource
     * @param responseListener
     */
    public void deleteAsync(String resource, ResponseListener responseListener) {
        checkRestClientNotNull();
        client.performRequestAsync("DELETE", resource, responseListener);
    }


    /**
     * 异步post
     *
     * @param resource
     * @param body
     * @param responseListener
     */
    public void postAsync(String resource, String body, ResponseListener responseListener) {
        checkRestClientNotNull();
        client.performRequestAsync("POST", resource, Collections.emptyMap(), new NStringEntity(body, ContentType.APPLICATION_JSON), responseListener);
    }


    private void checkRestClientNotNull() {
        Objects.requireNonNull(client, "EsClient should init first");
    }

    @Override
    public void close() throws IOException {
        if (client != null) {
            client.close();
        }
    }
}

