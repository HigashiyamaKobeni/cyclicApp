package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.Cycle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CycleMapperTests {
    @Autowired
    private CycleMapper cycleMapper;

    @Test
    public void insertCycle() {
        Cycle input = new Cycle();

        input.setCycleName("cycle1");

        input.setUserId(2);

        Date startDate = new Date(122, 6, 5);

        Date endDate = new Date(123, 6, 5);

        input.setStartDate(startDate);

        input.setEndDate(endDate);

        cycleMapper.insertCycle(input);
    }

    @Test
    public void deleteCycle() {
        cycleMapper.deleteCycle(1);
    }

    @Test
    public void getCycle() {
        System.out.println(cycleMapper.getCycle(4));
    }

    @Test
    public void setCycleName() {
        cycleMapper.setCycleName("newCycle", 2);
    }

    @Test
    public void setStartDate() {
        Date startDate = new Date(150, 6, 5);

        cycleMapper.setStartDate(startDate, 2);
    }

    @Test
    public void setEndDate() {
        Date endDate = new Date(180, 6, 5);

        cycleMapper.setEndDate(endDate, 2);
    }

    @Test
    public void addTag() {
        cycleMapper.addTag(2, 4);
    }

    @Test
    public void removeTag() {
        cycleMapper.removeTag(2, 4);
    }

    @Test
    public void addNote() {
        cycleMapper.addNote(30, 2);
    }

    @Test
    public void removeNote() {
        cycleMapper.removeNote(2);
    }

    @Test
    public void addEvent() {
        cycleMapper.addEvent(2, 4);
    }

    @Test
    public void removeEvent() {
        cycleMapper.removeEvent(2, 2);
    }

    @Test
    public void addReminder() {
        cycleMapper.addReminder(2, 2);
    }

    @Test
    public void removeReminder() {
        cycleMapper.removeReminder(2);
    }

    @Test
    public void getCyclesByUserId() {
        System.out.println(cycleMapper.getCyclesByUserId(1));
    }
}
