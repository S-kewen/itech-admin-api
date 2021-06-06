package com.boot.yuntechlifeadmin.service.system;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Advert;
import com.boot.yuntechlifeadmin.entity.system.MessageQueue;

import java.util.List;

public interface MessageQueueService {
    List<MessageQueue> getList(AdminUser adminUser);
    int deleteOne(MessageQueue messageQueue);
    int deleteMore(MessageQueue messageQueue);
    int updateOne(MessageQueue messageQueue);
    int updateMore(MessageQueue messageQueue);
    MessageQueue getInfo(MessageQueue messageQueue);
}
