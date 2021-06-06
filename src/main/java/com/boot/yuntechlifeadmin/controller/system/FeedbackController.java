package com.boot.yuntechlifeadmin.controller.system;

import com.boot.yuntechlifeadmin.annotation.LoginToken;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.main.Token;
import com.boot.yuntechlifeadmin.entity.system.Feedback;
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
 * @ClassName: FeedbackController
 * @Description: controller
 * @Date: 2020-03-28
 */
@RestController
@RequestMapping("/api/system")
public class FeedbackController {
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
    @RequestMapping("listFeedback")
    public Map<String, Object> listFeedback(int pageNumber, int pageSize, String sortName, String sortOrder, String keyword, int state, int type,int anonymous,String startTime, String endTime) throws ParseException {
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
            adminUser.setType(type);
            adminUser.setAnonymous(anonymous);
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
            List<Feedback> select=feedbackService.getList(adminUser);;
            PageInfo<Feedback> pageInfo = new PageInfo<>(select);
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
    @RequestMapping("deleteFeedback")
    public Map<String, Object> deleteFeedback(int id,boolean deleted) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Feedback feedback = new Feedback();
            feedback.setId(id);
            feedback.setDeleted(deleted);
            int count = feedbackService.deleteOne(feedback);
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
    @RequestMapping("batchDeleteFeedback")
    public Map<String, Object> batchDeleteFeedback(int []  ids,boolean deleted) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Feedback feedback = new Feedback();
            feedback.setIds(ids);
            feedback.setDeleted(deleted);
            int count = feedbackService.deleteMore(feedback);
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
    @RequestMapping("changeFeedbackState")
    public Map<String, Object> changeFeedbackState(int id,int state) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Feedback feedback = new Feedback();
            feedback.setId(id);
            feedback.setState(state);
            int count = feedbackService.updateOne(feedback);
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
    @RequestMapping("batchUpdateFeedbackState")
    public Map<String, Object> batchUpdateFeedbackState(int []  ids,int state) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Feedback feedback = new Feedback();
            feedback.setIds(ids);
            feedback.setState(state);
            int count = feedbackService.updateMore(feedback);
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
