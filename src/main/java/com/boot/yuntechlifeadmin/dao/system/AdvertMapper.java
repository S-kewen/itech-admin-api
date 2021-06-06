package com.boot.yuntechlifeadmin.dao.system;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Advert;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName:AdvertMapper
 * @Description: dao
 * @Date: 2020-03-17
 */
@Mapper
public interface AdvertMapper {
    List<Advert> getList(AdminUser adminUser);
    int deleteOne(Advert advert);
    int deleteMore(Advert advert);
    int updateOne(Advert advert);
    int updateMore(Advert advert);
    int insertOne(Advert advert);
    Advert getInfo (Advert advert);
}