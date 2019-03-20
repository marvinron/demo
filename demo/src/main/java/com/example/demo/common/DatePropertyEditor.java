package com.example.demo.common;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {
    public void setAsText(String text){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date format = dateFormat.parse(text);
            setValue(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
