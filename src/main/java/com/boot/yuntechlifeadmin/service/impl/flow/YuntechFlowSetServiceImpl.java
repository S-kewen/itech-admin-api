package com.boot.yuntechlifeadmin.service.impl.flow;

import com.boot.yuntechlifeadmin.dao.flow.YuntechFlowMapper;
import com.boot.yuntechlifeadmin.dao.flow.YuntechFlowSetMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlow;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowSet;
import com.boot.yuntechlifeadmin.entity.user.User;
import com.boot.yuntechlifeadmin.service.flow.YuntechFlowService;
import com.boot.yuntechlifeadmin.service.flow.YuntechFlowSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: YuntechFlowSetServiceImpl
 * @Description: Service
 * @Date: 2020-03-10
 */
@Component
public class YuntechFlowSetServiceImpl implements YuntechFlowSetService {
    @Autowired
    private YuntechFlowSetMapper yuntechFlowSetMapper;

    @Override
    public int insertOne(YuntechFlowSet yuntechFlowSet) {
        return yuntechFlowSetMapper.insertOne(yuntechFlowSet);
    }

    @Override
    public List<YuntechFlowSet> getList(AdminUser adminUser) {
        return yuntechFlowSetMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(YuntechFlowSet yuntechFlowSet) {
        return yuntechFlowSetMapper.deleteOne(yuntechFlowSet);
    }

    @Override
    public int getCount(YuntechFlowSet yuntechFlowSet) {
        return yuntechFlowSetMapper.getCount(yuntechFlowSet);
    }

    @Override
    public int updateOne(YuntechFlowSet yuntechFlowSet) {
        return yuntechFlowSetMapper.updateOne(yuntechFlowSet);
    }

    @Override
    public YuntechFlowSet getById(YuntechFlowSet yuntechFlowSet) {
        return yuntechFlowSetMapper.getById(yuntechFlowSet);
    }

    @Override
    public int deleteMore(YuntechFlowSet yuntechFlowSet) {
        return yuntechFlowSetMapper.deleteMore(yuntechFlowSet);
    }

    @Override
    public int updateMore(YuntechFlowSet yuntechFlowSet) {
        return yuntechFlowSetMapper.updateMore(yuntechFlowSet);
    }
}
