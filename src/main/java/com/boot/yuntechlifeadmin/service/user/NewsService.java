package com.boot.yuntechlifeadmin.service.user;
/**
 * @Author: skwen
 * @ClassName: LoginRecordService
 * @Description: interface
 * @Date: 2020-03-31
 */
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.LoginRecord;
import com.boot.yuntechlifeadmin.entity.user.News;

import java.util.List;

public interface NewsService {
    int insertOne(News news);

    List<News> getList(AdminUser adminUser);

    int deleteOne(News news);

    int deleteMore(News news);
}
