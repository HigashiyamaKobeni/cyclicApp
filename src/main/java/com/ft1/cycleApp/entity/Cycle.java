package com.ft1.cycleApp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Cycle implements Serializable {
    private Integer cycleId;
    private String cycleName;
    private Date startDate;
    private Date endDate;
    private Integer userId;
    private ArrayList<Integer> projectId;
    private ArrayList<Integer> eventId;
    private ArrayList<Integer> tagId;
    private Integer reminderId;
    private Integer noteId;

    public Cycle() {}

    public Integer getCycleId() {
        return cycleId;
    }

    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ArrayList<Integer> getProjectId() {
        return projectId;
    }

    public void setProjectId(ArrayList<Integer> projectId) {
        this.projectId = projectId;
    }

    public ArrayList<Integer> getEventId() {
        return eventId;
    }

    public void setEventId(ArrayList<Integer> eventId) {
        this.eventId = eventId;
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

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cycle)) return false;

        Cycle cycle = (Cycle) o;

        if (getCycleId() != null ? !getCycleId().equals(cycle.getCycleId()) : cycle.getCycleId() != null) return false;
        if (getCycleName() != null ? !getCycleName().equals(cycle.getCycleName()) : cycle.getCycleName() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(cycle.getStartDate()) : cycle.getStartDate() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(cycle.getEndDate()) : cycle.getEndDate() != null) return false;
        if (getUserId() != null ? !getUserId().equals(cycle.getUserId()) : cycle.getUserId() != null) return false;
        if (getProjectId() != null ? !getProjectId().equals(cycle.getProjectId()) : cycle.getProjectId() != null)
            return false;
        if (getEventId() != null ? !getEventId().equals(cycle.getEventId()) : cycle.getEventId() != null) return false;
        if (getTagId() != null ? !getTagId().equals(cycle.getTagId()) : cycle.getTagId() != null) return false;
        if (getReminderId() != null ? !getReminderId().equals(cycle.getReminderId()) : cycle.getReminderId() != null)
            return false;
        return getNoteId() != null ? getNoteId().equals(cycle.getNoteId()) : cycle.getNoteId() == null;
    }

    @Override
    public int hashCode() {
        int result = getCycleId() != null ? getCycleId().hashCode() : 0;
        result = 31 * result + (getCycleName() != null ? getCycleName().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + (getProjectId() != null ? getProjectId().hashCode() : 0);
        result = 31 * result + (getEventId() != null ? getEventId().hashCode() : 0);
        result = 31 * result + (getTagId() != null ? getTagId().hashCode() : 0);
        result = 31 * result + (getReminderId() != null ? getReminderId().hashCode() : 0);
        result = 31 * result + (getNoteId() != null ? getNoteId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "cycleId=" + cycleId +
                ", cycleName='" + cycleName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", userId=" + userId +
                ", projectId=" + projectId +
                ", eventId=" + eventId +
                ", tagId=" + tagId +
                ", reminderId=" + reminderId +
                ", noteId=" + noteId +
                '}';
    }
}
