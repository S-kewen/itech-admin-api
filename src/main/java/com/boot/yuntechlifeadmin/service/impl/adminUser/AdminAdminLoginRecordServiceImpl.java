package com.boot.yuntechlifeadmin.service.impl.adminUser;

import com.boot.yuntechlifeadmin.dao.adminUser.AdminLoginRecordMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminLoginRecord;
import com.boot.yuntechlifeadmin.service.adminUser.AdminLoginRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: LoginRecordServiceImpl
 * @Description: Service
 * @Date: 2020-03-29
 */
@Component
public class AdminAdminLoginRecordServiceImpl implements AdminLoginRecordService {
    @Autowired
    private AdminLoginRecordMapper loginRecordMapper;

    @Override
    public AdminLoginRecord getByIp(AdminLoginRecord adminLoginRecord) {
        return loginRecordMapper.getByIp(adminLoginRecord);
    }

    @Override
    public int insertOne(AdminLoginRecord adminLoginRecord) {
        return loginRecordMapper.insertOne(adminLoginRecord);
    }

    @Override
    public List<AdminLoginRecord> getList(AdminUser adminUser) {
        return loginRecordMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(AdminLoginRecord adminLoginRecord) {
        return loginRecordMapper.deleteOne(adminLoginRecord);
    }
    @Override
    public int deleteMore(AdminLoginRecord adminLoginRecord) {
        return loginRecordMapper.deleteMore(adminLoginRecord);
    }

}
