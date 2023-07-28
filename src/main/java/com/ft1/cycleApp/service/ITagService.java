package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.Tag;

import java.util.ArrayList;

public interface ITagService {

    Integer insertTag(Tag tag);

    void deleteTag(Integer tagId);

    ArrayList<Integer> findTagByUid(Integer uid);

    void updateTagName(String tagName, Integer tagId, Integer uid);

    void bindNoteToTag(Integer tagId, Integer noteId);

    void deleteNoteFromTag(Integer tagId, Integer noteId);

    Integer getNoteIdFromTag(Integer tagId);

    Tag findTagByTagId(Integer tagId);

    Tag duplicateTag(Tag tag, Tag result);
}
