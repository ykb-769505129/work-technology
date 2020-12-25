package com.example.pojo;

import lombok.Data;

@Data
public class Device {

    private Integer pageNo;

    private Integer pageSize;

    private String type;

    private String deviceName;

    private String deviceCode;

    private String alarmType;

    private String alarmTimeStart;

    private String alarmtimeEnd;

}
