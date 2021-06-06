package com.boot.yuntechlifeadmin.dao.user;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.LoginRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: LoginRecordMapper
 * @Description: dao
 * @Date: 2020-03-31
 */
@Mapper
public interface LoginRecordMapper {
    LoginRecord getByIp(LoginRecord loginRecord);
    int insertOne(LoginRecord loginRecord);
    List<LoginRecord> getList(AdminUser adminUser);
    int deleteOne(LoginRecord loginRecord);
    int deleteMore(LoginRecord loginRecord);
}