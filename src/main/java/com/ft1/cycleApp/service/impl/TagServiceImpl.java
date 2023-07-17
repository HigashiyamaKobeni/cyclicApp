package com.ft1.cycleApp.service.impl;

import com.ft1.cycleApp.entity.Tag;
import com.ft1.cycleApp.mapper.NoteMapper;
import com.ft1.cycleApp.mapper.TagMapper;
import com.ft1.cycleApp.service.ITagService;
import com.ft1.cycleApp.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TagServiceImpl implements ITagService {
    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private NoteMapper noteMapper;


    @Override
    public Tag duplicateTag(Tag tag, Tag result) {

        result.setTagName(tag.getTagName());

        result.setUid(tag.getUid());

        if (tag.getNoteId() != null) {
            result.setNoteId(tag.getNoteId());
        }

        if (tag.getActivityId() != null) {
            result.setActivityId(tag.getActivityId());
        }

        if (tag.getTaskId() != null) {
            result.setTaskId(tag.getTaskId());
        }

        return result;
    }

    @Override
    public void insertTag(Tag tag) {
        Tag result = new Tag();

        duplicateTag(tag, result);

        Integer rows = tagMapper.insertTag(result);

        if (rows != 1) {
            throw new InsertException("errors occur at insert");
        }
    }

    @Override
    public void deleteTag(Integer tagId) {
        Integer rows = 0;

        if (findTagByTagId(tagId) != null) {
            rows = tagMapper.deleteTag(tagId);
        }

        if (rows != 1) {
            throw new DeleteException("tag not exist");
        }
    }

    @Override
    public ArrayList<Tag> findTagByUid(Integer uid) {

        ArrayList<Tag> tags = new ArrayList<>();

        for (Tag result : tagMapper.findTagByUid(uid)) {
            Tag tag = new Tag();

            duplicateTag(result, tag);

            tags.add(tag);
        }

        if (tags.size() == 0) {
            throw new TagNotFoundException("user has no tags");
        }

        return tags;

    }

    @Override
    public void updateTagName(String tagName, Integer tagId, Integer uid) {
        Integer rows = tagMapper.updateTagName(tagName, tagId, uid);

        if (rows != 1) {
            throw new UpdateException("err occurs at updating tag name");
        }
    }

    @Override
    public void bindNoteToTag(Integer tagId, Integer noteId) {

        Integer rows = tagMapper.bindNoteToTag(tagId, noteId);

        if (rows != 1) {
            throw new InsertException("err at insert");
        }
    }

    @Override
    public void deleteNoteFromTag(Integer tagId, Integer noteId) {

        Integer rows = tagMapper.deleteNoteFromTag(tagId, noteId);

        if (rows != 1) {
            throw new DeleteException("err at delete");
        }
    }

    @Override
    public Integer getNoteIdFromTag(Integer tagId) {
        Integer noteId = tagMapper.getNoteIdFromTag(tagId);

        if (noteId == null) {
            throw new NoteNotFoundException("note found note");
        }

        return noteId;
    }

    @Override
    public Tag findTagByTagId(Integer tagId) {

        Tag result = tagMapper.findTagByTagId(tagId);

        Tag tag = new Tag();

        if (result != null) {
            duplicateTag(result, tag);

            return tag;
        } else {
            return null;
        }
    }
}
