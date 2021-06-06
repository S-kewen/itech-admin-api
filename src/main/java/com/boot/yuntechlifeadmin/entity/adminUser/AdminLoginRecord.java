package com.boot.yuntechlifeadmin.entity.adminUser;

import lombok.Data;

import java.util.Date;

/**
 * @Author: skwen
 * @ClassName: AdminLoginRecord
 * @Description: entity
 * @Date: 2020-03-27
 */
@Data
public class AdminLoginRecord {
    private int id;
    private int user_id;
    private int state;
    private int type;
    private String ip;
    private String position;
    private float longitude;
    private float latitude;
    private String system;
    private String browser;
    private String header;
    private String token;
    private boolean deleted;
    private Date add_time;
    //以上來自sql
    private int [] ids;
}
