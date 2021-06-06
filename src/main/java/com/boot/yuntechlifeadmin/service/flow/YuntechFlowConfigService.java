package com.boot.yuntechlifeadmin.service.flow;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowConfig;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowSet;
import com.boot.yuntechlifeadmin.entity.user.User;

import java.util.List;

public interface YuntechFlowConfigService {
    YuntechFlowConfig getById(YuntechFlowConfig yuntechFlowConfig);
    List<YuntechFlowConfig> getList(AdminUser adminUser);
    int updateMore(YuntechFlowConfig yuntechFlowConfig);
    int updateOne(YuntechFlowConfig yuntechFlowConfig);
}
