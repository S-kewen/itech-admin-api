package com.boot.yuntechlifeadmin.service.flow;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlow;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowSet;
import com.boot.yuntechlifeadmin.entity.user.Transaction;
import com.boot.yuntechlifeadmin.entity.user.User;

import java.util.List;

public interface YuntechFlowService {
    int insertOne(YuntechFlow yuntechFlow);

    List<YuntechFlow> getList(AdminUser adminUser);

    int deleteOne(YuntechFlow yuntechFlow);

    List<YuntechFlow> getDayInfoByWeek(YuntechFlow yuntechFlow);

    YuntechFlow getSumByIp(YuntechFlow yuntechFlow);

    int getDayNumByIp(YuntechFlow yuntechFlow);

    List<YuntechFlow> getListByDay(AdminUser adminUser);

    YuntechFlow getByIp(YuntechFlow yuntechFlow);

    int deleteMore(YuntechFlow yuntechFlow);
}
