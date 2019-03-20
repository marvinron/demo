package com.example.demo.page;


import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author houlei
 * @DESC:分页插件
 * @create 2019-03-04 10:47
 */
public class Page<E> implements Serializable {
    private static final Integer DEFAULT_PAGE_SIZE=10;
    private static final Integer DEFAULT_PAGE_NO=1;
    private int pageNo =DEFAULT_PAGE_NO;
    private int pageSize =DEFAULT_PAGE_SIZE;
    private int totalCount=0;
    private List<E> dataList;
    public static void main(String[] args) throws Exception {
        //根据xml配置文件创建resource资源对象 该对象包含了Beandefination的信息
        ClassPathResource resource = new ClassPathResource("");
        //创建DefaultListableBeanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //创建XmlBeandefinitionreaderd读取器 来读取resource
        String filename = StringUtils.getFilename("classpath:resource/applicationContext.xml");
        String filenameExtension = StringUtils.getFilenameExtension("classpath:resource/applicationContext.xml");



    }

}
