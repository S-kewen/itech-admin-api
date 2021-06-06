package com.boot.yuntechlifeadmin.service.impl.user;

import com.boot.yuntechlifeadmin.dao.user.CardMapper;
import com.boot.yuntechlifeadmin.dao.user.RechargeRecordMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.Card;
import com.boot.yuntechlifeadmin.entity.user.RechargeRecord;
import com.boot.yuntechlifeadmin.service.user.CardService;
import com.boot.yuntechlifeadmin.service.user.RechargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: RechargeRecordServiceImpl
 * @Description: Service
 * @Date: 2020-03-14
 */
@Component
public class RechargeRecordServiceImpl implements RechargeRecordService {
    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;

    @Override
    public List<RechargeRecord> getList(AdminUser adminUser) {
        return rechargeRecordMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(RechargeRecord rechargeRecord) {
        return rechargeRecordMapper.deleteOne(rechargeRecord);
    }

    @Override
    public int deleteMore(RechargeRecord rechargeRecord) {
        return rechargeRecordMapper.deleteMore(rechargeRecord);
    }

    @Override
    public int updateOne(RechargeRecord rechargeRecord) {
        return rechargeRecordMapper.updateOne(rechargeRecord);
    }

    @Override
    public int updateMore(RechargeRecord rechargeRecord) {
        return rechargeRecordMapper.updateMore(rechargeRecord);
    }

}
