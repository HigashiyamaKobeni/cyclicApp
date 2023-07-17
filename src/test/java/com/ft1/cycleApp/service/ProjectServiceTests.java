package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.Project;
import com.ft1.cycleApp.service.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @SpringBootTest: annotate current class is a test class, will be filtered when packaging
@SpringBootTest
// @RunWith: run the module test class (class can not run without @RunWith), pass a parameter, parameter must be SpringRunner class type
@RunWith(SpringRunner.class)
public class ProjectServiceTests {
    @Autowired
    private IProjectService projectService;

    @Test
    public void createProject() {
        try {
            Project result = new Project();
            result.setProjectName("serviceLayer");
            result.setUid(4);
            projectService.createProject(result);
            System.out.println("pass");
        } catch (ServiceException e) {
            // get class object then class name
            System.out.println(e.getClass().getSimpleName());
            // get specified information of exception
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getProjectByUid() {
        System.out.println(projectService.getProjectByUid(2));
    }

    @Test
    public void updateProjectName() {
        projectService.UpdateProjectName(4, 2, "test2p1new");
    }

    @Test
    public void deleteProject() {
        projectService.deleteProject(7);
    }
}
