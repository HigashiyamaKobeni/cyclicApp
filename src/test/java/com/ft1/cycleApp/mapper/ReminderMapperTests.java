package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.Reminder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReminderMapperTests {
    @Autowired
    private ReminderMapper reminderMapper;

    @Test
    public void addReminder(){
        LocalDateTime dateTime = LocalDateTime.of(2029, 7, 10, 12, 30, 0);

        reminderMapper.addReminder("remind4", dateTime);
    }

    @Test
    public void getReminder(){
        System.out.println(reminderMapper.getReminder(1));
    }

    @Test
    public void removeReminder(){
        reminderMapper.removeReminder(1);
    }

    @Test
    public void modifyReminderDetails() {
        reminderMapper.modifyReminderDetails(2, "new");
    }

    @Test
    public void setRemindTime(){
        LocalDateTime dateTime = LocalDateTime.of(2023, 7, 10, 12, 30, 0);
        reminderMapper.setRemindTime(2, dateTime);
    }
}
