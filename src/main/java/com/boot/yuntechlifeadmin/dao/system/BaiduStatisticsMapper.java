package com.boot.yuntechlifeadmin.dao.system;

import com.boot.yuntechlifeadmin.entity.system.BaiduStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName:BaiduStatisticsMapper
 * @Description: dao
 * @Date: 2020-03-14
 */
@Mapper
public interface BaiduStatisticsMapper {
    int insertOne(BaiduStatistics baiduStatistics);
    List<BaiduStatistics> getListByWeek(BaiduStatistics baiduStatistics);
}