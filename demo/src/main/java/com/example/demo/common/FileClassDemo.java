package com.example.demo.common;


import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class FileClassDemo {
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://start.spring.io/");

        InputStream inputStreamFromURL = url.openStream();

        String content = StreamUtils.copyToString(inputStreamFromURL, Charset.forName("UTF-8"));

        System.out.println(content);


    }
}
