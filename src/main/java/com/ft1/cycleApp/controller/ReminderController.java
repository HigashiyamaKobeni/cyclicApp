package com.ft1.cycleApp.controller;

import com.ft1.cycleApp.entity.Reminder;
import com.ft1.cycleApp.service.IReminderService;
import com.ft1.cycleApp.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("reminders")
public class ReminderController extends BaseController{

    @Autowired
    private IReminderService reminderService;

    @RequestMapping("add_reminder")
    public JsonResult<Void> addReminder(String remindDetails, String dateTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        LocalDateTime remindTime = LocalDateTime.parse(dateTime, formatter);

        reminderService.addReminder(remindDetails, remindTime);

        return new JsonResult<>(OK);
    }

    @RequestMapping("get_reminder")
    public JsonResult<Reminder> getReminder(Integer reminderId) {

        Reminder result = reminderService.getReminder(reminderId);

        return new JsonResult<>(OK, result);
    }

    @RequestMapping("remove_reminder")
    public JsonResult<Void> removeReminder(Integer reminderId) {

        reminderService.removeReminder(reminderId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("modify_reminder_details")
    public JsonResult<Void> modifyReminderDetails(Integer reminderId, String remindDetails) {

        reminderService.modifyReminderDetails(reminderId, remindDetails);

        return new JsonResult<>(OK);
    }

    @RequestMapping("set_remind_time")
    public JsonResult<Void> setRemindTime(Integer reminderId, String dateTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        LocalDateTime remindTime = LocalDateTime.parse(dateTime, formatter);

        reminderService.setRemindTime(reminderId, remindTime);

        return new JsonResult<>(OK);
    }
}
