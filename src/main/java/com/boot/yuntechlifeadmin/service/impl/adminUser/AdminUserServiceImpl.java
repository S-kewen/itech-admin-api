package com.boot.yuntechlifeadmin.service.impl.adminUser;

import com.boot.yuntechlifeadmin.dao.adminUser.AdminUserMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.service.adminUser.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: skwen
 * @ClassName: AdminUserServiceImpl
 * @Description: service
 * @Date: 2020-03-27
 */
@Component
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser getById(AdminUser adminUser) {
        return adminUserMapper.getById(adminUser);
    }

    @Override
    public AdminUser getByUsername(AdminUser adminUser) {
        return adminUserMapper.getByUsername(adminUser);
    }

    @Override
    public AdminUser userLogin(AdminUser adminUser) {
        return adminUserMapper.userLogin(adminUser);
    }

    @Override
    public int updateById(AdminUser adminUser) {
        return adminUserMapper.updateById(adminUser);
    }

    @Override
    public int insertOne(AdminUser adminUser) {
        return adminUserMapper.insertOne(adminUser);
    }

    @Override
    public int getCount(AdminUser adminUser) {
        return adminUserMapper.getCount(adminUser);
    }
}
