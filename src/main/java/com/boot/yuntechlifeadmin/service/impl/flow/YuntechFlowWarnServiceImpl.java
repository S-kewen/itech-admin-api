package com.boot.yuntechlifeadmin.service.impl.flow;

import com.boot.yuntechlifeadmin.dao.flow.YuntechFlowSetMapper;
import com.boot.yuntechlifeadmin.dao.flow.YuntechFlowWarnMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowSet;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowWarn;
import com.boot.yuntechlifeadmin.entity.user.User;
import com.boot.yuntechlifeadmin.service.flow.YuntechFlowSetService;
import com.boot.yuntechlifeadmin.service.flow.YuntechFlowWarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: YuntechFlowWarnServiceImpl
 * @Description: Service
 * @Date: 2020-03-10
 */
@Component
public class YuntechFlowWarnServiceImpl implements YuntechFlowWarnService {
    @Autowired
    private YuntechFlowWarnMapper yuntechFlowWarnMapper;

    @Override
    public int insertOne(YuntechFlowWarn yuntechFlowWarn) {
        return yuntechFlowWarnMapper.insertOne(yuntechFlowWarn);
    }

    @Override
    public List<YuntechFlowWarn> getList(AdminUser adminUser) {
        return yuntechFlowWarnMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(YuntechFlowWarn yuntechFlowWarn) {
        return yuntechFlowWarnMapper.deleteOne(yuntechFlowWarn);
    }

    @Override
    public int updateOne(YuntechFlowWarn yuntechFlowWarn) {
        return yuntechFlowWarnMapper.updateOne(yuntechFlowWarn);
    }

    @Override
    public List<YuntechFlowWarn> disposeWarn(YuntechFlowWarn yuntechFlowWarn) {
        return yuntechFlowWarnMapper.disposeWarn(yuntechFlowWarn);
    }

    @Override
    public int deleteMore(YuntechFlowWarn yuntechFlowWarn) {
        return yuntechFlowWarnMapper.deleteMore(yuntechFlowWarn);
    }

}
