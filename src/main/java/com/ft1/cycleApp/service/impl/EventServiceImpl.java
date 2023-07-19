package com.ft1.cycleApp.service.impl;

import com.ft1.cycleApp.entity.Event;
import com.ft1.cycleApp.mapper.EventMapper;
import com.ft1.cycleApp.service.IEventService;
import com.ft1.cycleApp.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class EventServiceImpl implements IEventService {

    @Autowired
    private EventMapper eventMapper;

    private void duplicateEvent(Event originEvent, Event targetEvent) {
        targetEvent.setEventId(originEvent.getEventId());
        targetEvent.setEventName(originEvent.getEventName());
        targetEvent.setActionable(originEvent.getActionable());

        if (originEvent.getEventStatus() != null) {
            targetEvent.setEventStatus(originEvent.getEventStatus());
        }

        if (originEvent.getStartDate() != null) {
            targetEvent.setStartDate(originEvent.getStartDate());
        }

        if (originEvent.getEndDate() != null) {
            targetEvent.setEndDate(originEvent.getEndDate());
        }

        if (originEvent.getNoteId() != null) {
            targetEvent.setNoteId(originEvent.getNoteId());
        }

        if (originEvent.getReminderId() != null) {
            targetEvent.setReminderId(originEvent.getReminderId());
        }
    }

    @Override
    public void insertEvent(Event newEvent, Integer cycleId) {
        Integer rows = eventMapper.insertEvent(newEvent, cycleId);

        if (rows != 1) {
            throw new InsertException("err at insert event");
        }
    }

    @Override
    public void deleteEvent(Integer eventId) {
        Integer rows = eventMapper.deleteEvent(eventId);

        if (rows != 1) {
            throw new DeleteException("err at delete event");
        }
    }

    @Override
    public Event getEvent(Integer eventId) {
        Event event = new Event();

        Event result = eventMapper.getEvent(eventId);

        if (result != null) {
            duplicateEvent(result, event);

            return event;
        }

        return null;
    }

    @Override
    public void updateEventName(String newEventName, Integer eventId) {
        Integer rows = 0;

        if (getEvent(eventId) != null) {
            rows = eventMapper.updateEventName(newEventName, eventId);
        } else {
            throw new EntityNotFoundException("not found related event");
        }

        if (rows != 1) {
            throw new UpdateException("err at update event name");
        }
    }

    @Override
    public void addTag(Integer eventId, Integer tagId) {
        Integer rows = eventMapper.addTag(eventId, tagId);

        if (rows != 1) {
            throw new BindException("err at bind tag");
        }
    }

    @Override
    public ArrayList<Integer> getTag(Integer eventId) {
        ArrayList<Integer> tagIds = new ArrayList<>();

        for (Integer result : eventMapper.getTag(eventId)) {
            tagIds.add(result);
        }

        return tagIds;
    }

    @Override
    public void addNote(Integer eventId, Integer newNoteId) {
        Integer rows = eventMapper.addNote(eventId, newNoteId);

        if (rows != 1) {
            throw new UpdateException("err at add note");
        }
    }

    @Override
    public void removeTag(Integer eventId, Integer tagId) {
        Integer rows = eventMapper.removeTag(eventId, tagId);

        if (rows != 1) {
            throw new BindException("err at remove tag");
        }
    }

    @Override
    public void removeNote(Integer eventId) {
        Integer rows = eventMapper.removeNote(eventId);

        if (rows != 1) {
            throw new UpdateException("err at remove note");
        }
    }

    @Override
    public void addToCycle(Integer cycleId, Integer eventId) {
        Integer rows = eventMapper.addToCycle(cycleId, eventId);

        if (rows != 1) {
            throw new BindException("err at bind to cycle");
        }
    }

    @Override
    public void removeFromCycle(Integer cycleId, Integer eventId) {
        Integer rows = eventMapper.removeFromCycle(cycleId, eventId);

        if (rows != 1) {
            throw new BindException("err at remove from cycle");
        }
    }

    @Override
    public void addReminder(Integer reminderId, Integer eventId) {
        Integer rows = eventMapper.addReminder(reminderId, eventId);

        if (rows != 1) {
            throw new UpdateException("err at add reminder");
        }
    }

    @Override
    public void removeReminder(Integer eventId) {
        Integer rows = eventMapper.removeReminder(eventId);

        if (rows != 1) {
            throw new UpdateException("err at remove reminder");
        }
    }

    @Override
    public void setEventStatus(Integer eventStatus, Integer eventId) {
        Integer rows = eventMapper.setEventStatus(eventStatus, eventId);

        if (rows != 1) {
            throw new UpdateException("err at update event status");
        }
    }

    @Override
    public void setStartDate(Date newStartDate, Integer eventId) {
        Integer rows = eventMapper.setStartDate(newStartDate, eventId);

        if (rows != 1) {
            throw new UpdateException("err at update start date");
        }
    }

    @Override
    public void setEndDate(Date newEndDate, Integer eventId) {
        Integer rows = eventMapper.setEndDate(newEndDate, eventId);

        if (rows != 1) {
            throw new UpdateException("err at update end date");
        }
    }
}
