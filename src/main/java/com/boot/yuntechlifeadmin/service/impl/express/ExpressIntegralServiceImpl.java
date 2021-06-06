package com.boot.yuntechlifeadmin.service.impl.express;

import com.boot.yuntechlifeadmin.dao.express.ExpressIntegralMapper;
import com.boot.yuntechlifeadmin.dao.express.ExpressTakerMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.express.ExpressIntegral;
import com.boot.yuntechlifeadmin.entity.express.ExpressTaker;
import com.boot.yuntechlifeadmin.entity.user.User;
import com.boot.yuntechlifeadmin.service.express.ExpressIntegralService;
import com.boot.yuntechlifeadmin.service.express.ExpressTakerService;
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
public class ExpressIntegralServiceImpl implements ExpressIntegralService {
    @Autowired
    private ExpressIntegralMapper expressIntegralMapper;

    @Override
    public ExpressIntegral getByUserId(ExpressIntegral expressIntegral) {
        return expressIntegralMapper.getByUserId(expressIntegral);
    }
    @Override
    public List<ExpressIntegral> getList(AdminUser adminUser) {
        return expressIntegralMapper.getList(adminUser);
    }
    @Override
    public int deleteOne(ExpressIntegral expressIntegral) {
        return expressIntegralMapper.deleteOne(expressIntegral);
    }
    @Override
    public int deleteMore(ExpressIntegral expressIntegral) {
        return expressIntegralMapper.deleteMore(expressIntegral);
    }
    @Override
    public int updateOne(ExpressIntegral expressIntegral) {
        return expressIntegralMapper.updateOne(expressIntegral);
    }
    @Override
    public int updateMore(ExpressIntegral expressIntegral) {
        return expressIntegralMapper.updateMore(expressIntegral);
    }
}
