package com.boot.yuntechlifeadmin.service.impl.user;

import com.boot.yuntechlifeadmin.dao.user.CardMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.Card;
import com.boot.yuntechlifeadmin.service.user.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: CardServiceImpl
 * @Description: Service
 * @Date: 2020-03-08
 */
@Component
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;

    @Override
    public  List<Card> getList(AdminUser adminUser) {
        return cardMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(Card card) {
        return cardMapper.deleteOne(card);
    }

    @Override
    public int deleteMore(Card card) {
        return cardMapper.deleteMore(card);
    }

    @Override
    public int updateOne(Card card) {
        return cardMapper.updateOne(card);
    }

    @Override
    public int updateMore(Card card) {
        return cardMapper.updateMore(card);
    }
    @Override
    public int insertMore(List<Card> cards) {
        return cardMapper.insertMore(cards);
    }
}
