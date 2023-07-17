package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EventServiceTests {
    @Autowired
    private IEventService eventService;

    @Test
    public void insertEvent() {
        Event input = new Event();

        input.setEventName("newEventFromServiceLayer");

        input.setActionable(2);
        eventService.insertEvent(input);
    }

    @Test
    public void deleteEvent() {
        eventService.deleteEvent(2);
    }

    @Test
    public void getEvent() {
        System.out.println(eventService.getEvent(2));
    }

    @Test
    public void updateEventName() {
        eventService.updateEventName("updatingname", 2);
    }

    @Test
    public void addTag() {
        eventService.addTag(3, 7);
    }

    @Test
    public void getTag() {
        System.out.println(eventService.getTag(3));
    }

    @Test
    public void addNote() {
        eventService.addNote(3,3);
    }

    @Test
    public void removeTag() {
        eventService.removeTag(3, 4);
    }

    @Test
    public void removeNote() {
        eventService.removeNote(3);
    }
    @Test
    public void addToCycle() {
        eventService.addToCycle(4,3);
    }
    @Test
    public void removeFromCycle() {
        eventService.removeFromCycle(4,3);
    }

    @Test
    public void addReminder() {
        eventService.addReminder(4,3);
    }

    @Test
    public void removeReminder() {
        eventService.removeReminder(3);
    }

    @Test
    public void setEventStatus() {
        eventService.setEventStatus(1, 3);
    }

    @Test
    public void setStartDate() {
    }

    @Test
    public void setEndDate() {}
}
