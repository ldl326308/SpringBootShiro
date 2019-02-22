package com.nf.lc.myspringbootdemo.service;

import com.nf.lc.myspringbootdemo.entity.AdminPower;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminPowerService {

   public List<AdminPower> findByAdminNumberToAdminPower(String adminNumber);

}
