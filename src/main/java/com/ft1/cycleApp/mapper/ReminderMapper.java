package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.Reminder;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public interface ReminderMapper {

    Integer addReminder(String remindDetails, LocalDateTime remindTime);

    Reminder getReminder(Integer reminderId);

    Integer removeReminder(Integer reminderId);

    Integer modifyReminderDetails(Integer reminderId, String remindDetails);

    Integer setRemindTime(Integer reminderId, LocalDateTime remindTime);
}
