package com.boot.yuntechlifeadmin.service.impl.user;

import com.boot.yuntechlifeadmin.dao.user.BindingLineMapper;
import com.boot.yuntechlifeadmin.dao.user.CardMapper;
import com.boot.yuntechlifeadmin.entity.adminUser.AdminUser;
import com.boot.yuntechlifeadmin.entity.system.Notice;
import com.boot.yuntechlifeadmin.entity.user.BindingLine;
import com.boot.yuntechlifeadmin.entity.user.Card;
import com.boot.yuntechlifeadmin.service.user.BindingLineService;
import com.boot.yuntechlifeadmin.service.user.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: skwen
 * @ClassName: BindingLineServiceImpl
 * @Description: Service
 * @Date: 2020-03-24
 */
@Component
public class BindingLineServiceImpl implements BindingLineService {
    @Autowired
    private BindingLineMapper bindingLineMapper;

    @Override
    public List<BindingLine> getList(AdminUser adminUser) {
        return bindingLineMapper.getList(adminUser);
    }

    @Override
    public int deleteOne(BindingLine bindingLine) {
        return bindingLineMapper.deleteOne(bindingLine);
    }

    @Override
    public int deleteMore(BindingLine bindingLine) {
        return bindingLineMapper.deleteMore(bindingLine);
    }

    @Override
    public int updateOne(BindingLine bindingLine) {
        return bindingLineMapper.updateOne(bindingLine);
    }

    @Override
    public int updateMore(BindingLine bindingLine) {
        return bindingLineMapper.updateMore(bindingLine);
    }

    @Override
    public BindingLine getInfo(BindingLine bindingLine) {
        return bindingLineMapper.getInfo(bindingLine);
    }


}
