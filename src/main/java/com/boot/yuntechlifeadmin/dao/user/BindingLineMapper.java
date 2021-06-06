package com.boot.yuntechlifeadmin.dao.user;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import com.boot.yuntechlifeadmin.entity.user.BindingLine;
import com.boot.yuntechlifeadmin.entity.user.Card;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName:BindingLineMapper
 * @Description: dao
 * @Date: 2020-03-25
 */
@Mapper
public interface BindingLineMapper {
    List<BindingLine> getList(AdminUser adminUser);
    int deleteOne(BindingLine bindingLine);
    int deleteMore(BindingLine bindingLine);
    int updateOne(BindingLine bindingLine);
    int updateMore(BindingLine bindingLine);
    BindingLine getInfo(BindingLine bindingLine);
}