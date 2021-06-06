package com.boot.yuntechlifeadmin.service.user;
/**
 * @Author: skwen
 * @ClassName: LoginRecordService
 * @Description: interface
 * @Date: 2020-03-31
 */
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminLoginRecord;
import com.boot.yuntechlifeadmin.entity.user.LoginRecord;

import java.util.List;

public interface LoginRecordService {
    LoginRecord getByIp(LoginRecord loginRecord);

    int insertOne(LoginRecord loginRecord);

    List<LoginRecord> getList(AdminUser adminUser);

    int deleteOne(LoginRecord loginRecord);

    int deleteMore(LoginRecord loginRecord);
}
