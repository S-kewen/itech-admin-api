package com.boot.yuntechlifeadmin.service.system;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.SystemLog;

import java.util.List;

public interface SystemLogService {
    List<SystemLog> getList(AdminUser adminUser);
    int deleteOne(SystemLog systemLog);
    int deleteMore(SystemLog systemLog);
    int updateOne(SystemLog systemLog);
    int updateMore(SystemLog systemLog);
    int insertOne(SystemLog systemLog);
    SystemLog getInfo(SystemLog systemLog);
}
