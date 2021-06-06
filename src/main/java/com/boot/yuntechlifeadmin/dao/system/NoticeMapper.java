package com.boot.yuntechlifeadmin.dao.system;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Advert;
import com.boot.yuntechlifeadmin.entity.system.MessageBoard;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: skwen
 * @ClassName:NoticeMapper
 * @Description: dao
 * @Date: 2020-03-17
 */
@Mapper
public interface NoticeMapper {
    List<Notice> getList(AdminUser adminUser);
    int deleteOne(Notice notice);
    int deleteMore(Notice notice);
    int updateOne(Notice notice);
    int updateMore(Notice notice);
    int insertOne(Notice notice);
    Notice getInfo(Notice notice);
}