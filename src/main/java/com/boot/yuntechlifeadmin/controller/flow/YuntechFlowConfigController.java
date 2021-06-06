package com.boot.yuntechlifeadmin.controller.flow;

import com.boot.yuntechlifeadmin.annotation.LoginToken;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowConfig;
import com.boot.yuntechlifeadmin.entity.main.Token;
import com.boot.yuntechlifeadmin.entity.user.LoginRecord;
import com.boot.yuntechlifeadmin.service.adminUser.AdminUserService;
import com.boot.yuntechlifeadmin.service.flow.YuntechFlowConfigService;
import com.boot.yuntechlifeadmin.service.main.TokenService;
import com.boot.yuntechlifeadmin.service.user.LoginRecordService;
import com.boot.yuntechlifeadmin.util.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @ClassName: YuntechFlowConfigController
 * @Description: controller
 * @Date: 2020-04-01
 */
@RestController
@RequestMapping("/api/flow")
//@CrossOrigin(origins = "http://courier.iskwen.com", maxAge = 3600)
public class YuntechFlowConfigController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private YuntechFlowConfigService yuntechFlowConfigService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private Util util;
    @Autowired
    private HttpServletRequest request;

    @LoginToken
    @RequestMapping("listYuntechFlowConfig")
    public Map<String, Object> listLoginRecord(int pageNumber, int pageSize, String sortName, String sortOrder, String keyword, int state, String startTime, String endTime) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            AdminUser adminUser = new AdminUser();
            adminUser.setId(token.getId());
            adminUser.setSortName(sortName);
            adminUser.setSortOrder(sortOrder);
            adminUser.setKeyword(keyword);
            adminUser.setState(state);
            if (startTime != null && startTime != "") {
                adminUser.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime));
            }
            if (endTime != null && endTime != "") {
                adminUser.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime));
            }
            String order = "";
            if (sortName != "" && sortName != "") {
                order = sortName;
                if (sortOrder != "" && sortOrder != "") {
                    order += " " + sortOrder;
                }
            }
            PageHelper.startPage(pageNumber, pageSize, order);
            List<YuntechFlowConfig> select = yuntechFlowConfigService.getList(adminUser);
            PageInfo<YuntechFlowConfig> pageInfo = new PageInfo<>(select);
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
    @RequestMapping("batchUpdateYuntechFlowConfigState")
    public Map<String, Object> batchUpdateYuntechFlowConfigState(int []  ids,int state) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            YuntechFlowConfig yuntechFlowConfig = new YuntechFlowConfig();
            yuntechFlowConfig.setIds(ids);
            yuntechFlowConfig.setState(state);
            int count = yuntechFlowConfigService.updateMore(yuntechFlowConfig);
            if (count > 0) {
                map.put("status", 0);
                map.put("tip", "success");
                map.put("count",count);
            } else {
                map.put("status", -2);
                map.put("tip", "操作失敗,請稍候再試");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }
    @LoginToken
    @RequestMapping("changeYuntechFlowConfigState")
    public Map<String, Object> changeYuntechFlowConfigState(int id,int state) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            YuntechFlowConfig yuntechFlowConfig = new YuntechFlowConfig();
            yuntechFlowConfig.setId(id);
            yuntechFlowConfig.setState(state);
            int count = yuntechFlowConfigService.updateOne(yuntechFlowConfig);
            if (count > 0) {
                map.put("status", 0);
                map.put("tip", "success");
                map.put("count",count);
            } else {
                map.put("status", -2);
                map.put("tip", "操作失敗,請稍候再試");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }
    @LoginToken
    @RequestMapping("batchChangeYuntechFlowConfigMaxEnable")
    public Map<String, Object> batchChangeYuntechFlowConfigMaxEnable(int []  ids,int val) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            YuntechFlowConfig yuntechFlowConfig = new YuntechFlowConfig();
            yuntechFlowConfig.setIds(ids);
            yuntechFlowConfig.setMax_enable(val);
            int count = yuntechFlowConfigService.updateMore(yuntechFlowConfig);
            if (count > 0) {
                map.put("status", 0);
                map.put("tip", "success");
                map.put("count",count);
            } else {
                map.put("status", -2);
                map.put("tip", "操作失敗,請稍候再試");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }
    @LoginToken
    @RequestMapping("changeYuntechFlowConfigMaxEnable")
    public Map<String, Object> changeYuntechFlowConfigMaxEnable(int id,int val) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            YuntechFlowConfig yuntechFlowConfig = new YuntechFlowConfig();
            yuntechFlowConfig.setId(id);
            yuntechFlowConfig.setMax_enable(val);
            int count = yuntechFlowConfigService.updateOne(yuntechFlowConfig);
            if (count > 0) {
                map.put("status", 0);
                map.put("tip", "success");
                map.put("count",count);
            } else {
                map.put("status", -2);
                map.put("tip", "操作失敗,請稍候再試");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }
}
