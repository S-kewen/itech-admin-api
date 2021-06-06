package com.boot.yuntechlifeadmin.service.impl.adminUser;

import com.boot.yuntechlifeadmin.dao.adminUser.AdminNewsMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminNews;
import com.boot.yuntechlifeadmin.service.adminUser.AdminNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: UserServiceImpl
 * @Description: userService
 * @Date: 2020-03-08
 */
@Component
public class AdminNewsServiceImpl implements AdminNewsService {
    @Autowired
    private AdminNewsMapper adminNewsMapper;

    @Override
    public int insertOne(AdminNews adminNews) {
        return adminNewsMapper.insertOne(adminNews);
    }

    @Override
    public int getCount(AdminNews adminNews) {
        return adminNewsMapper.getCount(adminNews);
    }

    @Override
    public List<AdminNews> getList(AdminUser adminUser) {
        return adminNewsMapper.getList(adminUser);
    }

    @Override
    public int deleteById(AdminNews adminNews) {
        return adminNewsMapper.deleteById(adminNews);
    }

    @Override
    public int updateById(AdminNews adminNews) {
        return adminNewsMapper.updateById(adminNews);
    }

    @Override
    public int updateByUserId(AdminNews adminNews) {
        return adminNewsMapper.updateByUserId(adminNews);
    }

    @Override
    public int allRead(AdminNews adminNews) {
        return adminNewsMapper.allRead(adminNews);
    }

    @Override
    public int deleteMore(AdminNews adminNews) {
        return adminNewsMapper.deleteMore(adminNews);
    }

    @Override
    public int updateMore(AdminNews adminNews) {
        return adminNewsMapper.updateMore(adminNews);
    }

}
