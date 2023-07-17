package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @SpringBootTest: annotate current class is a test class, will be filtered when packaging
@SpringBootTest
// @RunWith: run the module test class (class can not run without @RunWith), pass a parameter, parameter must be SpringRunner class type
@RunWith(SpringRunner.class)
public class ProjectMapperTests {
    @Autowired
    private ProjectMapper projectMapper;

    @Test
    public void insertProject() {
        Project project = new Project();

        project.setUid(2);

        project.setProjectName("testp2");

        projectMapper.insertProject(project);
    }

    @Test
    public void getProject() {
        System.out.println(projectMapper.getProjectId(3));
    }

    @Test
    public void updateProjectName() {
        projectMapper.updateProjectName(1, 2, "test1p2new");
    }

    @Test
    public void deleteProject() {
        projectMapper.deleteProject(7);
    }

    @Test
    public void addCycle() {
        projectMapper.addCycle(4, 3);
    }

    @Test
    public void removeCycle() {
        projectMapper.removeCycle(4, 2);
    }

    @Test
    public void getCycle() {
        System.out.println(projectMapper.getCycles(4));
    }
}
