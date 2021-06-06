package com.boot.yuntechlifeadmin.service.impl.system;

import com.boot.yuntechlifeadmin.dao.system.FeedbackMapper;
import com.boot.yuntechlifeadmin.dao.system.MessageBoardMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Feedback;
import com.boot.yuntechlifeadmin.entity.system.MessageBoard;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import com.boot.yuntechlifeadmin.service.system.FeedbackService;
import com.boot.yuntechlifeadmin.service.system.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: skwen
 * @ClassName: MessageBoardServiceImpl
 * @Description: Service
 * @Date: 2020-03-15
 */
@Component
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;


    @Override
    public List<MessageBoard> getList(AdminUser adminUser) {
        return messageBoardMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(MessageBoard messageBoard) {
        return messageBoardMapper.deleteOne(messageBoard);
    }

    @Override
    public int deleteMore(MessageBoard messageBoard) {
        return messageBoardMapper.deleteMore(messageBoard);
    }

    @Override
    public int updateOne(MessageBoard messageBoard) {
        return messageBoardMapper.updateOne(messageBoard);
    }

    @Override
    public int updateMore(MessageBoard messageBoard) {
        return messageBoardMapper.updateMore(messageBoard);
    }
}

