package com.example.demo.common;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author houlei
 * @DESC:
 * @create 2019-01-22 14:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    @Excel(name = "姓名", orderNum = "0")
    private String name;

    @Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "1")
    private String sex;

    @Excel(name = "生日", exportFormat = "yyyy-MM-dd", orderNum = "2")
    private Date birthday;
}
