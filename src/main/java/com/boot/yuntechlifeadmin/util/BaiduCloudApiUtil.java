package com.boot.yuntechlifeadmin.util;

import com.boot.yuntechlifeadmin.entity.system.BaiduStatistics;

import java.io.IOException;
import java.text.ParseException;

public interface BaiduCloudApiUtil {
    BaiduStatistics getStatisticsInfo() throws ParseException;
}
