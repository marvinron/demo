package com.example.demo.controller;

import com.example.demo.common.ExportUtils;
import com.example.demo.common.ImportInfo;
import com.example.demo.common.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping("/test")
public class DemoRestController {

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/send")
    @ResponseBody
    public void export(HttpServletResponse response){

//        //模拟从数据库获取需要导出的数据
//        List<Person> personList = new ArrayList<>();
//        Person person1 = new Person("路飞","1",new Date());
//        Person person2 = new Person("娜美","2", new Date());
//        Person person3 = new Person("索隆","1", new Date());
//        Person person4 = new Person("小狸猫","1", new Date());
//        personList.add(person1);
//        personList.add(person2);
//        personList.add(person3);
//        personList.add(person4);
//
//        //导出操作
//        ExportUtils.exportExcel(personList,"花名册","草帽一伙",Person.class,"海贼王.xls",response);


        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("605599917@qq.com");
        message.setTo("houlei801@163.com");
        message.setSubject("123");
        message.setText("123456789");

        javaMailSender.send(message);

    }

    @RequestMapping("importExcel")
    public void importExcel(){
        String filePath = "F:\\海贼王.xls";
        //解析excel，
        List<Person> personList = ExportUtils.importExcel(filePath,1,1,Person.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");

        //TODO 保存数据库
    }
}
