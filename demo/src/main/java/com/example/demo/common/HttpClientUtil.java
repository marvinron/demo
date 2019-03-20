package com.example.demo.common;


import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    private  CloseableHttpClient httpClient = null;
    private  RequestConfig requestConfig = null;
    private static final HttpClientUtil httpClientUtil = new HttpClientUtil();
    private static PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
    static {

        connectionManager.setMaxTotal(500);
        connectionManager.setDefaultMaxPerRoute(50);//例如默认每路由最高50并发，具体依据业务来定
    }
    private HttpClientUtil(){
        httpClient = HttpClients.custom().setConnectionManager(connectionManager).disableAutomaticRetries().build();
        requestConfig = RequestConfig.custom().setConnectTimeout(10000).setSocketTimeout(10000).setConnectionRequestTimeout(10000).build();

    }

    public static synchronized HttpClientUtil getInstance(){
        return httpClientUtil;
    }

    public  HttpResponse doGet(String url){
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        httpGet.setHeader("Token","test");
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            return httpResponse;
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            httpGet.releaseConnection();
        }
        return null;

    }

    public static void main(String[] args) throws Exception{
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        HttpResponse httpResponse = httpClientUtil.doGet("https://www.baidu.com/");
        String s = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
        System.out.println("=========="+s);
    }


}
