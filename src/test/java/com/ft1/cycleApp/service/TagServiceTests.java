package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.Tag;
import com.ft1.cycleApp.service.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TagServiceTests {
    @Autowired
    private ITagService tagService;

    @Test
    public void insertTag() {


        try {
            Tag tag = new Tag();

            tag.setUid(4);

            tag.setTagName("servicetest");

            tagService.insertTag(tag);

            System.out.println("pass");
        } catch (ServiceException e) {
            // get class object then class name
            System.out.println(e.getClass().getSimpleName());
            // get specified information of exception
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findTagByTagId() {

        Tag tag = tagService.findTagByTagId(3);

        System.out.println(tag);
    }

    @Test
    public void deleteTag() {
        tagService.deleteTag(2);
    }

    @Test
    public void findTagByUid() {
        System.out.println(tagService.findTagByUid(2));

        // System.out.println(tagService.findTagByUid(3));

        System.out.println(tagService.findTagByUid(4));
    }

    @Test
    public void updateTagName() {
        // tagService.updateTagName("new tag name from service tests", 1, 2);

        tagService.updateTagName("new tag name from service tests", 3, 2);
    }

    @Test
    public void bindNoteToTag() {
        tagService.bindNoteToTag(3, 4);
    }

    @Test
    public void deleteNoteFromTag() {
        tagService.deleteNoteFromTag(5, 17);
    }

    @Test
    public void getNoteIdFromTag() {
        System.out.println(tagService.getNoteIdFromTag(3));

        System.out.println(tagService.getNoteIdFromTag(5));

        System.out.println(tagService.getNoteIdFromTag(7));

        // System.out.println(tagService.getNoteIdFromTag(9));
    }
}
