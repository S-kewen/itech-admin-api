package com.boot.yuntechlifeadmin.entity.adminUser;

import lombok.Data;

import java.util.Date;

/**
 * @Author: skwen
 * @ClassName: AdminUser
 * @Description: entity
 * @Date: 2020-03-27
 */
@Data
public class AdminUser {
    private int id;
    private String username;
    private String password;
    private int state;
    private int type;
    private Date release_time;
    private String salt;
    private String email;
    private String phone;
    private String avatar;
    private String remark;
    private String add_time;
    //以上來自sql
    private String sortName;
    private String sortOrder;
    private String keyword;
    private Date startTime;
    private Date endTime;
    private String express_name;
    private int express_type;
    private int take_points;
    private int region;
    private int verified_state;
    private int anonymous;
    private int top;
    private int service_id;
}
