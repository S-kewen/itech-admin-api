package com.boot.yuntechlifeadmin.service.system;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Advert;
import com.boot.yuntechlifeadmin.entity.system.Notice;

import java.util.List;

public interface AdvertService {
    List<Advert> getList(AdminUser adminUser);
    int deleteOne(Advert advert);
    int deleteMore(Advert advert);
    int updateOne(Advert advert);
    int updateMore(Advert advert);
    int insertOne(Advert advert);
    Advert getInfo (Advert advert);
}
