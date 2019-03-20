package com.example.demo.common;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageFormatDemo {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        MessageFormat messageFormat = new MessageFormat("您好 {0}，请您于{1}到得易金服商谈");
        System.out.println(messageFormat.format(new Object[]{"小马哥",dateFormat.format(new Date())}));
    }
}
