package com.boot.yuntechlifeadmin.service.user;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.Transaction;
import com.boot.yuntechlifeadmin.entity.user.User;

import java.util.List;

public interface TransactionService {
    int insertOne(Transaction transaction);

    List<Transaction> getList(AdminUser adminUser);

    int deleteOne(Transaction transaction);

    int deleteMore(Transaction transaction);
}
