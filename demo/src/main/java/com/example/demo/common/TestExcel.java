package com.example.demo.common;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author houlei
 * @DESC:excel的导出
 * @create 2019-01-22 13:11
 */
public class TestExcel {

    public static void main(String[] args) {
        writeExcel();
    }

    private static void writeExcel() {
        OutputStream out = null;
        try {
            out = new FileOutputStream("e:/78.xlsx");
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            //写第一个sheet, sheet1 数据全是List<String> 无模型映射关系
//            Sheet sheet1 = new Sheet(1, 0,ImportInfo.class);
//            writer.write(getData(), sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<? extends BaseRowModel> getData() {
        List<ImportInfo> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            ImportInfo importInfo = new ImportInfo();
            importInfo.setActivityCode(123);
            importInfo.setCode(12L);
            importInfo.setDate(new Date());
            importInfo.setEndTime(new Date());
            importInfo.setLx(12.02);

            importInfo.setMoney(20.23);
            importInfo.setName("大白");
            importInfo.setNum(456);
            importInfo.setSex(1);
            importInfo.setTimes("asd");
            list.add(importInfo);
        }
        return null;
    }
}
