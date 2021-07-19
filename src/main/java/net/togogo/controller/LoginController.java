package net.togogo.controller;

import net.togogo.domain.Admin;
import net.togogo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    AdminService adminService;

    /*访问登录页面*/
    @RequestMapping("/toLogin")
    public String toLogin()
    {
        return "login";
    }


    /*验证登录*/
    @RequestMapping("/login")
    public String login(Admin admin, Model model, HttpServletRequest request)
    {
        /*调用验证登录的逻辑类去验证登录*/
        if(adminService.checkLogin(admin.getUsername(),admin.getPassword(),request)==true)
        {
            return "index";
        }else {
            model.addAttribute("msg","用户名或者密码错误！");
            return "login";
        }
    }

    /*访问欢迎页面*/
    @RequestMapping("/welcome")
    public String welcome()
    {
        return "welcome";
    }
}
