package com.example.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 76950
 */
@Data
public class RanDom implements Serializable {


    private String id;

    /**
     * 随机操作次数
     */
    private Integer number;

    /**
     * 操作用户
     */
    private String userId;

    /**
     * 所抽等级 N,R,SR,SSR,SP
     */
    private Integer extract;

}
