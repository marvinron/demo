package com.example.demo.common;

import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyEditorSupport;

public class IdPropertyEditor extends PropertyEditorSupport {
    public void setAsText(String id){
        if(StringUtils.isNotBlank(id)){
            long l = Long.parseLong(id);
            setValue(l);

        }


    }
}
