package com.boot.yuntechlifeadmin.dao.home;

import com.boot.yuntechlifeadmin.entity.home.Console;
import com.boot.yuntechlifeadmin.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: skwen
 * @ClassName: ConsoleInfoMapper
 * @Description: 控制台屬性dao
 * @Date: 2020-03-09
 */
@Mapper
public interface ConsoleMapper {
    Console getInfo(Console console);
    List<Map<String, Object>> getEcharts(Console console);
    List<Map<String, Object>> getFeedbackList();
}