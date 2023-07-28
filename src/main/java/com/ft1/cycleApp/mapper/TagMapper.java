package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.Tag;

import java.util.ArrayList;

public interface TagMapper {

    Integer insertTag(Tag tag);

    Integer deleteTag(Integer tagId);

    ArrayList<Integer> findTagByUid(Integer uid);

    Integer updateTagName(String tagName, Integer tagId, Integer uid);

    Integer bindNoteToTag(Integer tagId, Integer noteId);

    Integer deleteNoteFromTag(Integer tagId, Integer noteId);

    Integer getNoteIdFromTag(Integer tagId);

    Tag findTagByTagId(Integer tagId);

}
