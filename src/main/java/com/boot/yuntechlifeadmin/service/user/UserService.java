package com.boot.yuntechlifeadmin.service.user;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getById(User user);

    User getByUsername(User user);

    User userLogin(User user);

    int updateById(User user);

    int insertOne(User user);

    int getCount(User user);

    int updateByUsername(User user);

    List<Map<String, Object>> getCountByWeek(User user);

    List<User> getList(AdminUser adminUser);

    int updateMore(User user);

    List<User> getListByCertification(AdminUser adminUser);
}
