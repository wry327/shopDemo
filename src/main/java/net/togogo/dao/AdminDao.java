package net.togogo.dao;

import net.togogo.domain.Admin;

import java.util.List;

public interface AdminDao {
    /*分页查询所有管理员*/
    public List<Admin> getAllAdmin();

    /*验证登录*/
    public Admin getAdminByUP(String username,String password);

    /*添加管理员*/
    public int addAdmin(String username,String password,int adminType);

    /*删除管理员*/
    public int deleteAdminByIDS(List<Integer> ids);

    /*修改密码*/
    public int updatePwd(int id,String oldPwd,String newPwd);

}
