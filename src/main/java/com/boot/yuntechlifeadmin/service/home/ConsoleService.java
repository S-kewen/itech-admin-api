package com.boot.yuntechlifeadmin.service.home;

import com.boot.yuntechlifeadmin.entity.home.Console;
import com.boot.yuntechlifeadmin.entity.user.User;

import java.util.List;
import java.util.Map;

public interface ConsoleService {
    Console getInfo(Console console);
    List<Map<String, Object>> getEcharts(Console console);
    List<Map<String, Object>> getFeedbackList();
}
