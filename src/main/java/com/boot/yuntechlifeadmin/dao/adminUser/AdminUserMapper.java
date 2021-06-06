package com.boot.yuntechlifeadmin.dao.adminUser;


import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: skwen
 * @ClassName: AdminUserMapper
 * @Description: dao
 * @Date: 2020-03-27
 */
@Mapper
public interface AdminUserMapper {
    AdminUser getById(AdminUser adminUser);

    AdminUser getByUsername(AdminUser adminUser);

    AdminUser userLogin(AdminUser adminUser);

    int updateById(AdminUser adminUser);

    int insertOne(AdminUser adminUser);

    int getCount(AdminUser adminUser);
}