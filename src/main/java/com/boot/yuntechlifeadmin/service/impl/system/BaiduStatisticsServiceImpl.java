package com.boot.yuntechlifeadmin.service.impl.system;

import com.boot.yuntechlifeadmin.dao.system.BaiduStatisticsMapper;
import com.boot.yuntechlifeadmin.entity.system.BaiduStatistics;
import com.boot.yuntechlifeadmin.service.system.BaiduStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: LoginRecordServiceImpl
 * @Description: Service
 * @Date: 2020-03-08
 */
@Component
public class BaiduStatisticsServiceImpl implements BaiduStatisticsService {
    @Autowired
    private BaiduStatisticsMapper baiduStatisticsMapper;

    @Override
    public int insertOne(BaiduStatistics baiduStatistics) {
        return baiduStatisticsMapper.insertOne(baiduStatistics);
    }

    @Override
    public List<BaiduStatistics> getListByWeek(BaiduStatistics baiduStatistics) {
        return baiduStatisticsMapper.getListByWeek(baiduStatistics);
    }


}
