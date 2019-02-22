package com.nf.lc.myspringbootdemo.shiro;

import com.nf.lc.myspringbootdemo.entity.Admin;
import com.nf.lc.myspringbootdemo.entity.AdminPower;
import com.nf.lc.myspringbootdemo.service.AdminPowerService;
import com.nf.lc.myspringbootdemo.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义Realm
 *
 * @author LC
 * @create 2019-02-21 14:51
 */

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminPowerService adminPowerService;

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //添加资源的授权字符串
//        simpleAuthorizationInfo.addStringPermission("insert:student");

        //得到当前用户
        Subject subject = SecurityUtils.getSubject();
        Admin currentAdmin = (Admin) subject.getPrincipal();

        List<AdminPower> adminPowerList = adminPowerService.findByAdminNumberToAdminPower(currentAdmin.getAdminNumber());

        for (AdminPower adminPower : adminPowerList) {
            simpleAuthorizationInfo.addStringPermission(adminPower.getPowerName());
        }


        return simpleAuthorizationInfo;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        //编写shiro判断逻辑，判断用户名和密码
        //1、判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

        Admin admin = adminService.findByAdminNumber(token.getUsername());

        if(admin == null){
            //用户名不存在
            return null;//shiro底层回抛出UnknowAccountException
        }
        //2、判断密码
        return new SimpleAuthenticationInfo(admin,admin.getAdminPassword(),"");
    }
}
