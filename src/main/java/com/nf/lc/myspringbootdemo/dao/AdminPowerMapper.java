package com.nf.lc.myspringbootdemo.dao;

import com.nf.lc.myspringbootdemo.entity.Admin;
import com.nf.lc.myspringbootdemo.entity.AdminPower;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminPowerMapper {

   public List<AdminPower> findByAdminNumberToAdminPower(@Param("adminNumber") String adminNumber);

}
