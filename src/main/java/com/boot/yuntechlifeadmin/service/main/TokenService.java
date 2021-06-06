package com.boot.yuntechlifeadmin.service.main;

import com.boot.yuntechlifeadmin.entity.main.Token;

/**
 * @Author: skwen
 * ClassName: TokenService
 * @Description: interface
 * @Date: 2020-03-27
 */
public interface TokenService {
    String createToken(Token token);

    Token parseToken(String tokenStr);


}
