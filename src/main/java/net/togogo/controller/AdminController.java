package net.togogo.controller;


import com.github.pagehelper.PageInfo;
import net.togogo.domain.Admin;
import net.togogo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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


    /*访问管理员添加页面*/
    @RequestMapping("/adminAdd")
    public String toAdminAdd()
    {
        return "admin/adminAdd";
    }

    /*添加管理员操作*/
    @RequestMapping("/addAdminSubmit")
    @ResponseBody
    public Map<String,Object> addAdmin(Admin admin)
    {
        HashMap<String,Object> map = new HashMap<>();
        /*调用AdminService里面的添加管理员的业务*/
        boolean addresult = adminService.addAdmin(admin);

        if(addresult==true)
        {
            map.put("code",0);
        }
        else {
            map.put("code",-1);
        }
        return map;
    }


    /*根据id删除管理员*/
    @RequestMapping("/deleteAdminByIds")
    @ResponseBody
    public Map<String,Object> deleteAdmins(String ids)
    {
        System.out.println(ids);
        System.out.println("进入删除管理员的控制器");
        HashMap<String,Object> map = new HashMap<>();

        /*需要把ids转化为集合*/
        List<String> idlist = Arrays.asList(ids.split(","));
        List<Integer> idList = new ArrayList<>();

        for (String id:idlist)
        {
            idList.add(Integer.parseInt(id));
        }

        System.out.println(idList);
        boolean deleteresult = adminService.deleteAdmin(idList);

        if(deleteresult==true)
        {
            map.put("code",0);
        }
        else {
            map.put("code",-1);
        }
        return map;
    }

    /*打开修改密码的页面*/
    @RequestMapping("/queryAdminById")
    public String queryAdminById(String id, Model model)
    {
        model.addAttribute("id",id);
        return "admin/updateAdmin";
    }

    /*修改管理员密码*/
    @RequestMapping("/updatePwdSubmit")
    @ResponseBody
    public Map<String,Object> updatePwd(String id,String oldPwd,String newPwd)
    {
        System.out.println("进入修改密码的控制器！");
        System.out.println(id+oldPwd+newPwd);

        /*调用AdminService内的修改密码的业务*/
        boolean updateresult = adminService.updatePwd(Integer.parseInt(id),oldPwd,newPwd);

        HashMap<String,Object> map = new HashMap<>();
        if(updateresult==true)
        {
            map.put("code",0);
        }
        else {
            map.put("code",-1);
        }
        return map;
    }
}
