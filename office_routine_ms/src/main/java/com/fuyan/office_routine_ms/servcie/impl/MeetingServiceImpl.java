package com.fuyan.office_routine_ms.servcie.impl;

import com.fuyan.office_routine_ms.mapper.MeetingMapper;
import com.fuyan.office_routine_ms.pojo.Meetings;
import com.fuyan.office_routine_ms.servcie.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingServiceImpl  implements MeetingService {

    @Autowired
    private MeetingMapper meetingMapper;

    @Override
    public List<Meetings> getAll() {
        List<Meetings> meetingsList = meetingMapper.getAll();
        return meetingsList;
    }

    @Override
    public void addMeeting(Meetings meetings) {
        meetingMapper.add(meetings);
    }

    @Override
    public Integer count() {
        return meetingMapper.count();
    }
}
