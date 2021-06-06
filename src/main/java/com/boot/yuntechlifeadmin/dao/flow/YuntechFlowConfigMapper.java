package com.boot.yuntechlifeadmin.dao.flow;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowConfig;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowSet;
import com.boot.yuntechlifeadmin.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: YuntechFlowConfigMapper
 * @Description: dao
 * @Date: 2020-03-11
 */
@Mapper
public interface YuntechFlowConfigMapper {
    YuntechFlowConfig getById(YuntechFlowConfig yuntechFlowConfig);
    List<YuntechFlowConfig> getList(AdminUser adminUser);
    int updateMore(YuntechFlowConfig yuntechFlowConfig);
    int updateOne(YuntechFlowConfig yuntechFlowConfig);
}