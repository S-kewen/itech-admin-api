package com.boot.yuntechlifeadmin.service.user;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.Card;
import com.boot.yuntechlifeadmin.entity.user.RechargeRecord;

import java.util.List;

public interface RechargeRecordService {
    List<RechargeRecord> getList(AdminUser adminUser);
    int deleteOne(RechargeRecord rechargeRecord);
    int deleteMore(RechargeRecord rechargeRecord);
    int updateOne(RechargeRecord rechargeRecord);
    int updateMore(RechargeRecord rechargeRecord);
}
