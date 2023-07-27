package com.ft1.cycleApp.service.impl;

import com.ft1.cycleApp.entity.Note;
import com.ft1.cycleApp.mapper.NoteMapper;
import com.ft1.cycleApp.service.INoteService;
import com.ft1.cycleApp.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements INoteService {

    @Autowired
    NoteMapper noteMapper;

    @Override
    public void updateNodeDetails(Integer noteId, String noteDetails) {
        Integer rows = noteMapper.updateNoteDetails(noteId, noteDetails);

        if (rows != 1) {
            throw new UpdateException("error at note updating");
        }
    }

    @Override
    public Integer insertNote(Note note) {
        Integer rows = noteMapper.insertNote(note);

        Integer noteId = note.getNoteId();

        if (rows != 1) {
            throw new InsertException("error at note inserting");
        }

        return noteId;
    }

    @Override
    public void deleteNote(Integer noteId) {
        Integer rows = noteMapper.deleteNote(noteId);

        if (rows != 1) {
            throw new DeleteException("error at delete note");
        }
    }

    @Override
    public Note getNote(Integer noteId) {

        Note result = noteMapper.getNote(noteId);

        if (result == null) {
            throw new NoteNotFoundException("note not found");
        }

        Note note = new Note();

        note.setNoteId(result.getNoteId());

        note.setNoteDetails(result.getNoteDetails());

        return note;
    }

    @Override
    public Integer getNoteIdByDetails(String noteDetails) {

        Integer noteId = noteMapper.getNoteIdByDetails(noteDetails);

        if (noteId == null) {
            throw new NoteNotFoundException("note note found");
        }

        return noteId;
    }
}
