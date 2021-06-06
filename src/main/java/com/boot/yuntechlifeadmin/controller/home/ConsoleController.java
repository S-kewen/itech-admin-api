package com.boot.yuntechlifeadmin.controller.home;

import com.boot.yuntechlifeadmin.annotation.LoginToken;
import com.boot.yuntechlifeadmin.entity.home.Console;
import com.boot.yuntechlifeadmin.entity.main.Token;
import com.boot.yuntechlifeadmin.service.home.ConsoleService;
import com.boot.yuntechlifeadmin.service.system.FeedbackService;
import com.boot.yuntechlifeadmin.service.main.TokenService;
import com.boot.yuntechlifeadmin.service.adminUser.AdminUserService;
import com.boot.yuntechlifeadmin.service.adminUser.AdminLoginRecordService;
import com.boot.yuntechlifeadmin.service.adminUser.AdminNewsService;
import com.boot.yuntechlifeadmin.util.TencentCloudApiUtil;
import com.boot.yuntechlifeadmin.util.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: skwen
 * @ClassName: ConsoleController
 * @Description: controller
 * @Date: 2020-03-28
 */
@RestController
@RequestMapping("/api/home")
public class ConsoleController {
    @Value("${performance.serviceId.client}")
    private int serviceId;
    @Value("${baiduStatistics.siteId}")
    private String siteId;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private Util util;
    @Autowired
    private TencentCloudApiUtil tencentCloudApiUtil;
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AdminLoginRecordService adminLoginRecordService;
    @Autowired
    private AdminNewsService adminNewsService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private ConsoleService consoleService;
    @LoginToken
    @RequestMapping("getConsoleInfo")
    public Map<String, Object> getConsoleInfo(String nowDate) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Console console = new Console();
            console.setService_id(serviceId);
            console.setSite_id(siteId);
            console.setNow_date(new SimpleDateFormat("yyyy-MM-dd").parse(nowDate));
            console=consoleService.getInfo(console);
            if (console!=null){
                map.put("status", 0);
                map.put("tip", "success");
                map.put("todayPvCount", console.getToday_pv_count());
                map.put("allPvCount", console.getAll_pv_count());
                map.put("userCount", console.getUser_count());
                map.put("userActiveCount",console.getUser_active_count());
                map.put("todayIncome", console.getToday_income());
                map.put("allIncome", console.getAll_income());
                map.put("uncompleteOrderCount", console.getUncomplete_order_count());
                map.put("orderCount", console.getOrder_count());
                map.put("cpu", console.getCpu());
                map.put("ram", console.getRam());
                map.put("yesterdayUserCount", console.getYesterday_user_count());
                map.put("certificationUserCount", console.getCertification_user_count());
            }else{
                map.put("status", -2);
                map.put("tip", "查詢數據失敗,請稍後再試");
            }
        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }
        return map;
    }
    @LoginToken
    @RequestMapping("getEchartsInfo")
    public Map<String, Object> getEchartsInfo(String nowDate) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Console console = new Console();
            console.setService_id(serviceId);
            console.setSite_id(siteId);
            console.setNow_date(new SimpleDateFormat("yyyy-MM-dd").parse(nowDate));
            List<Map<String, Object>> select = consoleService.getEcharts(console);
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(select);
            map.put("status", 0);
            map.put("tip", "success");
            map.put("total", pageInfo.getTotal());
            map.put("list", pageInfo.getList());
        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }
        return map;
    }
    @LoginToken
    @RequestMapping("getFeedbackList")
    public Map<String, Object> getFeedbackList() throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            PageHelper.startPage(1, 10, "feedback.add_time desc");
            List<Map<String, Object>> select = consoleService.getFeedbackList();
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(select);
            map.put("status", 0);
            map.put("tip", "success");
            map.put("total", pageInfo.getTotal());
            map.put("list", pageInfo.getList());
        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }
        return map;
    }

}
