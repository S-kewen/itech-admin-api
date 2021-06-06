package com.boot.yuntechlifeadmin.dao.express;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.express.ExpressIntegral;
import com.boot.yuntechlifeadmin.entity.express.ExpressReceive;
import com.boot.yuntechlifeadmin.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: skwen
 * @ClassName: ExpressIntegralMapper
 * @Description: dao
 * @Date: 2020-03-16
 */
@Mapper
public interface ExpressIntegralMapper {
    ExpressIntegral getByUserId(ExpressIntegral expressIntegral);
    List<ExpressIntegral> getList(AdminUser adminUser);
    int deleteOne(ExpressIntegral expressIntegral);
    int deleteMore(ExpressIntegral expressIntegral);
    int updateOne(ExpressIntegral expressIntegral);
    int updateMore(ExpressIntegral expressIntegral);
}