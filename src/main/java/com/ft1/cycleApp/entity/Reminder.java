package com.ft1.cycleApp.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reminder implements Serializable {

    private Integer reminderId;

    private String remindDetails;

    private LocalDateTime remindTime;

    public Integer getReminderId() {
        return reminderId;
    }

    public void setReminderId(Integer reminderId) {
        this.reminderId = reminderId;
    }

    public String getRemindDetails() {
        return remindDetails;
    }

    public void setRemindDetails(String remindDetails) {
        this.remindDetails = remindDetails;
    }

    public LocalDateTime getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(LocalDateTime remindTime) {
        this.remindTime = remindTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reminder)) return false;

        Reminder reminder = (Reminder) o;

        if (getReminderId() != null ? !getReminderId().equals(reminder.getReminderId()) : reminder.getReminderId() != null)
            return false;
        if (getRemindDetails() != null ? !getRemindDetails().equals(reminder.getRemindDetails()) : reminder.getRemindDetails() != null)
            return false;
        return getRemindTime() != null ? getRemindTime().equals(reminder.getRemindTime()) : reminder.getRemindTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getReminderId() != null ? getReminderId().hashCode() : 0;
        result = 31 * result + (getRemindDetails() != null ? getRemindDetails().hashCode() : 0);
        result = 31 * result + (getRemindTime() != null ? getRemindTime().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "reminderID=" + reminderId +
                ", reminderDetails='" + remindDetails + '\'' +
                ", remindTime=" + remindTime +
                '}';
    }
}
