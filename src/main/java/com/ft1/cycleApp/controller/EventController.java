package com.ft1.cycleApp.controller;

import com.ft1.cycleApp.entity.Event;
import com.ft1.cycleApp.service.IEventService;
import com.ft1.cycleApp.service.ICycleService;
import com.ft1.cycleApp.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("events")
public class EventController extends BaseController{

    @Autowired
    private IEventService eventService;

    @Autowired
    private ICycleService cycleService;

    @RequestMapping("insert_event")
    public JsonResult<Void> insertEvent(String eventName, Integer actionable, HttpSession session) {

        Integer userId = getuidFromSession(session);
        
        if (eventName != null && actionable != null) {
            Event event = new Event();

            event.setEventName(eventName);

            event.setActionable(actionable);

            event.setUserId(userId);

            eventService.insertEvent(event);
        }

        return new JsonResult<>(OK);
    }

    @RequestMapping("get_note_id")
    public JsonResult<Integer> getNoteId(Integer eventId) {
        Integer noteId = eventService.getNoteId(eventId);

        return new JsonResult<>(OK, noteId);
    }


    @RequestMapping("delete_event")
    public JsonResult<Void> deleteEvent(Integer eventId) {

        eventService.deleteEvent(eventId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("get_event_by_uid")
    public JsonResult<ArrayList<Event>> getEventByUid(HttpSession session) {
        Integer userId = getuidFromSession(session);

        ArrayList<Event> result = eventService.getEventByUid(userId);

        return new JsonResult<>(OK, result);    
    }

    @RequestMapping("get_event")
    public JsonResult<Event> getEvent(Integer eventId) {

        Event event = eventService.getEvent(eventId);

        return new JsonResult<>(OK, event);
    }

    @RequestMapping("update_event_name")
    public JsonResult<Void> updateEventName(String newEventName, Integer eventId) {

        eventService.updateEventName(newEventName, eventId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("add_tag")
    public JsonResult<Void> addTag(Integer eventId, Integer tagId) {

        eventService.addTag(eventId, tagId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("get_tag")
    public JsonResult<ArrayList<Integer>> getTag(Integer eventId) {

        ArrayList<Integer> tagIds = new ArrayList<>();

        for (Integer tagId : eventService.getTag(eventId)) {
            tagIds.add(tagId);
        }

        return new JsonResult<>(OK, tagIds);
    }

    @RequestMapping("add_note")
    public JsonResult<Void> addNote(Integer eventId, Integer newNoteId) {

        eventService.addNote(eventId, newNoteId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("remove_tag")
    public JsonResult<Void> removeTag(Integer eventId, Integer tagId) {

        eventService.removeTag(eventId, tagId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("remove_note")
    public JsonResult<Void> removeNote(Integer eventId) {

        eventService.removeNote(eventId);

        return new JsonResult<>(OK);
    }
    @RequestMapping("add_to_cycle")
    public JsonResult<Void> addToCycle(Integer cycleId, Integer eventId) {

        eventService.addToCycle(cycleId, eventId);

        return new JsonResult<>(OK);
    }
    @RequestMapping("remove_from_cycle")
    public JsonResult<Void> removeFromCycle(Integer cycleId, Integer eventId) {

        eventService.removeFromCycle(cycleId, eventId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("add_reminder")
    public JsonResult<Void> addReminder(Integer reminderId, Integer eventId) {

        eventService.addReminder(reminderId, eventId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("remove_reminder")
    public JsonResult<Void> removeReminder(Integer eventId) {

        eventService.removeReminder(eventId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("set_event_status")
    public JsonResult<Void> setEventStatus(Integer eventStatus, Integer eventId) {

        eventService.setEventStatus(eventStatus, eventId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("set_start_date")
    public JsonResult<Void> setStartDate(String newStartDateString, Integer eventId) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date newStartDate = dateFormat.parse(newStartDateString);

        eventService.setStartDate(newStartDate, eventId);

        Integer cycleId = eventService.getCycleId(eventId);

        if (cycleId != null) {
            cycleService.initialDate(cycleId);
        }

        return new JsonResult<>(OK);
    }

    @RequestMapping("set_end_date")
    public JsonResult<Void> setEndDate(String newEndDateString, Integer eventId) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date newEndDate = dateFormat.parse(newEndDateString);

        eventService.setEndDate(newEndDate, eventId);

        Integer cycleId = eventService.getCycleId(eventId);
        
        if (cycleId != null) {
            cycleService.initialDate(cycleId);
        }

        return new JsonResult<>(OK);
    }
}
