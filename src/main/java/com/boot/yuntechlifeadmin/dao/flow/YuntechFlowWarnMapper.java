package com.boot.yuntechlifeadmin.dao.flow;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowSet;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowWarn;
import com.boot.yuntechlifeadmin.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: YuntechFlowWarnMapper
 * @Description: dao
 * @Date: 2020-03-10
 */
@Mapper
public interface YuntechFlowWarnMapper {
    int insertOne(YuntechFlowWarn yuntechFlowWarn);

    List<YuntechFlowWarn> getList(AdminUser adminUser);

    int deleteOne(YuntechFlowWarn yuntechFlowWarn);

    int updateOne(YuntechFlowWarn yuntechFlowWarn);

    List<YuntechFlowWarn> disposeWarn(YuntechFlowWarn yuntechFlowWarn);

    int deleteMore(YuntechFlowWarn yuntechFlowWarn);
}