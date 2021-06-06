package com.boot.yuntechlifeadmin.service.express;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.express.ExpressIntegral;
import com.boot.yuntechlifeadmin.entity.express.ExpressScore;

import java.util.List;

public interface ExpressScoreService {
    int insertOne(ExpressScore expressScore);
    List<ExpressScore> getList(AdminUser adminUser);
    int deleteOne(ExpressScore expressScore);
    int deleteMore(ExpressScore expressScore);
}
