package com.boot.yuntechlifeadmin.util;

import java.io.IOException;

public interface SmsUtil {
    boolean sendSmsToTaiwan(String to, String msg) throws IOException;
}
