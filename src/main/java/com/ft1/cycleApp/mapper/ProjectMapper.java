package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.Project;

import java.util.ArrayList;

public interface ProjectMapper {

    ArrayList<Integer> getCycles(Integer projectId);

    Integer addCycle(Integer projectId, Integer cycleId);

    Integer removeCycle(Integer projectId, Integer cycleId);

    /**
     * insert project
     * @param project project insert
     * @return rows affected
     * */
    Integer insertProject(Project project);

    /**
     * return project id
     * @param uid user id
     * @return project id list
     * */
    ArrayList<Integer> getProjectId(Integer uid);

    Integer updateProjectName(Integer uid,
                           Integer projectId,
                           String projectName);

    Integer deleteProject(Integer projectId);

    ArrayList<Project> getProjectsByUserId(Integer uid);
}
