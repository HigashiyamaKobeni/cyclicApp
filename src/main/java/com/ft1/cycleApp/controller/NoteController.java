package com.ft1.cycleApp.controller;

import com.ft1.cycleApp.entity.Note;
import com.ft1.cycleApp.service.INoteService;
import com.ft1.cycleApp.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller
@RequestMapping("notes")
public class NoteController extends BaseController {
    @Autowired
    private INoteService noteService;

    @RequestMapping("update_note_details")
    public JsonResult<Void> updateNodeDetails(Integer noteId, String noteDetails){
        noteService.updateNodeDetails(noteId, noteDetails);

        return new JsonResult<>(OK);
    }

    @RequestMapping("insert_note")
    public JsonResult<Void> insertNote(Note note) {
        noteService.insertNote(note);

        return new JsonResult<>(OK);
    }

    @RequestMapping("delete_note")
    public JsonResult<Void>  deleteNote(Integer noteId) {
        noteService.deleteNote(noteId);

        return new JsonResult<>(OK);
    }

    @RequestMapping("get_note")
    public JsonResult<Note> getNote(Integer noteId) {
        Note result = noteService.getNote(noteId);

        Note note = new Note();

        note.setNoteDetails(result.getNoteDetails());
        note.setNoteId(result.getNoteId());

        return new JsonResult<>(OK, note);
    }

    @RequestMapping("get_note_id_by_details")
    public JsonResult<Integer> getNoteIdByDetails(String noteDetails) {
        Integer noteId = noteService.getNoteIdByDetails(noteDetails);

        return new JsonResult<>(OK, noteId);
    }
}
