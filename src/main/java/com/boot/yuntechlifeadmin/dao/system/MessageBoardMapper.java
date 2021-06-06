package com.boot.yuntechlifeadmin.dao.system;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Feedback;
import com.boot.yuntechlifeadmin.entity.system.MessageBoard;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: skwen
 * @ClassName:MessageBoardMapper
 * @Description: dao
 * @Date: 2020-03-15
 */
@Mapper
public interface MessageBoardMapper {
    List<MessageBoard> getList(AdminUser adminUser);
    int deleteOne(MessageBoard messageBoard);
    int deleteMore(MessageBoard messageBoard);
    int updateOne(MessageBoard messageBoard);
    int updateMore(MessageBoard messageBoard);
}