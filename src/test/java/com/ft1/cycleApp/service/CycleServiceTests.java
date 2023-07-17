package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.Cycle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CycleServiceTests {
    @Autowired
    private ICycleService cycleService;

    @Test
    public void insertCycle() {
        Cycle input = new Cycle();


        cycleService.insertCycle(input);
    }

    @Test
    public void deleteCycle() {
        cycleService.deleteCycle(2);
    }

    @Test
    public void getCycle() {
        System.out.println(cycleService.getCycle(2));
    }

    @Test
    public void setCycleName() {
        cycleService.setCycleName("ccc", 3);
    }

    @Test
    public void setStartDate() {
        Date newDate = new Date(152, 6, 5);

        cycleService.setStartDate(newDate, 3);
    }

    @Test
    public void setEndDate() {
        Date newDate = new Date(192, 6, 5);

        cycleService.setEndDate(newDate, 3);
    }

    @Test
    public void addTag() {
        cycleService.addTag(3, 4);
    }

    @Test
    public void removeTag() {
        cycleService.removeTag(3, 4);
    }

    @Test
    public void addNote() {
        cycleService.addNote(2, 3);
    }

    @Test
    public void removeNote() {
        cycleService.removeNote(3);
    }

    @Test
    public void addReminder() {
    }

    @Test
    public void removeReminder() {}

    @Test
    public void addEvent() {
        cycleService.addEvent(3, 3);
    }

    @Test
    public void removeEvent() {
        cycleService.removeEvent(3,3);
    }
}
