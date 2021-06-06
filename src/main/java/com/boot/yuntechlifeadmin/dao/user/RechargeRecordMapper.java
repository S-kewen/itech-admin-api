package com.boot.yuntechlifeadmin.dao.user;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.Card;
import com.boot.yuntechlifeadmin.entity.user.RechargeRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName:RechargeRecordMapper
 * @Description: dao
 * @Date: 2020-03-14
 */
@Mapper
public interface RechargeRecordMapper {
    List<RechargeRecord> getList(AdminUser adminUser);
    int deleteOne(RechargeRecord rechargeRecord);
    int deleteMore(RechargeRecord rechargeRecord);
    int updateOne(RechargeRecord rechargeRecord);
    int updateMore(RechargeRecord rechargeRecord);
}