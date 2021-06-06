package com.boot.yuntechlifeadmin.dao.school;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.school.YuntechExpress;
import com.boot.yuntechlifeadmin.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: YuntechExpressMapper
 * @Description: dao
 * @Date: 2020-03-18
 */
@Mapper
public interface YuntechExpressMapper {
    int insertOne(YuntechExpress yuntechExpress);

    int getCount(YuntechExpress yuntechExpress);

    int updateOne(YuntechExpress yuntechExpress);

    List<YuntechExpress> getList(AdminUser adminUser);

    List<YuntechExpress> getListByTask(User user);

    int deleteOne(YuntechExpress yuntechExpress);

    int deleteMore(YuntechExpress yuntechExpress);
}