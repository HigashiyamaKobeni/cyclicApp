package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.Project;

import java.util.ArrayList;

public interface IProjectService {
    /**
     * Project create method
     * @param project Project obejct
     * */
    void createProject(Project project);

    ArrayList<Integer> getProjectByUid(Integer uid);

    void UpdateProjectName(Integer uid,
                           Integer projectId,
                           String projectName);

    void deleteProject(Integer projectId);

    ArrayList<Integer> getCycles(Integer projectId);

    void addCycle(Integer projectId, Integer cycleId);

    void removeCycle(Integer projectId, Integer cycleId);

    ArrayList<Project> getProjectsByUserId(Integer uid);
}
