package com.example.demo.common;


import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
    private static Map<String,ThreadLocal<SimpleDateFormat>> map = new HashMap<>();

    private static SimpleDateFormat getDateFormat(final String pattern){
        ThreadLocal<SimpleDateFormat> threadLocal = map.get(pattern);
        if(threadLocal == null){
            synchronized (DateUtil.class){
                threadLocal = map.get(pattern);
                if(threadLocal == null){
                    threadLocal = new ThreadLocal<SimpleDateFormat>(){
                        @Override
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    map.put(pattern,threadLocal);

                }

            }

        }

        return threadLocal.get();
    }
}
