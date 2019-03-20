package com.example.demo.common.loader;

import com.example.demo.common.User;

import java.io.*;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-12 14:18
 */
public class FileSystemClassLoader extends ClassLoader {
    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        }
        else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }

    public static void main(String[] args) throws Exception {
        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader("E:\\projects\\demo\\target\\classes");
        Class<?> aClass = fileSystemClassLoader.findClass("com.example.demo.common.User");
//        Class<?> aClass = Class.forName("com.example.demo.common.User",true,fileSystemClassLoader);
        Object o = aClass.newInstance();
        User o1 = (User)aClass.newInstance();
        System.out.println(o1.getId()+"==========");
        System.out.println(o.getClass().getClassLoader());
    }
}
