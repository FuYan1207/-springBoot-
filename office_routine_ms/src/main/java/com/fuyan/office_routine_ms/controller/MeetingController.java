package com.fuyan.office_routine_ms.controller;

import com.fuyan.office_routine_ms.pojo.Meetings;
import com.fuyan.office_routine_ms.pojo.Result;
import com.fuyan.office_routine_ms.servcie.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;


    /**
     * 获取所有会议
     * @return
     */
    @PostMapping("/getAll")
    public Result<List<Meetings>> getAll(){
        List<Meetings> meetings = meetingService.getAll();
        return Result.success(meetings);
    }

    /**
     * 添加会议
     * @param meetings
     * @return
     */
    @PostMapping("/add")
    public Result addMeeting(@RequestBody Meetings meetings){
        meetingService.addMeeting(meetings);
        System.out.println(meetings);
        return Result.success();
    }

    /**
     * 获取会议数量
     * @return
     */
    @GetMapping("/count")
    public Result<Integer> count(){
        Integer count = meetingService.count();
        return Result.success(count);
    }
}
