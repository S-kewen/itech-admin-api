package com.boot.yuntechlifeadmin.controller.system;

import com.boot.yuntechlifeadmin.annotation.LoginToken;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.main.Token;
import com.boot.yuntechlifeadmin.entity.system.Advert;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import com.boot.yuntechlifeadmin.service.adminUser.AdminUserService;
import com.boot.yuntechlifeadmin.service.main.TokenService;
import com.boot.yuntechlifeadmin.service.system.AdvertService;
import com.boot.yuntechlifeadmin.service.system.NoticeService;
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
 * @ClassName: AdvertController
 * @Description: controller
 * @Date: 2020-04-03
 */
@RestController
@RequestMapping("/api/system")
//@CrossOrigin(origins = "http://courier.iskwen.com", maxAge = 3600)
public class NoticeController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private Util util;
    @Autowired
    private HttpServletRequest request;

    @LoginToken
    @RequestMapping("listNotice")
    public Map<String, Object> listNotice(int pageNumber, int pageSize, String sortName, String sortOrder, String keyword, int state, int top,String startTime, String endTime) throws ParseException {
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
            adminUser.setTop(top);
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
            List<Notice> select=noticeService.getList(adminUser);;
            PageInfo<Notice> pageInfo = new PageInfo<>(select);
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
    @RequestMapping("deleteNotice")
    public Map<String, Object> deleteNotice(int id,boolean deleted) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Notice notice = new Notice();
            notice.setId(id);
            notice.setDeleted(deleted);
            int count = noticeService.deleteOne(notice);
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
    @RequestMapping("batchDeleteNotice")
    public Map<String, Object> batchDeleteNotice(int []  ids,boolean deleted) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Notice notice = new Notice();
            notice.setIds(ids);
            notice.setDeleted(deleted);
            int count = noticeService.deleteMore(notice);
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
    @RequestMapping("changeNoticeState")
    public Map<String, Object> changeNoticeState(int id,int state) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Notice notice = new Notice();
            notice.setId(id);
            notice.setState(state);
            int count = noticeService.updateOne(notice);
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
    @RequestMapping("batchUpdateNoticeState")
    public Map<String, Object> batchUpdateNoticeState(int []  ids,int state) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Notice notice = new Notice();
            notice.setIds(ids);
            notice.setState(state);
            int count = noticeService.updateMore(notice);
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
    @RequestMapping("addNotice")
    public Map<String, Object> addNotice(String title,int top,String startTime,String endTime,String layText,int jumpType,String url,String content) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Notice notice = new Notice();
            notice.setUser_id(token.getId());
            notice.setState(1);
            notice.setType(1);
            notice.setTop(top);
            notice.setTitle(title);
            notice.setShow_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime));
            notice.setHide_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime));
            notice.setJump_type(jumpType);
            notice.setLay_text(layText);
            notice.setUrl(url);
            notice.setContent(content);
            int count = noticeService.insertOne(notice);
            if (count > 0) {
                map.put("status", 0);
                map.put("tip", "success");
                map.put("count",count);
            } else {
                map.put("status", -2);
                map.put("tip", "新增失敗,請稍候再試");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }
    @LoginToken
    @RequestMapping("getNoticeInfo")
    public Map<String, Object> getNoticeInfo(int id) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Notice notice = new Notice();
            notice.setId(id);
            notice = noticeService.getInfo(notice);
            if (notice!=null) {
                map.put("status", 0);
                map.put("tip", "success");
                map.put("title",notice.getTitle());
                map.put("top",notice.getTop());
                map.put("startTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(notice.getShow_time()));
                map.put("endTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(notice.getHide_time()));
                map.put("layText",notice.getLay_text());
                map.put("jumpType",notice.getJump_type());
                map.put("url",notice.getUrl());
                map.put("content",notice.getContent());
            } else {
                map.put("status", -2);
                map.put("tip", "該記錄不存在");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }
    @LoginToken
    @RequestMapping("updateNotice")
    public Map<String, Object> updateNotice(int id,String title,int top,String startTime,String endTime,String layText,int jumpType,String url,String content) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Notice notice = new Notice();
            notice.setId(id);
            notice.setUser_id(token.getId());
            notice.setState(1);
            notice.setType(1);
            notice.setTop(top);
            notice.setTitle(title);
            notice.setShow_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime));
            notice.setHide_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime));
            notice.setJump_type(jumpType);
            notice.setLay_text(layText);
            notice.setUrl(url);
            notice.setContent(content);
            int count = noticeService.updateOne(notice);
            if (count > 0) {
                map.put("status", 0);
                map.put("tip", "success");
                map.put("count",count);
            } else {
                map.put("status", -2);
                map.put("tip", "修改失敗,請稍候再試");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }
}
