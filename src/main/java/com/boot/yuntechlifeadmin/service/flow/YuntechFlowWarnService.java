package com.boot.yuntechlifeadmin.service.flow;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlow;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowSet;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowWarn;
import com.boot.yuntechlifeadmin.entity.user.User;

import java.util.List;

public interface YuntechFlowWarnService {
    int insertOne(YuntechFlowWarn yuntechFlowWarn);

    List<YuntechFlowWarn> getList(AdminUser adminUser);

    int deleteOne(YuntechFlowWarn yuntechFlowWarn);

    int updateOne(YuntechFlowWarn yuntechFlowWarn);

    List<YuntechFlowWarn> disposeWarn(YuntechFlowWarn yuntechFlowWarn);

    int deleteMore(YuntechFlowWarn yuntechFlowWarn);
}
