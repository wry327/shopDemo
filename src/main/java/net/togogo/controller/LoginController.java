package net.togogo.controller;

import net.togogo.domain.Admin;
import net.togogo.domain.Notice;
import net.togogo.service.AdminService;
import net.togogo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    AdminService adminService;

    @Autowired
    NoticeService noticeService;

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
    public String welcome(Model model)
    {
        /*欢迎页面需要展示公告信息，查询公告信息并且放到model内传回页面*/
        model.addAttribute("noticeList",noticeService.getAllNotices());
        return "welcome";
    }
}
