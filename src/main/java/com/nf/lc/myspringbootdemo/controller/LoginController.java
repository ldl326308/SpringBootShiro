package com.nf.lc.myspringbootdemo.controller;

import com.nf.lc.myspringbootdemo.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 这是一个 登入页面
 *
 * @author LC
 * @create 2019-02-21 14:33
 */

@Controller
public class LoginController {

    /**
     * 登入逻辑处理
     * @return
     */
    @GetMapping(value = "/login")
    public String login(Model model,String username, String password){

        /**
         * Shiro 认证操作
         */
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try{
            subject.login(token);

            System.out.println("验证通过。。。");
            return "/success";

        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "/login";
        } catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "/login";
        }
    }

    @GetMapping(value = "/add")
    public String add(){
        return "/user/add";
    }

    @GetMapping(value = "/update")
    public String update(){
        return "/user/update";
    }

}
