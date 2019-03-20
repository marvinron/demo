package com.example.demo.common;

import java.beans.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class PropertyEditorDemo {
    public static void main(String[] args) {
        try {
//            Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.example.demo.common.User");
            Class<?> aClass = Class.forName("com.example.demo.common.User");

            BeanInfo beanInfo = Introspector.getBeanInfo(aClass, Object.class);
            BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
            System.out.println("beanDescriptor "+beanDescriptor);
            MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
            Stream.of(methodDescriptors).forEach(System.out::println);
            //属性描述
            User user = new User();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            Stream.of(propertyDescriptors).forEach(propertyDescriptor -> {
//                System.out.println(propertyDescriptor.getName()+"======");
                String propertyName = propertyDescriptor.getName();
                if("id".equals(propertyName)){
                    propertyDescriptor.setPropertyEditorClass(IdPropertyEditor.class);
                    PropertyEditor propertyEditor = propertyDescriptor.createPropertyEditor(user);
                    propertyEditor.addPropertyChangeListener(new SetPropertyLisener(user,propertyDescriptor.getWriteMethod()));
                    propertyEditor.setAsText("77");
                }else if("date".equals(propertyName)){
                    //设置编辑器
                    propertyDescriptor.setPropertyEditorClass(DatePropertyEditor.class);
                    //创建该编辑器
                    PropertyEditor propertyEditor = propertyDescriptor.createPropertyEditor(user);
                    //增加监听
                    propertyEditor.addPropertyChangeListener(new SetPropertyLisener(user,propertyDescriptor.getWriteMethod()));
                    propertyEditor.setAsText("2018-09-01");
                }


            });
            System.out.println(user);

            Field[] declaredFields = aClass.getDeclaredFields();
            Stream.of(declaredFields).forEach(field -> {
                System.out.println(field.getName());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static class SetPropertyLisener implements PropertyChangeListener{
        private final Object bean;
        private final Method setMethod;

        public SetPropertyLisener(Object bean, Method setMethod) {
            this.bean = bean;
            this.setMethod = setMethod;
        }
        //属性值的改变

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            PropertyEditor source =(PropertyEditor) evt.getSource();
            //执行方法
            try {
                setMethod.invoke(bean,source.getValue());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }
}


