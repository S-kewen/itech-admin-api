package com.boot.yuntechlifeadmin.controller.adminUser;

import com.boot.yuntechlifeadmin.annotation.LoginToken;
import com.boot.yuntechlifeadmin.annotation.PassToken;
import com.boot.yuntechlifeadmin.entity.main.Token;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminLoginRecord;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminNews;
import com.boot.yuntechlifeadmin.service.main.TokenService;
import com.boot.yuntechlifeadmin.service.adminUser.AdminUserService;
import com.boot.yuntechlifeadmin.service.adminUser.AdminLoginRecordService;
import com.boot.yuntechlifeadmin.service.adminUser.AdminNewsService;
import com.boot.yuntechlifeadmin.util.TencentCloudApiUtil;
import com.boot.yuntechlifeadmin.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: skwen
 * @ClassName: AdminUserController
 * @Description: controller
 * @Date: 2020-03-27
 */
@RestController
@RequestMapping("/api/adminUser")
public class AdminUserController {
    @Value("${jwt.config.ttl}")
    private long ttl;
    @Value("${views.host}")
    private String viewsHost;
    @Value("${tencentCloud.cos.avatarPath}")
    private String avatarPath;
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

    @PassToken
    @RequestMapping("login")
    public Map<String, Object> login(String username, String password, String vall, String randstr) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>();
        if (!tencentCloudApiUtil.codeResponse(util.getLocalIp(request), vall, randstr)) {
            map.put("status", -1);
            map.put("tip", "Illegal request");
            return map;
        }
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(username);
        adminUser = adminUserService.getByUsername(adminUser);
        if (adminUser == null) {
            map.put("status", -2);
            map.put("tip", "Account password error");//用戶不存在
        } else {//用戶存在
            AdminLoginRecord adminLoginRecord = new AdminLoginRecord();
            AdminLoginRecord oldRecord = new AdminLoginRecord();
            oldRecord.setIp(util.getLocalIp(request));
            oldRecord = adminLoginRecordService.getByIp(oldRecord);
            if (oldRecord != null && oldRecord.getPosition() != null) {
                adminLoginRecord.setPosition(oldRecord.getPosition());
                adminLoginRecord.setLatitude(oldRecord.getLatitude());
                adminLoginRecord.setLongitude(oldRecord.getLongitude());
            } else {
                Map<String, Object> loginMap = new HashMap<>();
                loginMap = util.getIpAddressesByIp(util.getLocalIp(request));
                adminLoginRecord.setPosition((String) loginMap.get("position"));
                adminLoginRecord.setLatitude((float) loginMap.get("lat"));
                adminLoginRecord.setLongitude((float) loginMap.get("lon"));
            }
            adminLoginRecord.setUser_id(adminUser.getId());
            adminLoginRecord.setType(1);
            adminLoginRecord.setIp(util.getLocalIp(request));
            adminLoginRecord.setSystem(util.getClientSystem(request));
            adminLoginRecord.setBrowser(util.getClientBrowser(request));
            adminLoginRecord.setHeader(request.getHeader("user-agent"));
            adminLoginRecord.setToken("");
            adminUser.setPassword(password);
            adminUser = adminUserService.userLogin(adminUser);
            if (adminUser == null) {//密碼錯誤
                adminLoginRecord.setState(2);
                adminLoginRecordService.insertOne(adminLoginRecord);
                map.put("status", -2);
                map.put("tip", "Account password error");
            } else {
                if (adminUser.getState() == 1) {
                    adminLoginRecord.setState(1);
                    map.put("status", 0);
                    map.put("tip", "success");
                    Token token = new Token();
                    token.setId(adminUser.getId());
                    token.setIp(util.getMd5(util.getLocalIp(request)));
                    token.setUsername(adminUser.getUsername());
                    token.setPassword(adminUser.getPassword());
                    if (adminUser.getType()==1){
                        token.setRole("admin");
                    }else if (adminUser.getType()==2){
                        token.setRole("superAdmin");
                    }else{
                        token.setRole("unknown");
                    }
                    String tokenStr = tokenService.createToken(token);
                    adminLoginRecord.setToken(tokenStr);
                    adminLoginRecordService.insertOne(adminLoginRecord);
                    map.put("token", tokenStr);
                    map.put("ttl", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(new Date().getTime() + ttl)));
                } else if (adminUser.getState() == 2) {
                    adminLoginRecord.setState(3);
                    adminLoginRecordService.insertOne(adminLoginRecord);
                    map.put("status", -3);
                    map.put("tip", "The account is not allowed to login");
                } else if (adminUser.getState() == 3) {
                    adminLoginRecord.setState(4);
                    adminLoginRecordService.insertOne(adminLoginRecord);
                    map.put("status", -4);
                    map.put("tip", "The account is not allowed to login,Lift time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(adminUser.getRelease_time()));
                } else if (adminUser.getState() == 4) {
                    adminLoginRecord.setState(4);
                    adminLoginRecordService.insertOne(adminLoginRecord);
                    map.put("status", -5);
                    map.put("tip", "The account has been frozen");
                } else {
                    adminLoginRecord.setState(5);
                    adminLoginRecordService.insertOne(adminLoginRecord);
                    map.put("status", -6);
                    map.put("tip", "Account status abnormal");
                }
            }
        }
        return map;
    }

    @LoginToken
    @RequestMapping("getIndexInfo")
    public Map<String, Object> getIndexInfo(HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            AdminNews adminNews = new AdminNews();
            adminNews.setUser_id(token.getId());
            adminNews.setState(1);
            adminNews.setType(2);
            map.put("status", 0);
            map.put("tip", "success");
            map.put("username", token.getUsername());
            map.put("messageState", adminNewsService.getCount(adminNews));
        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }

    @LoginToken
    @RequestMapping("modifyInfo")
    public Map<String, Object> getIndexInfo(String email, String phone, String avatar, String remark) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            AdminUser adminUser = new AdminUser();
            adminUser.setId(token.getId());
            adminUser.setEmail(email);
            adminUser.setPhone(phone);
            adminUser.setAvatar(avatar);
            adminUser.setRemark(remark);
            int count = adminUserService.updateById(adminUser);
            if (count > 0) {
                map.put("status", 0);
                map.put("tip", "success");
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

    @LoginToken
    @RequestMapping("modifyPassword")
    public Map<String, Object> modifyPassword(String oldPassword, String newPassword) {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            AdminUser adminUser = new AdminUser();
            adminUser.setUsername(token.getUsername());
            adminUser.setPassword(oldPassword);
            adminUser = adminUserService.userLogin(adminUser);
            if (adminUser != null) {
                adminUser.setPassword(newPassword);
                int count = adminUserService.updateById(adminUser);
                if (count > 0) {
                    map.put("status", 0);
                    map.put("tip", "success");
                } else {
                    map.put("status", -2);
                    map.put("tip", "修改失敗,請稍候再試");
                }
            } else {
                map.put("status", -3);
                map.put("tip", "原密碼錯誤,請檢查後再試");
            }
        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }

    @LoginToken
    @RequestMapping("getUserInfo")
    public Map<String, Object> getModifyInfo() {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            AdminUser adminUser = new AdminUser();
            adminUser.setId(token.getId());
            adminUser = adminUserService.getById(adminUser);
            if (adminUser != null) {
                map.put("status", 0);
                map.put("tip", "success");
                map.put("id", adminUser.getId());
                map.put("username", token.getUsername());
                map.put("email", adminUser.getEmail());
                map.put("phone", adminUser.getPhone());
                map.put("type", adminUser.getType());
                map.put("avatar", adminUser.getAvatar());
                map.put("remark", adminUser.getRemark());
            } else {
                map.put("status", -2);
                map.put("tip", "查詢用戶數據失敗,請稍候再試");
            }

        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }

        return map;
    }

    @PassToken
    @RequestMapping("checkToken")
    public Map<String, Object> checkToken() {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", new Date().getTime());
        Token token = new Token();
        token = tokenService.parseToken(request.getHeader("Authorization"));
        if (token != null) {
            if (token.getExpire_time().after(new Date())) {
                AdminUser adminUser = new AdminUser();
                adminUser.setId(token.getId());
                adminUser = adminUserService.getById(adminUser);
                if (adminUser != null) {
                    if (adminUser.getState() == 1) {
                        if (util.getMd5(adminUser.getPassword()).equals(token.getPassword())) {
                            map.put("status", 0);
                            map.put("tip", "success");
                            map.put("username", token.getUsername());
                            map.put("ttl", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(token.getExpire_time()));
//                            if("1".equals(redisService.get("checkTokenByIp"))){
//                                if(!util.getMd5(otherService.getLocalIp(request)).equals(token.getIp())){
//                                    map.remove("username");
//                                    map.remove("ttl");
//                                    map.put("status",-1);
//                                    map.put("tip","用戶IP異常，請重新登錄");
//                                }
//                            }
                        } else {
                            map.put("status", -1);
                            map.put("tip", "用戶密碼錯誤");
                        }
                    } else {
                        map.put("status", -2);
                        map.put("tip", "用戶狀態異常");
                    }
                } else {
                    map.put("status", -3);
                    map.put("tip", "用戶不存在");
                }
            } else {
                map.put("status", -5);
                map.put("tip", "登錄已到期");
            }
        } else {
            map.put("status", -4);
            map.put("tip", "登錄已失效");
        }
        return map;
    }
    @PassToken
    @RequestMapping("uploadAvatar")
    public Map<String, Object> uploadAvatar(@RequestParam("file") MultipartFile multipartFile, String authorization) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Token token = new Token();
        token = tokenService.parseToken(authorization);
        if (token != null) {
            AdminUser adminUser = new AdminUser();
            adminUser.setId(token.getId());
            adminUser = adminUserService.getById(adminUser);
            if (adminUser != null) {
                String fileName = multipartFile.getOriginalFilename();
                if (multipartFile == null) {
                    map.put("status", -8);
                    map.put("tip", "文件為空");
                    return map;
                }
                if (fileName.lastIndexOf(".") < 0) {
                    map.put("status", -6);
                    map.put("tip", "文件格式錯誤");
                    return map;
                }
                String prefix = fileName.substring(fileName.lastIndexOf("."));
                if (!prefix.equalsIgnoreCase(".jpg") && !prefix.equalsIgnoreCase(".jpeg") && !prefix.equalsIgnoreCase(".bmp") && !prefix.equalsIgnoreCase(".png")) {
                    map.put("status", -7);
                    map.put("tip", "文件格式錯誤");
                    return map;
                }
                String filePath = "imagesFile-" + System.currentTimeMillis();
                final File excelFile = File.createTempFile(filePath, prefix);
                multipartFile.transferTo(excelFile);
                long size = excelFile.length() / 1024;
                if (size > 10 * 1024) {
                    map.put("status", -5);
                    map.put("tip", "文件大小超出限制");
                    return map;
                }
                Map<String, Object> cosUpload = new HashMap<>();
                String key = avatarPath + util.getMd5(adminUser.getUsername() + "_avatar") + ".png";
                cosUpload = tencentCloudApiUtil.cosUpload(excelFile, key);
                if (!excelFile.delete()) {
                    System.out.println("delete fail:" + excelFile.getName());
                }
                if (cosUpload.get("tip").equals("success")) {
                    map.put("status", 0);
                    map.put("tip", "上傳成功");
                    map.put("url", cosUpload.get("url"));
                } else {
                    map.put("status", -2);
                    map.put("tip", "上傳失敗,請稍後再試");
                }
            } else {
                map.put("status", -3);
                map.put("tip", "登錄已失效，請重新登錄");
            }
        } else {
            map.put("status", -1);
            map.put("tip", "登錄已失效，請重新登錄");
        }
        return map;
    }
}
