package com.boot.yuntechlifeadmin.service.user;

import com.boot.yuntechlifeadmin.entity.user.User;
import com.boot.yuntechlifeadmin.entity.user.UserIndex;

public interface UserIndexService {
    UserIndex getByUserId(User user);
}
