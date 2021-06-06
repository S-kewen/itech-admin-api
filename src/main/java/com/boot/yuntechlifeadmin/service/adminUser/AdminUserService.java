package com.boot.yuntechlifeadmin.service.adminUser;
/**
 * @Author: skwen
 * @ClassName: AdminUserService
 * @Description: interface
 * @Date: 2020-03-27
 */
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;

public interface AdminUserService {
    AdminUser getById(AdminUser adminUser);

    AdminUser getByUsername(AdminUser adminUser);

    AdminUser userLogin(AdminUser adminUser);

    int updateById(AdminUser adminUser);

    int insertOne(AdminUser adminUser);

    int getCount(AdminUser adminUser);
}
