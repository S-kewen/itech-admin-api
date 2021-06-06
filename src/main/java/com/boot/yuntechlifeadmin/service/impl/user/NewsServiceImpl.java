package com.boot.yuntechlifeadmin.service.impl.user;

import com.boot.yuntechlifeadmin.dao.user.LoginRecordMapper;
import com.boot.yuntechlifeadmin.dao.user.NewsMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.LoginRecord;
import com.boot.yuntechlifeadmin.entity.user.News;
import com.boot.yuntechlifeadmin.service.user.LoginRecordService;
import com.boot.yuntechlifeadmin.service.user.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: NewsServiceImpl
 * @Description: Service
 * @Date: 2020-03-31
 */
@Component
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public int insertOne(News news) {
        return newsMapper.insertOne(news);
    }

    @Override
    public List<News> getList(AdminUser adminUser) {
        return newsMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(News news) {
        return newsMapper.deleteOne(news);
    }
    @Override
    public int deleteMore(News news) {
        return newsMapper.deleteMore(news);
    }

}
