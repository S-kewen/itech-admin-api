package com.boot.yuntechlifeadmin.dao.flow;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlow;
import com.boot.yuntechlifeadmin.entity.user.Transaction;
import com.boot.yuntechlifeadmin.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: YuntechFlowMapper
 * @Description: dao
 * @Date: 2020-03-10
 */
@Mapper
public interface YuntechFlowMapper {
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