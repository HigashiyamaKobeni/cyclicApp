package com.ft1.cycleApp.service.impl;

import com.ft1.cycleApp.entity.Project;
import com.ft1.cycleApp.mapper.CycleMapper;
import com.ft1.cycleApp.mapper.ProjectMapper;
import com.ft1.cycleApp.service.IProjectService;
import com.ft1.cycleApp.service.exception.DeleteException;
import com.ft1.cycleApp.service.exception.InsertException;
import com.ft1.cycleApp.service.exception.ProjectNotFoundException;
import com.ft1.cycleApp.service.exception.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public void createProject(Project project) {

        Integer rows = projectMapper.insertProject(project);
        if (rows != 1) {
            throw new InsertException("Unknown exception occur during registration");
        }
    }

    @Override
    public ArrayList<Integer> getProjectByUid(Integer uid) {

        Integer projectNum = projectMapper.getProjectId(uid).size();

        if (projectNum == 0) {
            throw new ProjectNotFoundException("User does not have any project in database");
        }

        ArrayList<Integer> projectIds = new ArrayList<>();

        for (Integer projectId : projectMapper.getProjectId(uid)) {
            projectIds.add(projectId);
        }

        return projectIds;
    }

    @Override
    public void UpdateProjectName(Integer uid, Integer projectId, String projectName) {
        Integer rows = projectMapper.updateProjectName(uid, projectId, projectName);

        if (rows != 1) {
            throw new UpdateException("error at update");
        }
    }

    @Override
    public void deleteProject(Integer projectId) {
        Integer rows = projectMapper.deleteProject(projectId);

        if (rows != 1) {
            throw new DeleteException("error at delete project");
        }
    }

    @Override
    public ArrayList<Integer> getCycles(Integer projectId) {

        ArrayList<Integer> cycleIds = new ArrayList<>();

        for (Integer cycleId : projectMapper.getCycles(projectId)) {
            if (cycleId != null) {
                cycleIds.add(cycleId);
            }
        }

        return cycleIds;
    }

    @Override
    public void addCycle(Integer projectId, Integer cycleId) {

        Integer rows = projectMapper.addCycle(projectId, cycleId);

        if (rows != 1) {
            throw new InsertException("add cycle err");
        }
    }

    @Override
    public void removeCycle(Integer projectId, Integer cycleId) {

        Integer rows = projectMapper.removeCycle(projectId, cycleId);

        if (rows != 1) {
            throw new DeleteException("remove cycle err");
        }
    }

    @Override
    public ArrayList<Project> getProjectsByUserId(Integer uid) {

        ArrayList<Project> projects = new ArrayList<>();

        ArrayList<Project> result = projectMapper.getProjectsByUserId(uid);

        for (Project project: result) {
            projects.add(project);
        }

        return projects;
    }
}
