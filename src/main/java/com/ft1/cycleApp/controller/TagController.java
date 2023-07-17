package com.ft1.cycleApp.controller;

import com.ft1.cycleApp.entity.Note;
import com.ft1.cycleApp.entity.Tag;
import com.ft1.cycleApp.service.INoteService;
import com.ft1.cycleApp.service.ITagService;
import com.ft1.cycleApp.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
@RequestMapping("tags")
public class TagController extends BaseController{
    @Autowired
    private ITagService tagService;
    @Autowired
    private INoteService noteService;

    @RequestMapping("insert_tag")
    public JsonResult<Void> insertTag(HttpSession session, Tag tag) {

        Integer uid = getuidFromSession(session);

        tag.setUid(uid);

        tagService.insertTag(tag);

        return new JsonResult<>(OK);
    }

    @RequestMapping("delete_tag")
    public JsonResult<Void> deleteTag(Integer tagId) {

        tagService.deleteTag(tagId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("find_tag_by_uid")
    public JsonResult<ArrayList<Tag>> findTagByUid(HttpSession session) {

        Integer uid = getuidFromSession(session);

        ArrayList<Tag> tags = new ArrayList<>();

        for (Tag result : tagService.findTagByUid(uid)) {
            tags.add(result);
        }

        return new JsonResult<>(OK, tags);
    }

    @RequestMapping("update_tag_name")
    public JsonResult<Void> updateTagName(String tagName, Integer tagId, HttpSession session) {

        Integer uid = getuidFromSession(session);

        tagService.updateTagName(tagName, tagId, uid);

        return new JsonResult<>(OK);
    }

    @RequestMapping("bind_note_to_tag")
    public JsonResult<Void> bindNoteToTag(Integer tagId, Integer noteId) {

        tagService.bindNoteToTag(tagId, noteId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("delete_note_from_tag")
    public JsonResult<Void> deleteNoteFromTag(Integer tagId, Integer noteId) {

        tagService.deleteNoteFromTag(tagId, noteId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("get_noteid_from_tag")
    public JsonResult<Integer> getNoteIdFromTag(Integer tagId) {

        Integer retVal = tagService.getNoteIdFromTag(tagId);

        return new JsonResult<>(OK, retVal);
    }

    @RequestMapping("find_tag_by_tagid")
    public JsonResult<Tag> findTagByTagId(Integer tagId) {

        Tag tag = tagService.findTagByTagId(tagId);

        return new JsonResult<>(OK, tag);
    }

    @RequestMapping("add_note_to_tag")
    public JsonResult<Void> addNoteToTag(Integer tagId, String noteDetails) {

        Note note = new Note();

        note.setNoteDetails(noteDetails);

        noteService.insertNote(note);

        tagService.bindNoteToTag(tagId, note.getNoteId());

        return new JsonResult<>(OK);
    }
}
