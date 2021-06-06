package com.boot.yuntechlifeadmin.dao.adminUser;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminNews;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: NewsMapper
 * @Description: dao
 * @Date: 2020-03-29
 */
@Mapper
public interface AdminNewsMapper {
    int insertOne(AdminNews adminNews);

    int getCount(AdminNews adminNews);

    List<AdminNews> getList(AdminUser adminUser);

    int deleteById(AdminNews adminNews);

    int updateById(AdminNews adminNews);

    int updateByUserId(AdminNews adminNews);

    int allRead(AdminNews adminNews);

    int deleteMore(AdminNews adminNews);

    int updateMore(AdminNews adminNews);
}