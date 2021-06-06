package com.boot.yuntechlifeadmin.entity.express;

import lombok.Data;

import java.util.Date;

/**
 * @Author: skwen
 * @ClassName: ExpressScore
 * @Description: 實體類
 * @Date: 2020-03-16
 */
@Data
public class ExpressScore {
    private int id;
    private int user_id;
    private int from_user_id;
    private int express_taker_id;
    private int state;
    private int type;
    private int anonymous;
    private int score;
    private String comments;
    private boolean deleted;
    private Date add_time;
    //以上來自sql
    private String username;
    private int [] ids;
}
