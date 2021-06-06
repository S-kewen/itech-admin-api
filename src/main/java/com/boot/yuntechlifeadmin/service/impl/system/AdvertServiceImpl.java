package com.boot.yuntechlifeadmin.service.impl.system;

import com.boot.yuntechlifeadmin.dao.system.AdvertMapper;
import com.boot.yuntechlifeadmin.dao.system.NoticeMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Advert;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import com.boot.yuntechlifeadmin.service.system.AdvertService;
import com.boot.yuntechlifeadmin.service.system.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: NoticeServiceImpl
 * @Description: Service
 * @Date: 2020-03-17
 */
@Component
public class AdvertServiceImpl implements AdvertService {
    @Autowired
    private AdvertMapper advertMapper;

    @Override
    public List<Advert> getList(AdminUser adminUser) {
        return advertMapper.getList(adminUser);
    }
    @Override
    public int deleteOne(Advert advert) {
        return advertMapper.deleteOne(advert);
    }
    @Override
    public int deleteMore(Advert advert) {
        return advertMapper.deleteMore(advert);
    }
    @Override
    public int updateOne(Advert advert) {
        return advertMapper.updateOne(advert);
    }
    @Override
    public int updateMore(Advert advert) {
        return advertMapper.updateMore(advert);
    }

    @Override
    public int insertOne(Advert advert) {
        return advertMapper.insertOne(advert);
    }

    @Override
    public Advert getInfo(Advert advert) {
        return advertMapper.getInfo(advert);
    }

}

