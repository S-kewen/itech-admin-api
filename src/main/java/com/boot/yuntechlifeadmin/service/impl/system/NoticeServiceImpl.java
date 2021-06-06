package com.boot.yuntechlifeadmin.service.impl.system;

import com.boot.yuntechlifeadmin.dao.system.MessageBoardMapper;
import com.boot.yuntechlifeadmin.dao.system.NoticeMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.MessageBoard;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import com.boot.yuntechlifeadmin.service.system.MessageBoardService;
import com.boot.yuntechlifeadmin.service.system.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: skwen
 * @ClassName: NoticeServiceImpl
 * @Description: Service
 * @Date: 2020-03-17
 */
@Component
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getList(AdminUser adminUser) {
        return noticeMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(Notice notice) {
        return noticeMapper.deleteOne(notice);
    }

    @Override
    public int deleteMore(Notice notice) {
        return noticeMapper.deleteMore(notice);
    }

    @Override
    public int updateOne(Notice notice) {
        return noticeMapper.updateOne(notice);
    }

    @Override
    public int updateMore(Notice notice) {
        return noticeMapper.updateMore(notice);
    }

    @Override
    public int insertOne(Notice notice) {
        return noticeMapper.insertOne(notice);
    }

    @Override
    public Notice getInfo(Notice notice) {
        return noticeMapper.getInfo(notice);
    }

}

