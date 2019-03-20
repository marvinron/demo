package com.example.demo.common;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author houlei
 * @DESC:导出实体类的信息
 * @create 2019-01-22 11:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ExcelTarget("importInfo")
public class ImportInfo implements Serializable {

    @Excel(name = "编号")
    private int num;

//    @ExcelProperty(index = 1,value = "code")
    @Excel(name = "code")
    private Long code;

//    @ExcelProperty(index = 2,value = "银行存放期期",format = "yyyy-MM-dd")
    @Excel(name = "银行存放期期",format = "yyyy-MM-dd")
    private Date endTime;

//    @ExcelProperty(index = 3,value = "测试1")
    @Excel(name = "测试1")
    private Double money;

    @ExcelProperty(index = 4,value = "测试2")
    @Excel(name = "测试2")
    private String times;

    @ExcelProperty(index = 5,value = "测试3")
    @Excel(name = "测试2")
    private int activityCode;

    @ExcelProperty(index = 6,value = "测试4")
    @Excel(name = "测试2")
    private Date date;

    @ExcelProperty(index = 7,value = "测试5")
    @Excel(name = "测试2")
    private Double lx;

    @ExcelProperty(index = 8,value = "测试6")
    @Excel(name = "测试2")
    private String name;
//    @ExcelProperty(index = 9,value = "性别",format = "男_1,女_2")
    @Excel(name = "性别")
    private int sex;

    public static void main(String[] args) throws Exception{
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


        ExportParams params = new ExportParams("课程详情", null, "课程详情");
        Workbook workbook = ExcelExportUtil.exportExcel(params, ImportInfo.class, list);
        File targetFile = new File("/temp.xls");
        FileOutputStream fos = new FileOutputStream(targetFile);
        workbook.write(fos);
        fos.close();
    }
}


