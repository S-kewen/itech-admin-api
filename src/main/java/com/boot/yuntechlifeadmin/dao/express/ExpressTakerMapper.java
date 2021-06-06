package com.boot.yuntechlifeadmin.dao.express;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.express.ExpressTaker;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import com.boot.yuntechlifeadmin.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: ExpressTakerMapper
 * @Description: dao
 * @Date: 2020-03-15
 */
@Mapper
public interface ExpressTakerMapper {
    List<ExpressTaker> getList(AdminUser adminUser);
    int deleteOne(ExpressTaker expressTaker);
    int deleteMore(ExpressTaker expressTaker);
    int updateOne(ExpressTaker expressTaker);
    int updateMore(ExpressTaker expressTaker);
    ExpressTaker getInfo(ExpressTaker expressTaker);
}