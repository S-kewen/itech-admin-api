package com.boot.yuntechlifeadmin.service.adminUser;
/**
 * @Author: skwen
 * @ClassName: NewsService
 * @Description: interface
 * @Date: 2020-03-29
 */
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminNews;

import java.util.List;

public interface AdminNewsService {
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
