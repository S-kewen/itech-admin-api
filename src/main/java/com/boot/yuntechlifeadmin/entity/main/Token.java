package com.boot.yuntechlifeadmin.entity.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: skwen
 * ClassName: Token
 * @Description: entity
 * @Date: 2020-03-27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    private int id;
    private String username;
    private String password;
    private String role;
    private String ip;
    private Date add_time;
    private Date expire_time;
}
