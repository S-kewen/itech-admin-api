package com.boot.yuntechlifeadmin.service.flow;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlow;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowSet;
import com.boot.yuntechlifeadmin.entity.user.User;

import java.util.List;

public interface YuntechFlowSetService {
    int insertOne(YuntechFlowSet yuntechFlowSet);

    List<YuntechFlowSet> getList(AdminUser adminUser);

    int deleteOne(YuntechFlowSet yuntechFlowSet);

    int getCount(YuntechFlowSet yuntechFlowSet);

    int updateOne(YuntechFlowSet yuntechFlowSet);

    YuntechFlowSet getById(YuntechFlowSet yuntechFlowSet);

    int deleteMore(YuntechFlowSet yuntechFlowSet);

    int updateMore(YuntechFlowSet yuntechFlowSet);
}
