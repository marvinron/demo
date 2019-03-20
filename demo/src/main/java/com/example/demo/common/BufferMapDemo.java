package com.example.demo.common;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-12 16:53
 */
public class BufferMapDemo {
    private static void method3(){
        RandomAccessFile randomAccessFile = null;
        FileChannel fileChannel = null;

        try {
            randomAccessFile = new RandomAccessFile("day02.ppt","rw");
            FileChannel channel = randomAccessFile.getChannel();
            long begin = System.currentTimeMillis();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, 102400);
           /* byte[] ds = new byte[(int) randomAccessFile.length()];
            for (int offset = 0; offset < randomAccessFile.length(); offset++) {
                byte b = map.get();
                ds[offset] = b;
            }

            Scanner scan = new Scanner(new ByteArrayInputStream(ds)).useDelimiter(" ");
            while (scan.hasNext()) {
                System.out.print(scan.next() + " ");
            }*/


            long end = System.currentTimeMillis();

            System.out.println("耗费的时间是===="+(end-begin));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        method3();
    }
}
