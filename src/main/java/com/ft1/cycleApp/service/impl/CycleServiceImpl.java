package com.ft1.cycleApp.service.impl;

import com.ft1.cycleApp.entity.Cycle;
import com.ft1.cycleApp.mapper.CycleMapper;
import com.ft1.cycleApp.service.ICycleService;
import com.ft1.cycleApp.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

import com.ft1.cycleApp.entity.Event;
import com.ft1.cycleApp.mapper.EventMapper;

@Service
public class CycleServiceImpl implements ICycleService {
    @Autowired
    private CycleMapper cycleMapper;
    @Autowired
    private EventMapper eventMapper;

    void initialDate(Integer cycleId) {
        ArrayList<Integer> eventIds = cycleMapper.checkEvent(cycleId);

        cycleMapper.setStartDate(null,cycleId);

        cycleMapper.setStartDate(null,cycleId);

        if (eventIds != null) {
            for (Integer eId : eventIds) {
                Event e = eventMapper.getEvent(eId);

                if (e.getStartDate() != null) {
                    if (cycleMapper.getCycle(cycleId).getStartDate() == null) {
                        cycleMapper.setStartDate(e.getStartDate(), cycleId);
                    } else {
                        if (cycleMapper.getCycle(cycleId).getStartDate().compareTo(e.getStartDate()) > 0) {
                            cycleMapper.setStartDate(e.getStartDate(), cycleId);
                        }
                    }
                }

                if (e.getEndDate() != null) {
                    if (cycleMapper.getCycle(cycleId).getEndDate() == null) {
                        cycleMapper.setEndDate(e.getEndDate(), cycleId);
                    } else {
                        if (cycleMapper.getCycle(cycleId).getEndDate().compareTo(e.getEndDate()) < 0) {
                            cycleMapper.setEndDate(e.getEndDate(), cycleId);
                        }
                    }


                }

            }
        }
    }

    private void duplicateCycle(Cycle originCycle, Cycle targetCycle) {
        targetCycle.setCycleName(originCycle.getCycleName());

        targetCycle.setCycleId(originCycle.getCycleId());

        targetCycle.setStartDate(originCycle.getStartDate());

        targetCycle.setEndDate(originCycle.getEndDate());

        targetCycle.setUserId(originCycle.getUserId());

        if (originCycle.getEventId() != null) {
            targetCycle.setEventId(originCycle.getEventId());
        }

        if (originCycle.getProjectId() != null) {
            targetCycle.setProjectId(originCycle.getProjectId());
        }

        if (originCycle.getTagId() != null) {
            targetCycle.setTagId(originCycle.getTagId());
        }

        if (originCycle.getNoteId() != null) {
            targetCycle.setNoteId(originCycle.getNoteId());
        }

        if (originCycle.getReminderId() != null) {
            targetCycle.setReminderId(originCycle.getReminderId());
        }
    }

    @Override
    public Integer getNoteId(Integer cycleId) {
        Integer noteId = cycleMapper.getNoteId(cycleId);

        if (noteId == null) {
            throw new EntityNotFoundException("not found note");
        }

        return noteId;
    }
    
    @Override
    public void insertCycle(Cycle newCycle) {
        Integer rows = cycleMapper.insertCycle(newCycle);

        if (rows != 1) {
            throw new InsertException("error occur at insert cycle");
        }
    }

    @Override
    public void deleteCycle(Integer cycleId) {

        for (Integer eventId : cycleMapper.checkEvent(cycleId)) {
            if (eventId != null) {
                removeEvent(cycleId, eventId);
            }
        }


        for (Integer tagId : cycleMapper.checkTag(cycleId)) {
            if (tagId != null) {
                removeTag(cycleId, tagId);
            }
        }

        for (Integer projectId : cycleMapper.checkProject(cycleId)) {
            if (projectId != null) {
                deleteProject(cycleId, projectId);
            }
        }

        Integer rows = cycleMapper.deleteCycle(cycleId);

        if (rows != 1) {
            throw new DeleteException("error occurs for deleting cycle");
        }
    }

    @Override
    public Cycle getCycle(Integer cycleId) {

        Cycle cycle = new Cycle();

        Cycle result = cycleMapper.getCycle(cycleId);

        if (result != null) {
            duplicateCycle(result, cycle);
        } else {
            throw new EntityNotFoundException("not found cycle");
        }

        return cycle;
    }

    @Override
    public void setCycleName(String cycleName, Integer cycleId) {
        Integer rows = cycleMapper.setCycleName(cycleName, cycleId);

        if (rows != 1) {
            throw new SetNameException("err at set cycle name");
        }
    }

    @Override
    public void setStartDate(Date newStartDate, Integer cycleId) {
        Integer rows = cycleMapper.setStartDate(newStartDate, cycleId);

        if (rows != 1) {
            throw new SetEntityException("err at set start date for cycle");
        }
    }

    @Override
    public void setEndDate(Date newEndDate, Integer cycleId) {
        Integer rows = cycleMapper.setEndDate(newEndDate, cycleId);

        if (rows != 1) {
            throw new SetEntityException("err at set end date for cycle");
        }
    }

    @Override
    public void addTag(Integer cycleId, Integer tagId) {
        Integer rows = cycleMapper.addTag(cycleId, tagId);

        if (rows != 1) {
            throw new BindException("err at binding tag");
        }
    }

    @Override
    public void removeTag(Integer cycleId, Integer tagId) {
        Integer rows = cycleMapper.removeTag(cycleId, tagId);

        if (rows != 1) {
            throw new BindException("err at removing tag");
        }
    }

    @Override
    public void addNote(Integer newNoteId, Integer cycleId) {
        Integer rows = cycleMapper.addNote(newNoteId, cycleId);

        if (rows != 1) {
            throw new BindException("err at binding note");
        }
    }

    @Override
    public void removeNote(Integer cycleId) {
        Integer rows = cycleMapper.removeNote(cycleId);

        if (rows != 1) {
            throw new BindException("err at removing note");
        }
    }

    @Override
    public void addReminder(Integer newReminderId, Integer cycleId) {
        Integer rows = cycleMapper.addReminder(newReminderId, cycleId);

        if (rows != 1) {
            throw new BindException("err at adding reminder");
        }
    }

    @Override
    public void removeReminder(Integer cycleId) {
        Integer rows = cycleMapper.removeReminder(cycleId);

        if (rows != 1) {
            throw new BindException("err at removing reminder");
        }
    }

    @Override
    public void addEvent(Integer cycleId, Integer eventId) {
        Integer rows = cycleMapper.addEvent(cycleId, eventId);

        initialDate(cycleId);
        
        if (rows != 1) {
            throw new BindException("err at adding event");
        }
    }

    @Override
    public void removeEvent(Integer cycleId, Integer eventId) {
        Integer rows = cycleMapper.removeEvent(cycleId, eventId);

        initialDate(cycleId);
        
        if (rows != 1) {
            throw new BindException("err at removing event");
        }
    }

    @Override
    public void deleteProject(Integer cycleId, Integer projectId) {
        Integer rows = cycleMapper.deleteProject(cycleId, projectId);

        if (rows != 1) {
            throw new BindException("err at removing event");
        }
    }

    @Override
    public ArrayList<Cycle> getCyclesByUserId(Integer userId) {

        ArrayList<Cycle> cycles = new ArrayList<>();

        ArrayList<Cycle> result = cycleMapper.getCyclesByUserId(userId);

        for (Cycle c : result) {
            cycles.add(c);
        }

        return cycles;
    }

    @Override
    public ArrayList<Integer> getEventId(Integer cycleId) {

        ArrayList<Integer> eventIds = new ArrayList<>();

        ArrayList<Integer> result = cycleMapper.checkEvent(cycleId);

        for (Integer eventId : result) {
            eventIds.add(eventId);
        }

        return eventIds;
    }
}
