package com.boot.yuntechlifeadmin.service.impl.school;

import com.boot.yuntechlifeadmin.dao.school.YuntechExpressMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.school.YuntechExpress;
import com.boot.yuntechlifeadmin.entity.user.User;
import com.boot.yuntechlifeadmin.service.school.YuntechExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: ExpressIntegralServiceImpl
 * @Description: service
 * @Date: 2020-03-15
 */
@Component
public class YuntechExpressServiceImpl implements YuntechExpressService {
    @Autowired
    private YuntechExpressMapper yuntechExpressMapper;

    @Override
    public int insertOne(YuntechExpress yuntechExpress) {
        return yuntechExpressMapper.insertOne(yuntechExpress);
    }

    @Override
    public int getCount(YuntechExpress yuntechExpress) {
        return yuntechExpressMapper.getCount(yuntechExpress);
    }

    @Override
    public int updateOne(YuntechExpress yuntechExpress) {
        return yuntechExpressMapper.updateOne(yuntechExpress);
    }

    @Override
    public List<YuntechExpress> getList(AdminUser adminUser) {
        return yuntechExpressMapper.getList(adminUser);
    }

    @Override
    public List<YuntechExpress> getListByTask(User user) {
        return yuntechExpressMapper.getListByTask(user);
    }


    @Override
    public int deleteOne(YuntechExpress yuntechExpress) {
        return yuntechExpressMapper.deleteOne(yuntechExpress);
    }

    @Override
    public int deleteMore(YuntechExpress yuntechExpress) {
        return yuntechExpressMapper.deleteMore(yuntechExpress);
    }
}
