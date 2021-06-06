package com.boot.yuntechlifeadmin.dao.user;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.LoginRecord;
import com.boot.yuntechlifeadmin.entity.user.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: NewsMapper
 * @Description: dao
 * @Date: 2020-03-31
 */
@Mapper
public interface NewsMapper {
    int insertOne(News news);
    List<News> getList(AdminUser adminUser);
    int deleteOne(News news);
    int deleteMore(News news);
}