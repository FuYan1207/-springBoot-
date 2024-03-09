package com.fuyan.office_routine_ms.servcie.impl;

import com.fuyan.office_routine_ms.mapper.AnnouncementMapper;
import com.fuyan.office_routine_ms.pojo.Announcements;
import com.fuyan.office_routine_ms.pojo.User;
import com.fuyan.office_routine_ms.servcie.AnnouncementsService;
import com.fuyan.office_routine_ms.servcie.UserService;
import com.fuyan.office_routine_ms.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnnouncementServiceImpl implements AnnouncementsService {

    @Autowired
    private AnnouncementMapper announcementMapper;
    @Autowired
    private UserService userService;
    @Override
    public void addAnnouncement(Announcements announcement) {
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUsername(username);
        announcement.setPublisher(user.getUserId());
        announcementMapper.add(announcement);
    }

    @Override
    public List<Announcements> announcementsList() {
        List<Announcements> announcementsList = announcementMapper.getAll();
        return announcementsList;
    }

    @Override
    public void delAnnouncement(int id) {
        announcementMapper.delById(id);
    }
}
