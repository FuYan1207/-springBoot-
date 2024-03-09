package com.fuyan.office_routine_ms.mapper;

import com.fuyan.office_routine_ms.pojo.Meetings;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeetingMapper {
    List<Meetings> getAll();

    void add(Meetings meetings);

    Integer count();
}
