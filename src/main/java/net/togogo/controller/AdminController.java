package net.togogo.controller;


import com.github.pagehelper.PageInfo;
import net.togogo.domain.Admin;
import net.togogo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/adminIndex")
    public String adminIndex()
    {
        return "admin/adminIndex";
    }

    @RequestMapping("/adminAll")
    @ResponseBody
    public Map<String,Object> adminAll(int page,int limit)
    {
        Map<String,Object> map = new HashMap<>();

        /*所有管理员*/
        List<Admin> adminList = adminService.getAllAdmin(page,limit);
        /*包含分页信息*/
        PageInfo<Admin> pageInfo = new PageInfo<>(adminList);
        map.put("data",pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        map.put("code",0);
        map.put("msg","");
        return map;
    }

}
