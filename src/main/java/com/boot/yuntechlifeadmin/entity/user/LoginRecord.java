package com.boot.yuntechlifeadmin.entity.user;

import lombok.Data;

import java.util.Date;

/**
 * @Author: skwen
 * @ClassName: LoginRecord
 * @Description: entity
 * @Date: 2020-03-27
 */
@Data
public class LoginRecord {
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
    private boolean deleted;
    private Date add_time;
    //以上來自sql
    private int [] ids;
    private String username;
}
