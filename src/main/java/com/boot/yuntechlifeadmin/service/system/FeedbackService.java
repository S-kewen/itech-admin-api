package com.boot.yuntechlifeadmin.service.system;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.BaiduStatistics;
import com.boot.yuntechlifeadmin.entity.system.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getList(AdminUser adminUser);
    int deleteOne(Feedback feedback);
    int deleteMore(Feedback feedback);
    int updateOne(Feedback feedback);
    int updateMore(Feedback feedback);
}
