package com.boot.yuntechlifeadmin.service.impl.express;

import com.boot.yuntechlifeadmin.dao.express.ExpressIntegralMapper;
import com.boot.yuntechlifeadmin.dao.express.ExpressScoreMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.express.ExpressIntegral;
import com.boot.yuntechlifeadmin.entity.express.ExpressScore;
import com.boot.yuntechlifeadmin.service.express.ExpressIntegralService;
import com.boot.yuntechlifeadmin.service.express.ExpressScoreService;
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
public class ExpressScoreServiceImpl implements ExpressScoreService {
    @Autowired
    private ExpressScoreMapper expressScoreMapper;

    @Override
    public int insertOne(ExpressScore expressScore) {
        return expressScoreMapper.insertOne(expressScore);
    }
    @Override
    public List<ExpressScore> getList(AdminUser adminUser) {
        return expressScoreMapper.getList(adminUser);
    }
    @Override
    public int deleteOne(ExpressScore expressScore) {
        return expressScoreMapper.deleteOne(expressScore);
    }
    @Override
    public int deleteMore(ExpressScore expressScore) {
        return expressScoreMapper.deleteMore(expressScore);
    }
}
