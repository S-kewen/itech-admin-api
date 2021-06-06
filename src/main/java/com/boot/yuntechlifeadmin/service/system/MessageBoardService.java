package com.boot.yuntechlifeadmin.service.system;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Feedback;
import com.boot.yuntechlifeadmin.entity.system.MessageBoard;

import java.util.List;
import java.util.Map;

public interface MessageBoardService {
    List<MessageBoard> getList(AdminUser adminUser);
    int deleteOne(MessageBoard messageBoard);
    int deleteMore(MessageBoard messageBoard);
    int updateOne(MessageBoard messageBoard);
    int updateMore(MessageBoard messageBoard);
}
