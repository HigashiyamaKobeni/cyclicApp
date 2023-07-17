package com.ft1.cycleApp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Event implements Serializable {
    private Integer actionable; // actionable = 1 --> task / 2 --> activity
    private Integer eventId;
    private String eventName;
    private Date startDate;
    private Date endDate;
    private Integer eventStatus; // only task has status
    private ArrayList<Integer> circleId;
    private Integer noteId;
    private ArrayList<Integer> tagId;
    private Integer reminderId;
    public Event() {}

    public Integer getActionable() {
        return actionable;
    }

    public void setActionable(Integer actionable) {
        this.actionable = actionable;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
    }

    public ArrayList<Integer> getCircleId() {
        return circleId;
    }

    public void setCircleId(ArrayList<Integer> circleId) {
        this.circleId = circleId;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public ArrayList<Integer> getTagId() {
        return tagId;
    }

    public void setTagId(ArrayList<Integer> tagId) {
        this.tagId = tagId;
    }

    public Integer getReminderId() {
        return reminderId;
    }

    public void setReminderId(Integer reminderId) {
        this.reminderId = reminderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (getActionable() != null ? !getActionable().equals(event.getActionable()) : event.getActionable() != null)
            return false;
        if (getEventId() != null ? !getEventId().equals(event.getEventId()) : event.getEventId() != null) return false;
        if (getEventName() != null ? !getEventName().equals(event.getEventName()) : event.getEventName() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(event.getStartDate()) : event.getStartDate() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(event.getEndDate()) : event.getEndDate() != null) return false;
        if (getEventStatus() != null ? !getEventStatus().equals(event.getEventStatus()) : event.getEventStatus() != null)
            return false;
        if (getCircleId() != null ? !getCircleId().equals(event.getCircleId()) : event.getCircleId() != null)
            return false;
        if (getNoteId() != null ? !getNoteId().equals(event.getNoteId()) : event.getNoteId() != null) return false;
        if (getTagId() != null ? !getTagId().equals(event.getTagId()) : event.getTagId() != null) return false;
        return getReminderId() != null ? getReminderId().equals(event.getReminderId()) : event.getReminderId() == null;
    }

    @Override
    public int hashCode() {
        int result = getActionable() != null ? getActionable().hashCode() : 0;
        result = 31 * result + (getEventId() != null ? getEventId().hashCode() : 0);
        result = 31 * result + (getEventName() != null ? getEventName().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getEventStatus() != null ? getEventStatus().hashCode() : 0);
        result = 31 * result + (getCircleId() != null ? getCircleId().hashCode() : 0);
        result = 31 * result + (getNoteId() != null ? getNoteId().hashCode() : 0);
        result = 31 * result + (getTagId() != null ? getTagId().hashCode() : 0);
        result = 31 * result + (getReminderId() != null ? getReminderId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "actionable=" + actionable +
                ", eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", taskStatus=" + eventStatus +
                ", circleId=" + circleId +
                ", noteId=" + noteId +
                ", tagIds=" + tagId +
                ", reminderId=" + reminderId +
                '}';
    }
}
