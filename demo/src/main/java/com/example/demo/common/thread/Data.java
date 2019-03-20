package com.example.demo.common.thread;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 * @author houlei
 * @DESC:多线程的Balking
 * @create 2019-03-01 10:43
 */
public class Data {
    private String filename;//保存文件的名称
    private String content;//数据的内容
    private boolean changed;//内容是否已保存的标志，若修改后为保存，则为true

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = changed;
    }

    public synchronized void changed(String newContent) {
        content = newContent;
        changed = true;
    }

    private void doSave() throws Exception {
        System.out.println("threadName =" + Thread.currentThread().getName());
        File file = new File(filename);
        Writer writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }

    public synchronized void save()throws Exception{
        if(!changed){
            return;
        }
        doSave();
        changed = false;
    }




}
