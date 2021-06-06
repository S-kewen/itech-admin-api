package com.boot.yuntechlifeadmin.controller.adminUser;

import com.boot.yuntechlifeadmin.annotation.LoginToken;
import com.boot.yuntechlifeadmin.entity.main.Token;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminNews;
import com.boot.yuntechlifeadmin.service.main.TokenService;
import com.boot.yuntechlifeadmin.service.adminUser.AdminLoginRecordService;
import com.boot.yuntechlifeadmin.service.adminUser.AdminNewsService;
import com.boot.yuntechlifeadmin.util.Util;
import com.boot.yuntechlifeadmin.service.adminUser.AdminUserService;
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
 * @ClassName: AdminNewsController
 * @Description: controller
 * @Date: 2020-03-29
 */
@RestController
@RequestMapping("/api/adminUser")
public class AdminNewsController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AdminNewsService adminNewsService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private Util util;
    @Autowired
    private HttpServletRequest request;

    @LoginToken
    @RequestMapping("listMessage")
    public Map<String, Object> listMessage(int pageNumber, int pageSize, String sortName, String sortOrder, String keyword, int state, String startTime, String endTime) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            AdminUser adminUser = new AdminUser();
            adminUser.setId(token.getId());
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
            List<AdminNews> select = adminNewsService.getList(adminUser);
            PageInfo<AdminNews> pageInfo = new PageInfo<>(select);
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
    @RequestMapping("deleteMessage")
    public Map<String, Object> deleteMessage(int id) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            AdminNews adminNews = new AdminNews();
            adminNews.setUser_id(token.getId());
            adminNews.setId(id);
            int count = adminNewsService.deleteById(adminNews);
            if (count > 0) {
                map.put("status", 0);
                map.put("tip", "success");
            } else {
                map.put("status", -7);
                map.put("tip", "刪除失敗,請稍候再試");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }

    @LoginToken
    @RequestMapping("readMessage")
    public Map<String, Object> readMessage(int id) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            AdminNews adminNews = new AdminNews();
            adminNews.setUser_id(token.getId());
            adminNews.setId(id);
            adminNews.setState(2);
            int count = adminNewsService.updateById(adminNews);
            if (count > 0) {
                map.put("status", 0);
                map.put("tip", "success");
            } else {
                map.put("status", -7);
                map.put("tip", "設置失敗,請稍候再試");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }

    @LoginToken
    @RequestMapping("allReadMessage")
    public Map<String, Object> allReadMessage() {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            AdminNews adminNews = new AdminNews();
            adminNews.setUser_id(token.getId());
            adminNews.setState(2);
            int count = adminNewsService.allRead(adminNews);
            if (count > 0) {
                map.put("status", 0);
                map.put("tip", "success");
                map.put("count", count);
            } else {
                map.put("status", -2);
                map.put("tip", "暫時沒有未讀的消息");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }
    @LoginToken
    @RequestMapping("batchDeleteMessage")
    public Map<String, Object> batchDeleteMessage(int []  ids) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            AdminNews adminNews = new AdminNews();
            adminNews.setUser_id(token.getId());
            adminNews.setIds(ids);
            int count = adminNewsService.deleteMore(adminNews);
            if (count > 0) {
                map.put("status", 0);
                map.put("tip", "success");
                map.put("count",count);
            } else {
                map.put("status", -2);
                map.put("tip", "刪除失敗,請稍候再試");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }

    @LoginToken
    @RequestMapping("batchReadMessage")
    public Map<String, Object> batchReadMessage(int []  ids) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            AdminNews adminNews = new AdminNews();
            adminNews.setUser_id(token.getId());
            adminNews.setIds(ids);
            adminNews.setState(2);
            int count = adminNewsService.updateMore(adminNews);
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
    @RequestMapping("getUnreadMessageCount")
    public Map<String, Object> getUnreadMessageCount() {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            AdminNews adminNews = new AdminNews();
            adminNews.setUser_id(token.getId());
            adminNews.setState(1);
            int count = adminNewsService.getCount(adminNews);
            map.put("status", 0);
            map.put("tip", "success");
            map.put("unreadMessageCount", count);
        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }

}
