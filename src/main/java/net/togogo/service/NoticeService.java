package net.togogo.service;

import net.togogo.dao.NoticeDao;
import net.togogo.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoticeService {

    @Autowired
    NoticeDao noticeDao;

    /*查询所有公告*/
    public List<Notice> getAllNotices()
    {
        return noticeDao.getAllNotices();
    }
}
