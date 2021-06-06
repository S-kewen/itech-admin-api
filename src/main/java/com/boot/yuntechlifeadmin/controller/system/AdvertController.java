package com.boot.yuntechlifeadmin.controller.system;

import com.boot.yuntechlifeadmin.annotation.LoginToken;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.flow.YuntechFlowSet;
import com.boot.yuntechlifeadmin.entity.main.Token;
import com.boot.yuntechlifeadmin.entity.system.Advert;
import com.boot.yuntechlifeadmin.service.adminUser.AdminUserService;
import com.boot.yuntechlifeadmin.service.flow.YuntechFlowSetService;
import com.boot.yuntechlifeadmin.service.main.TokenService;
import com.boot.yuntechlifeadmin.service.system.AdvertService;
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
@RequestMapping("/api/business")
//@CrossOrigin(origins = "http://courier.iskwen.com", maxAge = 3600)
public class AdvertController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AdvertService advertService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private Util util;
    @Autowired
    private HttpServletRequest request;

    @LoginToken
    @RequestMapping("listAdvert")
    public Map<String, Object> listAdvert(int pageNumber, int pageSize, String sortName, String sortOrder, String keyword, int state, String startTime, String endTime) throws ParseException {
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
            List<Advert> select=advertService.getList(adminUser);;
            PageInfo<Advert> pageInfo = new PageInfo<>(select);
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
    @RequestMapping("deleteAdvert")
    public Map<String, Object> deleteAdvert(int id,boolean deleted) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Advert advert = new Advert();
            advert.setId(id);
            advert.setDeleted(deleted);
            int count = advertService.deleteOne(advert);
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
    @RequestMapping("batchDeleteAdvert")
    public Map<String, Object> batchDeleteAdvert(int []  ids,boolean deleted) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Advert advert = new Advert();
            advert.setIds(ids);
            advert.setDeleted(deleted);
            int count = advertService.deleteMore(advert);
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
    @RequestMapping("changeAdvertState")
    public Map<String, Object> changeAdvertState(int id,int state) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Advert advert = new Advert();
            advert.setId(id);
            advert.setState(state);
            int count = advertService.updateOne(advert);
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
    @RequestMapping("batchUpdateAdvertState")
    public Map<String, Object> batchUpdateAdvertState(int []  ids,int state) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Advert advert = new Advert();
            advert.setIds(ids);
            advert.setState(state);
            int count = advertService.updateMore(advert);
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
    @RequestMapping("addAdvert")
    public Map<String, Object> addAdvert(String title,int priority,String startTime,String endTime,String layText,int jumpType,String url,int color) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Advert advert = new Advert();
            advert.setUser_id(token.getId());
            advert.setState(1);
            advert.setType(1);
            advert.setPriority(priority);
            advert.setTitle(title);
            advert.setShow_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime));
            advert.setHide_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime));
            advert.setJump_type(jumpType);
            advert.setLay_text(layText);
            advert.setUrl(url);
            advert.setColor(color);
            int count = advertService.insertOne(advert);
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
    @RequestMapping("getAdvertInfo")
    public Map<String, Object> getAdvertInfo(int id) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Advert advert = new Advert();
            advert.setId(id);
            advert = advertService.getInfo(advert);
            if (advert!=null) {
                map.put("status", 0);
                map.put("tip", "success");
                map.put("title",advert.getTitle());
                map.put("priority",advert.getPriority());
                map.put("startTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(advert.getShow_time()));
                map.put("endTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(advert.getHide_time()));
                map.put("layText",advert.getLay_text());
                map.put("jumpType",advert.getJump_type());
                map.put("url",advert.getUrl());
                map.put("color",advert.getColor());
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
    @RequestMapping("updateAdvert")
    public Map<String, Object> updateAdvert(int id,String title,int priority,String startTime,String endTime,String layText,int jumpType,String url,int color) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            Advert advert = new Advert();
            advert.setId(id);
            advert.setUser_id(token.getId());
            advert.setState(1);
            advert.setType(1);
            advert.setPriority(priority);
            advert.setTitle(title);
            advert.setShow_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime));
            advert.setHide_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime));
            advert.setJump_type(jumpType);
            advert.setLay_text(layText);
            advert.setUrl(url);
            advert.setColor(color);
            int count = advertService.updateOne(advert);
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
