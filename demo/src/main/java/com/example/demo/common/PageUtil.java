package com.example.demo.common;

public class PageUtil {
    public PageVo findPageVO(){
        PageVo pageVo = new PageVo();
        pageVo.setCurrentPage(1);
        pageVo.setPageSize(20);
        return pageVo;

    }
}
