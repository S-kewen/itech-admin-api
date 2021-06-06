package com.boot.yuntechlifeadmin.entity.adminUser;

import lombok.Data;

import java.util.Date;

/**
 * @Author: skwen
 * @ClassName: News
 * @Description: entity
 * @Date: 2020-03-27
 */
@Data
public class AdminNews {
    private int id;
    private int user_id;
    private int state;
    private int type;
    private String sender;
    private String title;
    private String msg;
    private boolean deleted;
    private Date add_time;
    //以上來自sql
    private int [] ids;
}
