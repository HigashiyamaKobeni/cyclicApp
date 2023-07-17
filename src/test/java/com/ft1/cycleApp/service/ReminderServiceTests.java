package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.Reminder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReminderServiceTests {
    @Autowired
    private IReminderService reminderService;

    @Test
    public void addReminder () {
        LocalDateTime dateTime = LocalDateTime.of(2023, 9, 1, 12, 30, 0);

        reminderService.addReminder("newRRRRR", dateTime);
    }

    @Test
    public void getReminder() {
        System.out.println(reminderService.getReminder(4));
    }

    @Test
    public void removeReminder() {
        reminderService.removeReminder(2);
    }

    @Test
    public void modifyReminderDetails() {
        reminderService.modifyReminderDetails(5,"newnewnew");
    }

    @Test
    public void setRemindTime() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 10, 1, 12, 30, 0);

        reminderService.setRemindTime(5,dateTime);
    }
}
