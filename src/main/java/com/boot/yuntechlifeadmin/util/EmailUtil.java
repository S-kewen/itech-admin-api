package com.boot.yuntechlifeadmin.util;

import org.springframework.util.MultiValueMap;

import java.io.IOException;

public interface EmailUtil {
    boolean sendEasyMail(String to, String title, String msg) throws IOException;

    boolean sendYuntechFlowWarn(String to, String title, String ip, double insUp, double insDown, double extUp, double extDown, double flow, double ratio, double warnValue) throws IOException;
}
