package com.ft1.cycleApp.entity;

import java.io.Serializable;
import java.util.ArrayList;

// @Component
public class Project implements Serializable {
    private Integer projectId;
    private String projectName;
    private Integer uid;
    private ArrayList<Integer> CycleId;

    public Project() {}

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ArrayList<Integer> getCycleId() {
        return CycleId;
    }

    public void setCycleId(ArrayList<Integer> cycleId) {
        CycleId = cycleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (getProjectId() != null ? !getProjectId().equals(project.getProjectId()) : project.getProjectId() != null)
            return false;
        if (getProjectName() != null ? !getProjectName().equals(project.getProjectName()) : project.getProjectName() != null)
            return false;
        if (getUid() != null ? !getUid().equals(project.getUid()) : project.getUid() != null) return false;
        return getCycleId() != null ? getCycleId().equals(project.getCycleId()) : project.getCycleId() == null;
    }

    @Override
    public int hashCode() {
        int result = getProjectId() != null ? getProjectId().hashCode() : 0;
        result = 31 * result + (getProjectName() != null ? getProjectName().hashCode() : 0);
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getCycleId() != null ? getCycleId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", uid=" + uid +
                ", CircleId=" + CycleId +
                '}';
    }
}