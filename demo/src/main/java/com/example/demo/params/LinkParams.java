package com.example.demo.params;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkParams {
    public static String getLinkedParams(Map<String,Object> paramMap){
        StringBuffer sb = new StringBuffer();
        List<String> list = new ArrayList<>(paramMap.keySet());
        for (int i = 0; i <list.size() ; i++) {
            String key = list.get(i);
            String value = paramMap.get(key).toString();
            if(i == list.size()-1){
                sb.append(key+"="+value);
            }else {
                sb.append(key+"="+value+"&");
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("name","jack");
        map.put("age",12);
        map.put("sex","女");

        System.out.printf("转化后的字符串【%s】",getLinkedParams(map));

    }
}
