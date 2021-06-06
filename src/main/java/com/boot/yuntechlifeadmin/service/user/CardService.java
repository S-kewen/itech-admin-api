package com.boot.yuntechlifeadmin.service.user;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.Card;

import java.util.List;

public interface CardService {
    List<Card> getList(AdminUser adminUser);
    int deleteOne(Card card);
    int deleteMore(Card card);
    int updateOne(Card card);
    int updateMore(Card card);
    int insertMore(List<Card> cards);
}
