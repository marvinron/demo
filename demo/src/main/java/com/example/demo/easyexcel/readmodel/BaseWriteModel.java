package com.example.demo.easyexcel.readmodel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author houlei
 * @DESC:BaseWriteModel
 * @create 2019-01-07 15:11
 */
public class BaseWriteModel extends BaseRowModel {
    @ExcelProperty(value = {"表头1"},index = 0)
    protected String p1;

    @ExcelProperty(value = {"表头2"},index = 1)
    protected String p2;

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }
}
