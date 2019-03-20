package com.example.demo.params;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.util.ObjectUtils;
import org.apache.commons.lang3.StringUtils;



import java.text.SimpleDateFormat;
import java.util.*;


public class TaskDemo {
    public static void main(String[] args) {
//        String[] strArray = {"a","asdas","123"};
//        if(ObjectUtils.isEmpty(strArray)){
//
//        }
//        Timer timer = new Timer();
//        Calendar instance = Calendar.getInstance();
//        timer.scheduleAtFixedRate(new MyJob(), instance.getTime(),1000);
        String url = "https://www.google.com.hk/search?q=java&oq=java&sourceid=chrome&es_sm=122&ie=UTF-8";

        Map<String, List<String>> stringListMap = resolveParametersMap(url);


    }


    public static Map<String, List<String>> resolveParametersMap(String url) {
        String queryString = StringUtils.substringAfterLast(url, "?");


        if (StringUtils.isNotBlank(queryString)) {
            Map<String, List<String>> parametersMap = Maps.newLinkedHashMap();
            String[] queryParams = StringUtils.split(queryString, "&");
            if (queryParams != null) {
                for (String queryParam : queryParams) {
                    String[] paramNameAndValue = StringUtils.split(queryParam, "=");
                    if (paramNameAndValue.length > 0) {
                        String paramName = paramNameAndValue[0];
                        String paramValue = paramNameAndValue.length > 1 ? paramNameAndValue[1] : StringUtils.EMPTY;
                        List<String> paramValueList = parametersMap.get(paramName);
                        if (paramValueList == null) {
                            paramValueList = Lists.newLinkedList();
                            parametersMap.put(paramName, paramValueList);
                        }
                        paramValueList.add(paramValue);
                    }
                }
            }
            return Collections.unmodifiableMap(parametersMap);
        } else {
            return Collections.emptyMap();
        }
    }


}

  class MyJob extends TimerTask {

      @Override
      public void run() {
          System.out.println("timer task execute start "+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(this.scheduledExecutionTime()));
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }
