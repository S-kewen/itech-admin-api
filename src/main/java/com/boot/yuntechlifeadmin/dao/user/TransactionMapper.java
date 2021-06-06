package com.boot.yuntechlifeadmin.dao.user;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.Transaction;
import com.boot.yuntechlifeadmin.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: TransactionMapper
 * @Description: dao
 * @Date: 2020-03-10
 */
@Mapper
public interface TransactionMapper {
    int insertOne(Transaction transaction);

    List<Transaction> getList(AdminUser adminUser);

    int deleteOne(Transaction transaction);

    int deleteMore(Transaction transaction);
}