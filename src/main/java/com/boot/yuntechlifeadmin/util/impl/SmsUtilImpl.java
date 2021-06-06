package com.boot.yuntechlifeadmin.util.impl;

import com.boot.yuntechlifeadmin.util.EmailUtil;
import com.boot.yuntechlifeadmin.util.HttpUtil;
import com.boot.yuntechlifeadmin.util.SmsUtil;
import com.boot.yuntechlifeadmin.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @Author: skwen
 * @ClassName: SmsUtilImpl
 * @Description: 工具類
 * @Date: 2020-03-14
 */
@Component
public class SmsUtilImpl implements SmsUtil {
    @Value("${yunCourier.appId}")
    private int appId;
    @Value("${yunCourier.token}")
    private String token;
    @Autowired
    private Util util;
    @Autowired
    private HttpUtil httpUtil;

    @Override
    public boolean sendSmsToTaiwan(String to, String msg) throws IOException {
        String result = httpUtil.get("https://courier-api.iskwen.com/api/smsToTaiwan?applyId=" + appId + "&token=" + token + "&subject=yuntechLife&to=" + to + "&msg=" + msg, null);
        if (result != null && result != "") {
            if (util.getJsonInt(result, "status") == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
