package com.boot.yuntechlifeadmin.service.impl.flow;

import com.boot.yuntechlifeadmin.dao.flow.YuntechFlowMapper;
import com.boot.yuntechlifeadmin.dao.user.TransactionMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlow;
import com.boot.yuntechlifeadmin.entity.user.Transaction;
import com.boot.yuntechlifeadmin.entity.user.User;
import com.boot.yuntechlifeadmin.service.flow.YuntechFlowService;
import com.boot.yuntechlifeadmin.service.user.TransactionService;
import com.boot.yuntechlifeadmin.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: YuntechFlowServiceImpl
 * @Description: Service
 * @Date: 2020-03-10
 */
@Component
public class YuntechFlowServiceImpl implements YuntechFlowService {
    @Autowired
    private YuntechFlowMapper yuntechFlowMapper;

    @Override
    public int insertOne(YuntechFlow yuntechFlow) {
        return yuntechFlowMapper.insertOne(yuntechFlow);
    }

    @Override
    public List<YuntechFlow> getList(AdminUser adminUser) {
        return yuntechFlowMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(YuntechFlow yuntechFlow) {
        return yuntechFlowMapper.deleteOne(yuntechFlow);
    }

    @Override
    public List<YuntechFlow> getDayInfoByWeek(YuntechFlow yuntechFlow) {
        return yuntechFlowMapper.getDayInfoByWeek(yuntechFlow);
    }

    @Override
    public YuntechFlow getSumByIp(YuntechFlow yuntechFlow) {
        return yuntechFlowMapper.getSumByIp(yuntechFlow);
    }

    @Override
    public int getDayNumByIp(YuntechFlow yuntechFlow) {
        return yuntechFlowMapper.getDayNumByIp(yuntechFlow);
    }

    @Override
    public List<YuntechFlow> getListByDay(AdminUser adminUser) {
        return yuntechFlowMapper.getListByDay(adminUser);
    }

    @Override
    public YuntechFlow getByIp(YuntechFlow yuntechFlow) {
        return yuntechFlowMapper.getByIp(yuntechFlow);
    }
    @Override
    public int deleteMore(YuntechFlow yuntechFlow) {
        return yuntechFlowMapper.deleteMore(yuntechFlow);
    }
}
