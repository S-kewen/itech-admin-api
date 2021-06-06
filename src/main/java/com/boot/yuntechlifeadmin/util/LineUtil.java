package com.boot.yuntechlifeadmin.util;

import java.io.IOException;

public interface LineUtil {
    boolean pushMessage(String to, String type, String text) throws IOException;
}
