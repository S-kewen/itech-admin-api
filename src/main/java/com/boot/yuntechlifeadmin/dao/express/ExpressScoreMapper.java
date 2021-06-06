package com.boot.yuntechlifeadmin.dao.express;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.express.ExpressIntegral;
import com.boot.yuntechlifeadmin.entity.express.ExpressScore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: ExpressScoreMapper
 * @Description: dao
 * @Date: 2020-03-16
 */
@Mapper
public interface ExpressScoreMapper {
    int insertOne(ExpressScore expressScore);
    List<ExpressScore> getList(AdminUser adminUser);
    int deleteOne(ExpressScore expressScore);
    int deleteMore(ExpressScore expressScore);
}