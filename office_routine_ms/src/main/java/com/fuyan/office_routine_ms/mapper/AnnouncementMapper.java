package com.fuyan.office_routine_ms.mapper;

import com.fuyan.office_routine_ms.pojo.Announcements;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementMapper {

    void add(Announcements announcement);

    List<Announcements> getAll();

    void delById(int id);
}
