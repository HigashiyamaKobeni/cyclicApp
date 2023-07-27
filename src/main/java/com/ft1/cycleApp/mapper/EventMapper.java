package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.Event;

import java.util.ArrayList;
import java.util.Date;

public interface EventMapper {
    Integer insertEvent(Event event);

    Integer deleteEvent(Integer eventId);

    Event getEvent(Integer eventId);

    ArrayList<Event> getEventByUid(Integer userId);

    Integer updateEventName(String newEventName, Integer eventId);

    Integer getNoteId(Integer eventId);

    Integer addTag(Integer eventId, Integer tagId);

    ArrayList<Integer> getTag(Integer eventId);
    Integer addNote(Integer eventId, Integer newNoteId);
    Integer removeTag(Integer eventId, Integer tagId);
    Integer removeNote(Integer eventId);
    Integer addToCycle(Integer cycleId, Integer eventId);
    Integer removeFromCycle(Integer cycleId, Integer eventId);

    Integer addReminder(Integer reminderId, Integer eventId);

    Integer removeReminder(Integer eventId);

    Integer setEventStatus(Integer eventStatus, Integer eventId);

    Integer setStartDate(Date newStartDate, Integer eventId);

    Integer setEndDate(Date newEndDate, Integer eventId);
}
