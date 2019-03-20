package com.example.demo.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataDemo implements Cloneable {

    private int value;
    private String desc;

    @Override
    protected DataDemo clone() throws CloneNotSupportedException {
        DataDemo copy = (DataDemo)super.clone();
        /*copy.desc= new String(this.desc);*/
        return copy;
    }
}
