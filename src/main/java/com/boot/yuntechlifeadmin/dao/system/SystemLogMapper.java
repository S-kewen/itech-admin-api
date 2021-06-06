package com.boot.yuntechlifeadmin.dao.system;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.SystemLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: SystemLogMapper
 * @Description: dao
 * @Date: 2020-04-06
 */
@Mapper
public interface SystemLogMapper {
    List<SystemLog> getList(AdminUser adminUser);
    int deleteOne(SystemLog systemLog);
    int deleteMore(SystemLog systemLog);
    int updateOne(SystemLog systemLog);
    int updateMore(SystemLog systemLog);
    int insertOne(SystemLog systemLog);
    SystemLog getInfo(SystemLog systemLog);
}