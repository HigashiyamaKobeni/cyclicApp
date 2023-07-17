package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.Note;

public interface NoteMapper {

    Integer insertNote(Note note);

    Integer updateNoteDetails(Integer noteId, String noteDetails);

    Integer deleteNote(Integer noteId);

    Note getNote(Integer noteId);

    Integer getNoteIdByDetails(String noteDetails);

}
