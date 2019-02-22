package com.nf.lc.myspringbootdemo.dao;

import com.nf.lc.myspringbootdemo.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

   public Admin findByAdminNumber(@Param("adminNumber") String adminNumber);

}
