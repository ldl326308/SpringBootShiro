package com.nf.lc.myspringbootdemo.service;

import com.nf.lc.myspringbootdemo.entity.Admin;

public interface AdminService {

    public Admin findByAdminNumber(String adminNumber);
}
