package com.boot.yuntechlifeadmin.service.express;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.express.ExpressIntegral;
import com.boot.yuntechlifeadmin.entity.express.ExpressTaker;
import com.boot.yuntechlifeadmin.entity.user.User;

import java.util.List;

public interface ExpressIntegralService {
    ExpressIntegral getByUserId(ExpressIntegral expressIntegral);
    List<ExpressIntegral> getList(AdminUser adminUser);
    int deleteOne(ExpressIntegral expressIntegral);
    int deleteMore(ExpressIntegral expressIntegral);
    int updateOne(ExpressIntegral expressIntegral);
    int updateMore(ExpressIntegral expressIntegral);
}
