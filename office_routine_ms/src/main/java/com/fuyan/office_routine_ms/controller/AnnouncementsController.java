package com.fuyan.office_routine_ms.controller;

import com.fuyan.office_routine_ms.pojo.Announcements;
import com.fuyan.office_routine_ms.pojo.Result;
import com.fuyan.office_routine_ms.servcie.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcementsService")
@Validated
public class AnnouncementsController {

    @Autowired
    private AnnouncementsService announcementsService;

    /**
     * 获取所有公告
     * @return
     */
    @GetMapping
    public Result<List<Announcements>> announcementsList(){
        List<Announcements> announcementsList = announcementsService.announcementsList();
        return Result.success(announcementsList);
    }

    /**
     * 根据id删除公告
     * @param id
     * @return
     */
    @DeleteMapping
    public Result delAnnouncement(int id){
        announcementsService.delAnnouncement(id);
        return Result.success();
    }

    /**
     * 添加公告
     * @param announcement
     * @return
     */
    @PostMapping
    public Result addAnnouncement(@RequestBody Announcements announcement){
        announcementsService.addAnnouncement(announcement);
        return Result.success();
    }

}
