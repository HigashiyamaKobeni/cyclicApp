package com.ft1.cycleApp.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Tag implements Serializable {
    private Integer tagId;

    private String tagName;

    private Integer uid;

    private Integer noteId;

    private ArrayList<Integer> activityId;

    private ArrayList<Integer> taskId;

    public Tag() {
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public ArrayList<Integer> getActivityId() {
        return activityId;
    }

    public void setActivityId(ArrayList<Integer> activityId) {
        this.activityId = activityId;
    }

    public ArrayList<Integer> getTaskId() {
        return taskId;
    }

    public void setTaskId(ArrayList<Integer> taskId) {
        this.taskId = taskId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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
        if (!(o instanceof Tag)) return false;

        Tag tag = (Tag) o;

        if (getTagId() != null ? !getTagId().equals(tag.getTagId()) : tag.getTagId() != null) return false;
        if (getTagName() != null ? !getTagName().equals(tag.getTagName()) : tag.getTagName() != null) return false;
        if (getUid() != null ? !getUid().equals(tag.getUid()) : tag.getUid() != null) return false;
        if (getNoteId() != null ? !getNoteId().equals(tag.getNoteId()) : tag.getNoteId() != null) return false;
        if (getActivityId() != null ? !getActivityId().equals(tag.getActivityId()) : tag.getActivityId() != null)
            return false;
        return getTaskId() != null ? getTaskId().equals(tag.getTaskId()) : tag.getTaskId() == null;
    }

    @Override
    public int hashCode() {
        int result = getTagId() != null ? getTagId().hashCode() : 0;
        result = 31 * result + (getTagName() != null ? getTagName().hashCode() : 0);
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getNoteId() != null ? getNoteId().hashCode() : 0);
        result = 31 * result + (getActivityId() != null ? getActivityId().hashCode() : 0);
        result = 31 * result + (getTaskId() != null ? getTaskId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", userId=" + uid +
                ", noteId=" + noteId +
                ", activityId=" + activityId +
                ", taskId=" + taskId +
                '}';
    }
}
