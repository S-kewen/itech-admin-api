package com.boot.yuntechlifeadmin.service.impl.flow;

import com.boot.yuntechlifeadmin.dao.flow.YuntechFlowConfigMapper;
import com.boot.yuntechlifeadmin.dao.flow.YuntechFlowSetMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowConfig;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowSet;
import com.boot.yuntechlifeadmin.entity.user.User;
import com.boot.yuntechlifeadmin.service.flow.YuntechFlowConfigService;
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
public class YuntechFlowConfigServiceImpl implements YuntechFlowConfigService {
    @Autowired
    private YuntechFlowConfigMapper yuntechFlowConfigMapper;

    @Override
    public YuntechFlowConfig getById(YuntechFlowConfig yuntechFlowConfig) {
        return yuntechFlowConfigMapper.getById(yuntechFlowConfig);
    }
    @Override
    public List<YuntechFlowConfig> getList(AdminUser adminUser) {
        return yuntechFlowConfigMapper.getList(adminUser);
    }
    @Override
    public int updateMore(YuntechFlowConfig yuntechFlowConfig) {
        return yuntechFlowConfigMapper.updateMore(yuntechFlowConfig);
    }
    @Override
    public int updateOne(YuntechFlowConfig yuntechFlowConfig) {
        return yuntechFlowConfigMapper.updateOne(yuntechFlowConfig);
    }
}
