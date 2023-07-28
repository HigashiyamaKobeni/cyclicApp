package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.Event;

import java.util.ArrayList;
import java.util.Date;

public interface IEventService {
    void updateCycleDate(Integer eventId);
    
    void insertEvent(Event newEvent);

    void deleteEvent(Integer eventId);

    Event getEvent(Integer eventId);

    ArrayList<Event> getEventByUid(Integer userId);

    Integer getNoteId(Integer eventId);

    void updateEventName(String newEventName, Integer eventId);

    void addTag(Integer eventId, Integer tagId);

    ArrayList<Integer> getTag(Integer eventId);

    void addNote(Integer eventId, Integer newNoteId);

    void removeTag(Integer eventId, Integer tagId);

    void removeNote(Integer eventId);
    void addToCycle(Integer cycleId, Integer eventId);
    void removeFromCycle(Integer cycleId, Integer eventId);

    void addReminder(Integer reminderId, Integer eventId);

    void removeReminder(Integer eventId);

    void setEventStatus(Integer eventStatus, Integer eventId);

    void setStartDate(Date newStartDate, Integer eventId);

    void setEndDate(Date newEndDate, Integer eventId);
}
