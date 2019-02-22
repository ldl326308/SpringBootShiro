package com.nf.lc.myspringbootdemo.service.imp;

import com.nf.lc.myspringbootdemo.dao.AdminMapper;
import com.nf.lc.myspringbootdemo.entity.Admin;
import com.nf.lc.myspringbootdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * admin service层
 *
 * @author LC
 * @create 2019-02-21 20:06
 */

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findByAdminNumber(String adminNumber) {
        Admin item = adminMapper.findByAdminNumber(adminNumber);
        return item;
    }
}
