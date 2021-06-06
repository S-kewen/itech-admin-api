package com.boot.yuntechlifeadmin.dao.flow;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlow;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowSet;
import com.boot.yuntechlifeadmin.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: YuntechFlowSetMapper
 * @Description: dao
 * @Date: 2020-03-10
 */
@Mapper
public interface YuntechFlowSetMapper {
    int insertOne(YuntechFlowSet yuntechFlowSet);

    List<YuntechFlowSet> getList(AdminUser adminUser);

    int deleteOne(YuntechFlowSet yuntechFlowSet);

    int getCount(YuntechFlowSet yuntechFlowSet);

    int updateOne(YuntechFlowSet yuntechFlowSet);

    YuntechFlowSet getById(YuntechFlowSet yuntechFlowSet);

    int deleteMore(YuntechFlowSet yuntechFlowSet);

    int updateMore(YuntechFlowSet yuntechFlowSet);
}