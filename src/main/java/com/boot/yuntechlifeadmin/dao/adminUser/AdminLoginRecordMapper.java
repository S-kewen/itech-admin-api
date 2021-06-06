package com.boot.yuntechlifeadmin.dao.adminUser;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminLoginRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: LoginRecordMapper
 * @Description: dao
 * @Date: 2020-03-27
 */
@Mapper
public interface AdminLoginRecordMapper {
    AdminLoginRecord getByIp(AdminLoginRecord adminLoginRecord);
    int insertOne(AdminLoginRecord adminLoginRecord);
    List<AdminLoginRecord> getList(AdminUser adminUser);
    int deleteOne(AdminLoginRecord adminLoginRecord);
    int deleteMore(AdminLoginRecord adminLoginRecord);
}