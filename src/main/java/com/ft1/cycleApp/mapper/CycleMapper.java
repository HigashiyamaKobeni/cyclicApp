package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.Cycle;

import java.util.ArrayList;
import java.util.Date;

public interface CycleMapper {
    Integer insertCycle(Cycle newCycle);

    Integer deleteCycle(Integer cycleId);

    Cycle getCycle(Integer cycleId);

    Integer getNoteId(Integer cycleId);

    Integer setCycleName(String cycleName, Integer cycleId);

    Integer setStartDate(Date newStartDate, Integer cycleId);

    Integer setEndDate(Date newEndDate, Integer cycleId);
    Integer addTag(Integer cycleId, Integer tagId);
    Integer removeTag(Integer cycleId, Integer tagId);
    Integer addNote(Integer newNoteId, Integer cycleId);
    Integer removeNote(Integer cycleId);

    Integer addReminder(Integer newReminderId, Integer cycleId);

    Integer removeReminder(Integer cycleId);
    Integer addEvent(Integer cycleId, Integer eventId);
    Integer removeEvent(Integer cycleId, Integer eventId);

    ArrayList<Integer> checkEvent(Integer cycleId);

    ArrayList<Integer> checkTag(Integer cycleId);

    ArrayList<Integer> checkProject(Integer cycleId);

    Integer deleteProject(Integer cycleId, Integer projectId);

    ArrayList<Cycle> getCyclesByUserId(Integer userId);
}
