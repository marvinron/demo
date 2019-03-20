package com.example.demo.common.serializer;

import com.example.demo.common.User;

import java.util.Date;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-12 9:20
 */
public class Test {
    public static void main(String[] args) {
        /*ISerializer javaSerializer = new JavaSerializer();
        User user = new User();
        user.setId(1L);
        user.setName("大白");
        user.setDate(new Date());
        javaSerializer.serializer(user);
        User user1 = (User)javaSerializer.deserializer(null, null);
        System.out.println(user1);*/
        ISerializer iSerializer = new XMLSerializer();
        User user = new User();
        user.setId(1L);
        user.setName("大白");
        user.setDate(new Date());
        byte[] serializer = iSerializer.serializer(user);
        User deserializer = (User)iSerializer.deserializer(serializer, null);
        System.out.println(deserializer.toString());

    }
}
