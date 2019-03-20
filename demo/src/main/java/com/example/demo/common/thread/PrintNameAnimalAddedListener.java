package com.example.demo.common.thread;

import com.google.common.collect.ImmutableList;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author houlei
 * @DESC:
 * @create 2019-02-22 14:01
 */
public class PrintNameAnimalAddedListener implements AnimalAddedListener {
    @Override
    public void updateAnimalAdded(Animal animal) {
        System.out.println("Added a new animal with name '" + animal.getName() + "'");
    }

    //图片处理
    public static void main(String[] args) throws Exception {
        /*Thumbnails.of(new File("E:\\projects\\demo\\src\\main\\resources\\original.jpg"))
                .size(160, 160)
                .rotate(90)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("E:\\projects\\demo\\src\\main\\resources\\watermark.png")), 0.5f)
                .outputQuality(0.8)
                .toFile(new File("E:\\projects\\demo\\src\\main\\resources\\image-with-watermark.jpg"));*/
        /*StringJoiner stringJoiner = new StringJoiner(":","[","]");
        stringJoiner.add("hello ").add("you can").add("do it");
        System.out.println(stringJoiner.toString());*/
        /*List<String> list = ImmutableList.of("hello","how","are","you");*/
        String str = "abcdef";
        /*String reverse = StringUtils.reverse(str);
        System.out.println(reverse);*/
      /*  char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
           chars[chars.length - i - 1]= str.charAt(i) ;
        }
        System.out.println(String.valueOf(chars));*/
        Stack stack = new Stack();
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer("");
        for(char ch:chars){
            stack.push(ch);
        }
        while (!stack.empty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
