package com.boot.yuntechlifeadmin.dao.user;

import com.boot.yuntechlifeadmin.entity.user.User;
import com.boot.yuntechlifeadmin.entity.user.UserIndex;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: skwen
 * @ClassName: UserIndexMapper
 * @Description: 个人中心dao
 * @Date: 2020-03-09
 */
@Mapper
public interface UserIndexMapper {
    UserIndex getByUserId(User user);
}