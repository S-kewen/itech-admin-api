package com.boot.yuntechlifeadmin.service.system;

import com.boot.yuntechlifeadmin.entity.system.BaiduStatistics;

import java.util.List;

public interface BaiduStatisticsService {
    int insertOne(BaiduStatistics baiduStatistics);

    List<BaiduStatistics> getListByWeek(BaiduStatistics baiduStatistics);
}
