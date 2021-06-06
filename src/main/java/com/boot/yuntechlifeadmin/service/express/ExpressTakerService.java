package com.boot.yuntechlifeadmin.service.express;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.express.ExpressTaker;
import com.boot.yuntechlifeadmin.entity.user.User;

import java.util.List;

public interface ExpressTakerService {
    List<ExpressTaker> getList(AdminUser adminUser);
    int deleteOne(ExpressTaker expressTaker);
    int deleteMore(ExpressTaker expressTaker);
    int updateOne(ExpressTaker expressTaker);
    int updateMore(ExpressTaker expressTaker);
    ExpressTaker getInfo(ExpressTaker expressTaker);
}
