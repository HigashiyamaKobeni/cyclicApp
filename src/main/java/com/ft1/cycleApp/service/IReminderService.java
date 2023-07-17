package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.Reminder;

import java.time.LocalDateTime;

public interface IReminderService {
    void addReminder(String remindDetails, LocalDateTime remindTime);

    Reminder getReminder(Integer reminderId);

    void removeReminder(Integer reminderId);

    void modifyReminderDetails(Integer reminderId, String remindDetails);

    void setRemindTime(Integer reminderId, LocalDateTime remindTime);
}
