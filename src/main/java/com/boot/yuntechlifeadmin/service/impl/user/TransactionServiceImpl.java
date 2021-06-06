package com.boot.yuntechlifeadmin.service.impl.user;

import com.boot.yuntechlifeadmin.dao.user.TransactionMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.Transaction;
import com.boot.yuntechlifeadmin.entity.user.User;
import com.boot.yuntechlifeadmin.service.user.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: TransactionServiceImpl
 * @Description: Service
 * @Date: 2020-03-10
 */
@Component
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public int insertOne(Transaction transaction) {
        return transactionMapper.insertOne(transaction);
    }

    @Override
    public List<Transaction> getList(AdminUser adminUser) {
        return transactionMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(Transaction transaction) {
        return transactionMapper.deleteOne(transaction);
    }

    @Override
    public int deleteMore(Transaction transaction) {
        return transactionMapper.deleteMore(transaction);
    }
}
