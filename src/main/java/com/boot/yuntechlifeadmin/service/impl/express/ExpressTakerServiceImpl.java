package com.boot.yuntechlifeadmin.service.impl.express;

import com.boot.yuntechlifeadmin.dao.express.ExpressTakerMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.express.ExpressTaker;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import com.boot.yuntechlifeadmin.entity.user.User;
import com.boot.yuntechlifeadmin.service.express.ExpressTakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: ExpressTakerServiceImpl
 * @Description: service
 * @Date: 2020-03-15
 */
@Component
public class ExpressTakerServiceImpl implements ExpressTakerService {
    @Autowired
    private ExpressTakerMapper expressTakerMapper;

    @Override
    public List<ExpressTaker> getList(AdminUser adminUser) {
        return expressTakerMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(ExpressTaker expressTaker) {
        return expressTakerMapper.deleteOne(expressTaker);
    }

    @Override
    public int deleteMore(ExpressTaker expressTaker) {
        return expressTakerMapper.deleteMore(expressTaker);
    }

    @Override
    public int updateOne(ExpressTaker expressTaker) {
        return expressTakerMapper.updateOne(expressTaker);
    }

    @Override
    public int updateMore(ExpressTaker expressTaker) {
        return expressTakerMapper.updateMore(expressTaker);
    }
    @Override
    public ExpressTaker getInfo(ExpressTaker expressTaker) {
        return expressTakerMapper.getInfo(expressTaker);
    }
}
