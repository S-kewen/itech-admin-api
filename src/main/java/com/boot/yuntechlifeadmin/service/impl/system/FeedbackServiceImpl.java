package com.boot.yuntechlifeadmin.service.impl.system;

import com.boot.yuntechlifeadmin.dao.system.BaiduStatisticsMapper;
import com.boot.yuntechlifeadmin.dao.system.FeedbackMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.BaiduStatistics;
import com.boot.yuntechlifeadmin.entity.system.Feedback;
import com.boot.yuntechlifeadmin.service.system.BaiduStatisticsService;
import com.boot.yuntechlifeadmin.service.system.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: FeedbackServiceImpl
 * @Description: Service
 * @Date: 2020-03-15
 */
@Component
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public List<Feedback> getList(AdminUser adminUser) {
        return feedbackMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(Feedback feedback) {
        return feedbackMapper.deleteOne(feedback);
    }

    @Override
    public int deleteMore(Feedback feedback) {
        return feedbackMapper.deleteMore(feedback);
    }

    @Override
    public int updateOne(Feedback feedback) {
        return feedbackMapper.updateOne(feedback);
    }

    @Override
    public int updateMore(Feedback feedback) {
        return feedbackMapper.updateMore(feedback);
    }
}

