package com.ft1.cycleApp.controller;

import com.ft1.cycleApp.entity.Cycle;
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
@RequestMapping("cycles")
public class CycleController extends BaseController {
    @Autowired
    private ICycleService cycleService;

    @RequestMapping("check_tag")
    public JsonResult<ArrayList<integer>> checkTag(Integer cycleId) {
        ArrayList<Integer> result = cycleService.checkTag(cycleId);

        return result;
    }

    @RequestMapping("insert_cycle")
    public JsonResult<Void> insertCycle(Cycle newCycle, HttpSession session) {
        Integer uid = getuidFromSession(session);

        newCycle.setUserId(uid);

        cycleService.insertCycle(newCycle);

        return new JsonResult<>(OK);
    }

    @RequestMapping("get_note_id")
    public JsonResult<Integer> getNoteId(Integer cycleId) {
        Integer noteId = cycleService.getNoteId(cycleId);

        return new JsonResult<>(OK, noteId);
    }

    @RequestMapping("delete_cycle")
    public JsonResult<Void> deleteCycle(Integer cycleId) {
        cycleService.deleteCycle(cycleId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("get_cycle")
    public JsonResult<Cycle> getCycle(Integer cycleId) {
        Cycle result = cycleService.getCycle(cycleId);

        return new JsonResult<Cycle>(OK, result);
    }

    @RequestMapping("set_cycle_name")
    public JsonResult<Void> setCycleName(String cycleName, Integer cycleId) {
        cycleService.setCycleName(cycleName, cycleId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("set_start_date")
    public JsonResult<Void> setStartDate(String newStartDate, Integer cycleId) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(newStartDate);

        cycleService.setStartDate(startDate, cycleId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("set_end_date")
    public JsonResult<Void> setEndDate(String newEndDate, Integer cycleId) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = dateFormat.parse(newEndDate);

        cycleService.setStartDate(endDate, cycleId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("add_tag")
    public JsonResult<Void> addTag(Integer cycleId, Integer tagId) {
        cycleService.addTag(cycleId, tagId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("remove_tag")
    public JsonResult<Void> removeTag(Integer cycleId, Integer tagId) {
        cycleService.removeTag(cycleId, tagId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("add_note")
    public JsonResult<Void> addNote(Integer newNoteId, Integer cycleId) {
        cycleService.addNote(newNoteId, cycleId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("remove_note")
    public JsonResult<Void> removeNote(Integer cycleId) {
        cycleService.removeNote(cycleId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("add_reminder")
    public JsonResult<Void> addReminder(Integer newReminderId, Integer cycleId) {
        cycleService.addReminder(newReminderId, cycleId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("remove_reminder")
    public JsonResult<Void> removeReminder(Integer cycleId) {
        cycleService.removeReminder(cycleId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("add_event")
    public JsonResult<Void> addEvent(Integer cycleId, Integer eventId) {
        cycleService.addEvent(cycleId, eventId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("remove_event")
    public JsonResult<Void> removeEvent(Integer cycleId, Integer eventId) {
        cycleService.removeEvent(cycleId, eventId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("delete_project")
    public JsonResult<Void> deleteProject(Integer cycleId, Integer projectId) {
        cycleService.deleteProject(cycleId, projectId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("get_cycles_by_uid")
    public JsonResult<ArrayList<Cycle>> getCyclesByUserId(HttpSession session) {
        Integer uid = getuidFromSession(session);

        ArrayList<Cycle> result = cycleService.getCyclesByUserId(uid);

        return new JsonResult<>(OK, result);
    }

    @RequestMapping("get_event_ids")
    public JsonResult<ArrayList<Integer>> getEventIds(Integer cycleId) {

        ArrayList<Integer> result = cycleService.getEventId(cycleId);

        return new JsonResult<>(OK, result);
    }
}
