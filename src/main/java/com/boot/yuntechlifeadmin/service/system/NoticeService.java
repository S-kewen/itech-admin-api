package com.boot.yuntechlifeadmin.service.system;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Advert;
import com.boot.yuntechlifeadmin.entity.system.MessageBoard;
import com.boot.yuntechlifeadmin.entity.system.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    List<Notice> getList(AdminUser adminUser);
    int deleteOne(Notice notice);
    int deleteMore(Notice notice);
    int updateOne(Notice notice);
    int updateMore(Notice notice);
    int insertOne(Notice notice);
    Notice getInfo(Notice notice);
}
