package com.boot.yuntechlifeadmin.service.adminUser;
/**
 * @Author: skwen
 * @ClassName: AdminLoginRecordService
 * @Description: interface
 * @Date: 2020-03-29
 */
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminLoginRecord;

import java.util.List;

public interface AdminLoginRecordService {
    AdminLoginRecord getByIp(AdminLoginRecord adminLoginRecord);

    int insertOne(AdminLoginRecord adminLoginRecord);

    List<AdminLoginRecord> getList(AdminUser adminUser);

    int deleteOne(AdminLoginRecord adminLoginRecord);

    int deleteMore(AdminLoginRecord adminLoginRecord);
}
