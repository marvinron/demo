package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PageVo implements Serializable {
    private static final long serialVersionUID = -6583682223643747751L;

    private int pageSize;
    private  int pageCount;
    private int currentPage;
}
