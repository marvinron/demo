package com.example.demo.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ClassPathDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://blog.csdn.net/guoxilen/article/details/24884877");
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            String str ="";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringAppend = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null){
                stringAppend.append(str);
            }

            System.out.println(stringAppend.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
