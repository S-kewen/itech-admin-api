package com.boot.yuntechlifeadmin.controller.express;

import com.boot.yuntechlifeadmin.annotation.LoginToken;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.express.ExpressIntegral;
import com.boot.yuntechlifeadmin.entity.express.ExpressReceive;
import com.boot.yuntechlifeadmin.entity.express.ExpressTaker;
import com.boot.yuntechlifeadmin.entity.main.Token;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import com.boot.yuntechlifeadmin.service.adminUser.AdminUserService;
import com.boot.yuntechlifeadmin.service.express.ExpressIntegralService;
import com.boot.yuntechlifeadmin.service.express.ExpressReceiveService;
import com.boot.yuntechlifeadmin.service.express.ExpressTakerService;
import com.boot.yuntechlifeadmin.service.main.TokenService;
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
 * @ClassName: ExpressTakerController
 * @Description: controller
 * @Date: 2020-04-05
 */
@RestController
@RequestMapping("/api/express")
//@CrossOrigin(origins = "http://courier.iskwen.com", maxAge = 3600)
public class ExpressTakerController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private ExpressTakerService expressTakerService;
    @Autowired
    private ExpressReceiveService expressReceiveService;
    @Autowired
    private ExpressIntegralService expressIntegralService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private Util util;
    @Autowired
    private HttpServletRequest request;

    @LoginToken
    @RequestMapping("listExpressTaker")
    public Map<String, Object> listExpressTaker(int pageNumber, int pageSize, String sortName, String sortOrder, String keyword, int state, String startTime, String endTime) throws ParseException {
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
            List<ExpressTaker> select=expressTakerService.getList(adminUser);;
            PageInfo<ExpressTaker> pageInfo = new PageInfo<>(select);
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
    @RequestMapping("deleteExpressTaker")
    public Map<String, Object> deleteExpressTaker(int id,boolean deleted) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            ExpressTaker expressTaker = new ExpressTaker();
            expressTaker.setId(id);
            expressTaker.setDeleted(deleted);
            int count = expressTakerService.deleteOne(expressTaker);
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
    @RequestMapping("batchDeleteExpressTaker")
    public Map<String, Object> batchDeleteExpressTaker(int []  ids,boolean deleted) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            ExpressTaker expressTaker = new ExpressTaker();
            expressTaker.setIds(ids);
            expressTaker.setDeleted(deleted);
            int count = expressTakerService.deleteMore(expressTaker);
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
    @RequestMapping("changeExpressTakerState")
    public Map<String, Object> changeExpressTakerState(int id,int state) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            ExpressTaker expressTaker = new ExpressTaker();
            expressTaker.setId(id);
            expressTaker.setState(state);
            int count = expressTakerService.updateOne(expressTaker);
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
    @RequestMapping("batchUpdateExpressTakerState")
    public Map<String, Object> batchUpdateExpressTakerState(int []  ids,int state) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            ExpressTaker expressTaker = new ExpressTaker();
            expressTaker.setIds(ids);
            expressTaker.setState(state);
            int count = expressTakerService.updateMore(expressTaker);
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
    @RequestMapping("getExpressTakerInfo")
    public Map<String, Object> getExpressTakerInfo(int id) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            ExpressTaker expressTaker = new ExpressTaker();
            expressTaker.setId(id);
            expressTaker = expressTakerService.getInfo(expressTaker);
            if (expressTaker!=null) {
                map.put("status", 0);
                map.put("tip", "success");
                map.put("expressName", expressTaker.getExpress_name());
                map.put("expressNum", expressTaker.getExpress_num());
                map.put("recipientName", expressTaker.getRecipient_name());
                map.put("recipientPhone", expressTaker.getRecipient_phone());
                map.put("expressType", expressTaker.getExpress_type());
                map.put("takePoints", expressTaker.getTake_points());
                map.put("contactName", expressTaker.getContact_name());
                map.put("appointmentPoints", expressTaker.getAppointment_points());
                map.put("phone", expressTaker.getPhone());
                map.put("line", expressTaker.getLine());
                map.put("appointmentTime", expressTaker.getAppointment_time());
                map.put("remark", expressTaker.getRemark());
                ExpressReceive expressReceive = new ExpressReceive();
                expressReceive.setExpress_taker_id(expressTaker.getId());
                expressReceive = expressReceiveService.getByIssuance(expressReceive);
                if (expressReceive != null) {
                    map.put("theUserId", expressReceive.getUser_id());
                    map.put("theRealName", expressReceive.getReal_name());
                    map.put("thePhone", expressReceive.getPhone());
                    map.put("theLine", expressReceive.getLine());
                    ExpressIntegral expressIntegral = new ExpressIntegral();
                    expressIntegral.setUser_id(expressReceive.getUser_id());
                    expressIntegral = expressIntegralService.getByUserId(expressIntegral);
                    if (expressIntegral != null) {
                        map.put("theGrade", expressIntegral.getGrade());
                    } else {
                        map.put("theGrade", "-1");
                    }
                    map.put("theAllTotal", expressReceiveService.getCountByTotal(expressReceive));
                }
            } else {
                map.put("status", -2);
                map.put("tip", "查詢失敗,該記錄不存在");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }

}
