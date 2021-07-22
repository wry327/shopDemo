package net.togogo.dao;

import net.togogo.domain.Notice;

import java.util.List;

public interface NoticeDao {

    /*查询所有公告*/
    public List<Notice> getAllNotices();
}
