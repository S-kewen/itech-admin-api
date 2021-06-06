package com.boot.yuntechlifeadmin.service.impl.home;

import com.boot.yuntechlifeadmin.dao.home.ConsoleMapper;
import com.boot.yuntechlifeadmin.entity.home.Console;
import com.boot.yuntechlifeadmin.service.home.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: skwen
 * @ClassName: ConsoleInfoServiceImpl
 * @Description: ConsoleInfoService
 * @Date: 2020-03-00
 */
@Component
public class ConsoleServiceImpl implements ConsoleService {
    @Autowired
    private ConsoleMapper consoleInfoMapper;
    @Override
    public Console getInfo(Console console) {
        return consoleInfoMapper.getInfo(console);
    }
    @Override
    public List<Map<String, Object>> getEcharts(Console console) {
        return consoleInfoMapper.getEcharts(console);
    }
    @Override
    public List<Map<String, Object>> getFeedbackList() {
        return consoleInfoMapper.getFeedbackList();
    }

}
