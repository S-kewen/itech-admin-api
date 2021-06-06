package com.boot.yuntechlifeadmin.service.school;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.school.YuntechExpress;
import com.boot.yuntechlifeadmin.entity.user.User;

import java.util.List;

public interface YuntechExpressService {
    int insertOne(YuntechExpress yuntechExpress);

    int getCount(YuntechExpress yuntechExpress);

    int updateOne(YuntechExpress yuntechExpress);

    List<YuntechExpress> getList(AdminUser adminUser);

    List<YuntechExpress> getListByTask(User user);

    int deleteOne(YuntechExpress yuntechExpress);

    int deleteMore(YuntechExpress yuntechExpress);
}
