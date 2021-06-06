package com.boot.yuntechlifeadmin.service.impl.system;

import com.boot.yuntechlifeadmin.dao.system.AdvertMapper;
import com.boot.yuntechlifeadmin.dao.system.MessageQueueMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Advert;
import com.boot.yuntechlifeadmin.entity.system.MessageQueue;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import com.boot.yuntechlifeadmin.service.system.AdvertService;
import com.boot.yuntechlifeadmin.service.system.MessageQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: MessageQueueServiceImpl
 * @Description: Service
 * @Date: 2020-03-17
 */
@Component
public class MessageQueueServiceImpl implements MessageQueueService {
    @Autowired
    private MessageQueueMapper messageQueueMapper;

    @Override
    public List<MessageQueue> getList(AdminUser adminUser) {
        return messageQueueMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(MessageQueue messageQueue) {
        return messageQueueMapper.deleteOne(messageQueue);
    }

    @Override
    public int deleteMore(MessageQueue messageQueue) {
        return messageQueueMapper.deleteMore(messageQueue);
    }

    @Override
    public int updateOne(MessageQueue messageQueue) {
        return messageQueueMapper.updateOne(messageQueue);
    }

    @Override
    public int updateMore(MessageQueue messageQueue) {
        return messageQueueMapper.updateMore(messageQueue);
    }
    @Override
    public MessageQueue getInfo(MessageQueue messageQueue) {
        return messageQueueMapper.getInfo(messageQueue);
    }
}

