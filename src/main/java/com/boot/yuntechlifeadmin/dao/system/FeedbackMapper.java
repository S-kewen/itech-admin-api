package com.boot.yuntechlifeadmin.dao.system;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.BaiduStatistics;
import com.boot.yuntechlifeadmin.entity.system.Feedback;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName:FeedbackMapper
 * @Description: dao
 * @Date: 2020-03-15
 */
@Mapper
public interface FeedbackMapper {
    List<Feedback> getList(AdminUser adminUser);
    int deleteOne(Feedback feedback);
    int deleteMore(Feedback feedback);
    int updateOne(Feedback feedback);
    int updateMore(Feedback feedback);
}