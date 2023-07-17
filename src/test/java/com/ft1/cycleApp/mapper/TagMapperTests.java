package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TagMapperTests {
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private NoteMapper noteMapper;

    @Test
    public void insertTag() {
        Tag tag = new Tag();
        tag.setTagName("mappertest2");
        tag.setUid(2);
        Integer rows = tagMapper.insertTag(tag);

        System.out.println(rows);
    }

    @Test
    public void deleteTag() {
        Integer rows = tagMapper.deleteTag(1);
        System.out.println(rows);
    }

    @Test
    public void findTagByUid() {
        ArrayList<Tag> result = tagMapper.findTagByUid(2);

        ArrayList<Tag> tags = new ArrayList<>();

        for (Tag tag : result) {
            tags.add(tag);
        }

        System.out.println(tags);
    }

    @Test
    public void updateTagName() {
        Integer rows=tagMapper.updateTagName("updatename", 2, 2);
        System.out.println(rows);
    }

    @Test
    public void bindNoteToTag() {
        Integer rows=tagMapper.bindNoteToTag(2, 2);
        System.out.println(rows);
    }

    @Test
    public void deleteNoteFromTag() {
        Integer rows = tagMapper.deleteNoteFromTag(2,4);
        System.out.println(rows);
    }

    @Test
    public void getNoteIdFromTag() {
        Integer noteId = tagMapper.getNoteIdFromTag(2);
        System.out.println(noteId);
    }

    @Test
    public void findTagByTagId() {
        Tag tag = tagMapper.findTagByTagId(1);
        System.out.println(tag);
    }

}
