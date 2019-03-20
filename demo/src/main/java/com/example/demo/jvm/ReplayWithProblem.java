package com.example.demo.jvm;

import com.google.common.util.concurrent.FutureCallback;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.cache.CachingHttpAsyncClient;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.DefaultHttpAsyncClient;
import org.apache.http.nio.client.HttpAsyncClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houlei
 * @DESC:测试内存溢出
 * @create 2019-02-22 11:50
 */
public class ReplayWithProblem {

    public List<HttpUriRequest> loadMockRequest(int n){

        List<HttpUriRequest> cache = new ArrayList<HttpUriRequest>(n);
        for (int i = 0; i < n; i++) {
            HttpGet request = new HttpGet("http://www.baidu.com?a="+i);
            cache.add(request);
        }
        return cache;

    }

    public void start(List<HttpUriRequest> cache) throws Exception {

        HttpAsyncClient httpClient = new DefaultHttpAsyncClient();
        int i = 0;

        /*while (true){

            final HttpUriRequest request = cache.get(i%cache.size());
            httpClient.execute(request, new FutureCallback<HttpResponse>() {
                public void completed(HttpResponse response) {
                    System.out.println(request.getRequestLine() + "->" + response.getStatusLine());
                }

                public void failed(Exception ex) {
                    System.out.println(request.getRequestLine() + "->" + ex);
                }

                public void cancelled() {
                    System.out.println(request.getRequestLine() + " cancelled");
                }

            });
            i++;
            Thread.sleep(100);
        }*/
    }

}

