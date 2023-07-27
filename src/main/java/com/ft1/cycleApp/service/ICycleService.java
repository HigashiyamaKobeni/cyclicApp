package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.Cycle;

import java.util.ArrayList;
import java.util.Date;

public interface ICycleService {
    void insertCycle(Cycle newCycle);

    void deleteCycle(Integer cycleId);

    Cycle getCycle(Integer cycleId);

    Integer getNoteId(Integer cycleId);

    void setCycleName(String cycleName, Integer cycleId);

    void setStartDate(Date newStartDate, Integer cycleId);

    void setEndDate(Date newEndDate, Integer cycleId);

    void addTag(Integer cycleId, Integer tagId);

    void removeTag(Integer cycleId, Integer tagId);

    void addNote(Integer newNoteId, Integer cycleId);

    void removeNote(Integer cycleId);

    void addReminder(Integer newReminderId, Integer cycleId);

    void removeReminder(Integer cycleId);

    void addEvent(Integer cycleId, Integer eventId);

    void removeEvent(Integer cycleId, Integer eventId);

    void deleteProject(Integer cycleId, Integer projectId);

    ArrayList<Cycle> getCyclesByUserId(Integer userId);

    ArrayList<Integer> getEventId(Integer cycleId);
}
