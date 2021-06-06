package com.boot.yuntechlifeadmin.service.impl.user;

import com.boot.yuntechlifeadmin.dao.user.LoginRecordMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.LoginRecord;
import com.boot.yuntechlifeadmin.service.user.LoginRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: LoginRecordServiceImpl
 * @Description: Service
 * @Date: 2020-03-31
 */
@Component
public class LoginRecordServiceImpl implements LoginRecordService {
    @Autowired
    private LoginRecordMapper loginRecordMapper;

    @Override
    public LoginRecord getByIp(LoginRecord loginRecord) {
        return loginRecordMapper.getByIp(loginRecord);
    }

    @Override
    public int insertOne(LoginRecord loginRecord) {
        return loginRecordMapper.insertOne(loginRecord);
    }

    @Override
    public List<LoginRecord> getList(AdminUser adminUser) {
        return loginRecordMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(LoginRecord loginRecord) {
        return loginRecordMapper.deleteOne(loginRecord);
    }
    @Override
    public int deleteMore(LoginRecord loginRecord) {
        return loginRecordMapper.deleteMore(loginRecord);
    }

}
