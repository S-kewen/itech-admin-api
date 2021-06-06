package com.boot.yuntechlifeadmin.service.impl.system;

import com.boot.yuntechlifeadmin.dao.system.SystemLogMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.SystemLog;
import com.boot.yuntechlifeadmin.service.system.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: SystemLogServiceImpl
 * @Description: Service
 * @Date: 2020-04-06
 */
@Component
public class SystemLogServiceImpl implements SystemLogService {
    @Autowired
    private SystemLogMapper systemLogMapper;

    @Override
    public List<SystemLog> getList(AdminUser adminUser) {
        return systemLogMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(SystemLog systemLog) {
        return systemLogMapper.deleteOne(systemLog);
    }

    @Override
    public int deleteMore(SystemLog systemLog) {
        return systemLogMapper.deleteMore(systemLog);
    }

    @Override
    public int updateOne(SystemLog systemLog) {
        return systemLogMapper.updateOne(systemLog);
    }

    @Override
    public int updateMore(SystemLog systemLog) {
        return systemLogMapper.updateMore(systemLog);
    }

    @Override
    public int insertOne(SystemLog systemLog) {
        return systemLogMapper.insertOne(systemLog);
    }

    @Override
    public SystemLog getInfo(SystemLog systemLog) {
        return systemLogMapper.getInfo(systemLog);
    }

}

