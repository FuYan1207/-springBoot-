package com.fuyan.office_routine_ms.servcie;

import com.fuyan.office_routine_ms.pojo.Announcements;

import java.util.List;

public interface AnnouncementsService {
    void addAnnouncement(Announcements announcement);

    List<Announcements> announcementsList();

    void delAnnouncement(int id);
}
