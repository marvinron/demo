package com.example.demo.easyexcel.fileutil;


import java.io.InputStream;

public class FileUtil {
    public static InputStream getResourceFileInputStream(String fileName){
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
    }
}
