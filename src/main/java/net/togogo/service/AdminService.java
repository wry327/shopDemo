package net.togogo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.togogo.dao.AdminDao;
import net.togogo.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;

    /*查询所有管理员*/
    public List<Admin> getAllAdmin(int page,int limit)
    {
        /*计算当前页是从第几条数据开始查询*/
        PageHelper.startPage(page,limit);
        return adminDao.getAllAdmin();
    }

    /*根据用户名和密码匹配，验证是否登录*/
    public Boolean checkLogin(String username, String password, HttpServletRequest request)
    {
        Admin admin = adminDao.getAdminByUP(username,password);

        /*如果查询到的用户不为null*/
        if(admin!=null)
        {
            /*用户名和密码是正确*/
            /*可进行登录，用户信息存到session当中*/
            request.getSession().setAttribute("loginAdmin",admin);
            return true;
        }
        else {
            return false;
        }
    }

    /*添加管理员*/
    public Boolean addAdmin(Admin admin)
    {
        int addResult = adminDao.addAdmin(admin.getUsername(),admin.getPassword(),admin.getAdminType());

        /*根据返回的整数判断是否添加成功*/
        if(addResult>0)
        {
            /*返回true表示添加成功*/
            return true;
        }
        else
        {
            return false;
        }
    }

    /*删除管理员*/
    public Boolean deleteAdmin(List<Integer> ids)
    {
        int deletResult = adminDao.deleteAdminByIDS(ids);

        if(deletResult>0)
        {
            return true;
        }
        else {
            return false;
        }
    }

    /*修改管理员密码*/
    public Boolean updatePwd(int id,String oldPwd,String newPwd)
    {
        int updateReuslt = adminDao.updatePwd(id,oldPwd,newPwd);

        if(updateReuslt>0)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
