package com.ft1.cycleApp.controller;

import com.ft1.cycleApp.entity.Project;
import com.ft1.cycleApp.service.IProjectService;
import com.ft1.cycleApp.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController // @Controller
@RequestMapping("projects")
public class ProjectController extends BaseController {
    @Autowired
    private IProjectService projectService;

    @RequestMapping("get_cycles")
    public JsonResult<ArrayList<Integer>> getCycles(Integer projectId) {
        ArrayList<Integer> cycleIds = new ArrayList<>();

        for (Integer cycleId : projectService.getCycles(projectId)) {
            cycleIds.add(cycleId);
        }

        return new JsonResult<>(OK, cycleIds);
    }

    @RequestMapping("add_cycle")
    public JsonResult<Void> addCycle(Integer projectId, Integer cycleId) {
        projectService.addCycle(projectId, cycleId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("remove_cycle")
    public JsonResult<Void> removeCycle(Integer projectId, Integer cycleId) {
        projectService.removeCycle(projectId, cycleId);
        
        return new JsonResult<>(OK);
    }

    @RequestMapping("create_project")
    public JsonResult<Void> createProject(Project project, HttpSession session) {

        Integer uid = getuidFromSession(session);

        project.setUid(uid);

        projectService.createProject(project);
        return new JsonResult<>(OK);
    }

    @RequestMapping("get_projectids")
    public JsonResult<ArrayList<Integer>> getProjectByUid(HttpSession session) {
        Integer uid = getuidFromSession(session);

        return new JsonResult<>(OK, projectService.getProjectByUid(uid));
    }

    @RequestMapping("update_project_name")
    public JsonResult<Void> updateProjectName(HttpSession session, Integer projectId, String projectName) {
        Integer uid = getuidFromSession(session);

        projectService.UpdateProjectName(uid, projectId, projectName);

        return new JsonResult<>(OK);
    }

    @RequestMapping("delete_project")
    public JsonResult<Void> deleteProject(Integer projectId) {
        projectService.deleteProject(projectId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("get_projects_by_uid")
    public JsonResult<ArrayList<Project>> getProjectsByUserId(HttpSession session) {

        Integer uid = getuidFromSession(session);

        ArrayList<Project> result = projectService.getProjectsByUserId(uid);

        return new JsonResult<>(OK, result);
    }
}
