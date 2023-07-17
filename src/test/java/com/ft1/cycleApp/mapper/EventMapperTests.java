package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EventMapperTests {
    @Autowired
    private EventMapper eventMapper;

    @Test
    public void insertEvent() {
        Event input = new Event();

        input.setActionable(1);

        input.setEventName("test002");

        input.setEventStatus(1);

        Date startDate = new Date(122, 6, 5);

        Date endDate = new Date(123, 6, 5);

        input.setStartDate(startDate);

        input.setEndDate(endDate);

        eventMapper.insertEvent(input);
    }

    @Test
    public void deleteEvent() {
        eventMapper.deleteEvent(1);
    }

    @Test
    public void getEvent() {
        System.out.println(eventMapper.getEvent(2));
    }

    @Test
    public void updateEventName() {
        eventMapper.updateEventName("newnameforyouglad", 2);
    }

    @Test
    public void addTag() {
        eventMapper.addTag(2,7);
    }

    @Test
    public void getTag() {
        System.out.println(eventMapper.getTag(3));
    }

    @Test
    public void addNote() {
        eventMapper.addNote(2,2);
    }

    @Test
    public void removeNote() {
        eventMapper.removeNote(2);
    }

    @Test
    public void removeTag() {
        eventMapper.removeTag(2, 4);
    }

    @Test
    public void addToCycle() {
        eventMapper.addToCycle(2, 4);
    }

    @Test
    public void removeFromCycle() {
        eventMapper.removeFromCycle(2,4);
    }

    @Test
    public void setEventStatus() {
        eventMapper.setEventStatus(0, 5);
    }

    @Test
    public void setStartDate() {
        Date startDate = new Date(150, 6, 5);

        eventMapper.setStartDate(startDate, 2);
    }

    @Test
    public void setEndDate() {
        Date endDate = new Date(170, 6, 5);

        eventMapper.setEndDate(endDate, 2);
    }

    @Test
    public void addReminder() {
        eventMapper.addReminder(2, 2);
    }

    @Test
    public void removeReminder() {
        eventMapper.removeReminder(2);
    }
}
