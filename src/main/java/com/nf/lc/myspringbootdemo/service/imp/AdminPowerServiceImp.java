package com.nf.lc.myspringbootdemo.service.imp;

import com.nf.lc.myspringbootdemo.dao.AdminPowerMapper;
import com.nf.lc.myspringbootdemo.entity.AdminPower;
import com.nf.lc.myspringbootdemo.service.AdminPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员权限的service层
 *
 * @author LC
 * @create 2019-02-22 9:19
 */

@Service
public class AdminPowerServiceImp implements AdminPowerService {

    @Autowired
    private AdminPowerMapper adminPowerMapper;

    @Override
    public List<AdminPower> findByAdminNumberToAdminPower(String adminNumber) {
        return adminPowerMapper.findByAdminNumberToAdminPower(adminNumber);
    }
}
