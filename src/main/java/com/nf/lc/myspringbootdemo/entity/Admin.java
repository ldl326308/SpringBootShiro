package com.nf.lc.myspringbootdemo.entity;

/**
 * 管理员实体类
 *
 * @author LC
 * @create 2019-02-21 19:34
 */

public class Admin {

    int adminId;
    String adminName;
    String adminNumber;
    String adminPassword;

    public Admin(){}

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(String adminNumber) {
        this.adminNumber = adminNumber;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
