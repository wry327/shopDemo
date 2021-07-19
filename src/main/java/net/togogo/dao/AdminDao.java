package net.togogo.dao;

import net.togogo.domain.Admin;

import java.util.List;

public interface AdminDao {
    /*分页查询所有管理员*/
    public List<Admin> getAllAdmin();

    /*验证登录*/
    public Admin getAdminByUP(String username,String password);
}
