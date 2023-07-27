package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.Note;

public interface INoteService {

    void updateNodeDetails(Integer noteId, String noteDetails);

    Integer insertNote(Note note);

    void  deleteNote(Integer noteId);

    Note getNote(Integer noteId);

    Integer getNoteIdByDetails(String noteDetails);
}
