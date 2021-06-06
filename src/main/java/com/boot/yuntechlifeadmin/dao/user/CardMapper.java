package com.boot.yuntechlifeadmin.dao.user;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import com.boot.yuntechlifeadmin.entity.user.Card;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName:CardMapper
 * @Description: dao
 * @Date: 2020-03-14
 */
@Mapper
public interface CardMapper {
    List<Card> getList(AdminUser adminUser);
    int deleteOne(Card card);
    int deleteMore(Card card);
    int updateOne(Card card);
    int updateMore(Card card);
    int insertMore(List<Card> cards);
}