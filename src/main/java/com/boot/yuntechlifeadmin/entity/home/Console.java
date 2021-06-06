package com.boot.yuntechlifeadmin.entity.home;

import lombok.Data;

import java.util.Date;

/**
 * @Author: skwen
 * @ClassName: ConsoleInfo
 * @Description: entity
 * @Date: 2020-03-28
 */
@Data
public class Console {
    private int service_id;
    private String site_id;
    private int today_pv_count;
    private float all_pv_count;
    private int user_count;
    private int user_active_count;
    private int today_income;
    private int all_income;
    private int uncomplete_order_count;
    private int order_count;
    private float cpu;
    private float ram;
    private int yesterday_user_count;
    private int certification_user_count;
    private Date now_date;
}
