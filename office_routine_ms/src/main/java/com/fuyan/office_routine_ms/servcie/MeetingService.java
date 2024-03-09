package com.fuyan.office_routine_ms.servcie;

import com.fuyan.office_routine_ms.pojo.Meetings;

import java.util.List;

public interface MeetingService {
    List<Meetings> getAll();

    void addMeeting(Meetings meetings);

    Integer count();
}
