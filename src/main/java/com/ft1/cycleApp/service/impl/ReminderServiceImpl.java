package com.ft1.cycleApp.service.impl;

import com.ft1.cycleApp.entity.Reminder;
import com.ft1.cycleApp.mapper.ReminderMapper;
import com.ft1.cycleApp.service.IReminderService;
import com.ft1.cycleApp.service.exception.DeleteException;
import com.ft1.cycleApp.service.exception.InsertException;
import com.ft1.cycleApp.service.exception.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReminderServiceImpl implements IReminderService {
    @Autowired
    private ReminderMapper reminderMapper;

    @Override
    public void addReminder(String remindDetails, LocalDateTime remindTime) {
        Integer rows = reminderMapper.addReminder(remindDetails, remindTime);

        if (rows != 1) {
            throw new InsertException("add reminder failed");
        }
    }

    @Override
    public Reminder getReminder(Integer reminderId) {
        Reminder reminder = new Reminder();

        Reminder result = reminderMapper.getReminder(reminderId);

        if (result != null) {
            reminder.setRemindDetails(result.getRemindDetails());

            reminder.setRemindTime(result.getRemindTime());

            reminder.setReminderId(result.getReminderId());

            return reminder;
        }

        return null;
    }

    @Override
    public void removeReminder(Integer reminderId) {
        Integer rows = reminderMapper.removeReminder(reminderId);

        if (rows != 1) {
            throw new DeleteException("err at remove reminder");
        }
    }

    @Override
    public void modifyReminderDetails(Integer reminderId, String remindDetails) {
        Integer rows = reminderMapper.modifyReminderDetails(reminderId, remindDetails);

        if (rows != 1) {
            throw new UpdateException("err at modify details");
        }
    }

    @Override
    public void setRemindTime(Integer reminderId, LocalDateTime remindTime) {
        Integer rows = reminderMapper.setRemindTime(reminderId, remindTime);

        if (rows != 1) {
            throw new UpdateException("err at modify remind time");
        }
    }
}
