package com.boot.yuntechlifeadmin.service.impl.user;

import com.boot.yuntechlifeadmin.dao.user.UserIndexMapper;
import com.boot.yuntechlifeadmin.entity.user.User;
import com.boot.yuntechlifeadmin.entity.user.UserIndex;
import com.boot.yuntechlifeadmin.service.user.UserIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: skwen
 * @ClassName: UserIndexServiceImpl
 * @Description: userIndexService
 * @Date: 2020-03-09
 */
@Component
public class UserIndexServiceImpl implements UserIndexService {
    @Autowired
    private UserIndexMapper userIndexMapper;

    @Override
    public UserIndex getByUserId(User user) {
        return userIndexMapper.getByUserId(user);
    }
}
