package com.example.demo.easyexcel;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.example.demo.easyexcel.fileutil.FileUtil;
import com.example.demo.easyexcel.readmodel.ReadModel;
import com.example.demo.easyexcel.readmodel.WriteModel;
import com.example.demo.params.User;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

public class EasyExcelDemo {
    //读取文件数据
    public static void test() {
        InputStream resourceFileInputStream = FileUtil.getResourceFileInputStream("2007.xlsx");
//        List<Object> read = EasyExcelFactory.read(resourceFileInputStream, new Sheet(3,0));
        List<Object> read = EasyExcelFactory.read(resourceFileInputStream, new Sheet(2, 1, ReadModel.class));

//        EasyExcelFactory.read(resourceFileInputStream, new Sheet(2, 1, ReadModel.class));
        Stream.of(read).forEach(System.out::println);
    }

    //写出文件数据
    public static void main(String[] args) throws Exception {
        //获取写的输出流

        OutputStream outputStream = new FileOutputStream("/Users/jipengfei/2007.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);
        //建立sheet
        Sheet sheet = new Sheet(1,1);
        sheet.setSheetName("第一个sheet");
//        Map<Integer,Integer> columnWidthMap = new HashMap<>();
        /*columnWidthMap.put(0,1000);
        columnWidthMap.put(1,2000);
        columnWidthMap.put(2,30000);
        columnWidthMap.put(3,40000);
        sheet.setColumnWidthMap(columnWidthMap);*/
        sheet.setAutoWidth(true);
        sheet.setHead(createTestListStringHead());
        writer.write1(createTestListObject(),sheet);

        Sheet sheet2 = new Sheet(2,1,WriteModel.class);
        sheet2.setAutoWidth(true);
        sheet2.setSheetName("第二个sheet");
        //不用设置表头
        writer.write(createJavaModelList(),sheet2);


        writer.finish();
        outputStream.close();



    }

    public static List<List<String>> createTestListStringHead(){
        //写sheet3  模型上没有注解，表头数据动态传入
        List<List<String>> head = new ArrayList<List<String>>();
        List<String> headCoulumn1 = new ArrayList<String>();
        List<String> headCoulumn2 = new ArrayList<String>();
        List<String> headCoulumn3 = new ArrayList<String>();
        List<String> headCoulumn4 = new ArrayList<String>();

        headCoulumn1.add("第一列");
        headCoulumn2.add("第二列");
        headCoulumn3.add("第三列");
        headCoulumn4.add("第四列");

        head.add(headCoulumn1);
        head.add(headCoulumn2);
        head.add(headCoulumn3);
        head.add(headCoulumn4);

        return head;
    }

    public static List<List<Object>> createTestListObject() {
        List<List<Object>> object = new ArrayList<List<Object>>();
        for (int i = 0; i < 1000; i++) {
            List<Object> da = new ArrayList<Object>();
            da.add("字符串"+i);
            da.add(Long.valueOf(187837834l+i));
            da.add(Integer.valueOf(2233+i));
            da.add(new Date());
            object.add(da);
        }
        return object;
    }

    public static List<WriteModel> createJavaModelList(){
        //写sheet3  模型上没有注解，表头数据动态传入
        List<WriteModel> listData = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            WriteModel writeModel = new WriteModel();
            writeModel.setP1("11111");
            writeModel.setP2("aaaaa");
            writeModel.setP3(00000);
            writeModel.setP4(22L);
            writeModel.setP5("sss");
            writeModel.setP6(333f);
            writeModel.setP7(new BigDecimal(0));
            writeModel.setP8(new Date());
            writeModel.setP9("ppppp");
            writeModel.setP10(45.45);
            listData.add(writeModel);
        }
        return listData;
    }


}
