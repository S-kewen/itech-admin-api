package com.boot.yuntechlifeadmin.dao.system;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Advert;
import com.boot.yuntechlifeadmin.entity.system.MessageQueue;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: MessageQueueMapper
 * @Description: dao
 * @Date: 2020-03-17
 */
@Mapper
public interface MessageQueueMapper {
    List<MessageQueue> getList(AdminUser adminUser);
    int deleteOne(MessageQueue messageQueue);
    int deleteMore(MessageQueue messageQueue);
    int updateOne(MessageQueue messageQueue);
    int updateMore(MessageQueue messageQueue);
    MessageQueue getInfo(MessageQueue messageQueue);
}