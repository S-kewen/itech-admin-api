package com.boot.yuntechlifeadmin.controller.flow;

import com.boot.yuntechlifeadmin.annotation.LoginToken;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlow;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowWarn;
import com.boot.yuntechlifeadmin.entity.main.Token;
import com.boot.yuntechlifeadmin.service.adminUser.AdminUserService;
import com.boot.yuntechlifeadmin.service.flow.YuntechFlowService;
import com.boot.yuntechlifeadmin.service.flow.YuntechFlowWarnService;
import com.boot.yuntechlifeadmin.service.main.TokenService;
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
 * @ClassName: YuntechFlowWarnController
 * @Description: controller
 * @Date: 2020-04-01
 */
@RestController
@RequestMapping("/api/flow")
//@CrossOrigin(origins = "http://courier.iskwen.com", maxAge = 3600)
public class YuntechFlowWarnController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private YuntechFlowWarnService yuntechFlowWarnService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private Util util;
    @Autowired
    private HttpServletRequest request;

    @LoginToken
    @RequestMapping("listYuntechFlowWarn")
    public Map<String, Object> listYuntechFlowWarn(int pageNumber, int pageSize, String sortName, String sortOrder, String keyword, int state, String startTime, String endTime) throws ParseException {
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
            List<YuntechFlowWarn> select=yuntechFlowWarnService.getList(adminUser);
            PageInfo<YuntechFlowWarn> pageInfo = new PageInfo<>(select);
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
    @RequestMapping("batchDeleteYuntechFlowWarn")
    public Map<String, Object> batchDeleteYuntechFlowWarn(int []  ids,boolean deleted) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            YuntechFlowWarn yuntechFlowWarn = new YuntechFlowWarn();
            yuntechFlowWarn.setIds(ids);
            yuntechFlowWarn.setDeleted(deleted);
            int count = yuntechFlowWarnService.deleteMore(yuntechFlowWarn);
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
    @RequestMapping("deleteYuntechFlowWarn")
    public Map<String, Object> deleteYuntechFlowWarn(int id,boolean deleted) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            YuntechFlowWarn yuntechFlowWarn = new YuntechFlowWarn();
            yuntechFlowWarn.setId(id);
            yuntechFlowWarn.setDeleted(deleted);
            int count = yuntechFlowWarnService.deleteOne(yuntechFlowWarn);
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
