package com.boot.yuntechlifeadmin.service.user;

import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.user.BindingLine;
import com.boot.yuntechlifeadmin.entity.user.Card;

import java.util.List;

public interface BindingLineService {
    List<BindingLine> getList(AdminUser adminUser);
    int deleteOne(BindingLine bindingLine);
    int deleteMore(BindingLine bindingLine);
    int updateOne(BindingLine bindingLine);
    int updateMore(BindingLine bindingLine);
    BindingLine getInfo(BindingLine bindingLine);
}
