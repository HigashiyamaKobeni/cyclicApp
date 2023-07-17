package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @SpringBootTest: annotate current class is a test class, will be filtered when packaging
@SpringBootTest
// @RunWith: run the module test class (class can not run without @RunWith), pass a parameter, parameter must be SpringRunner class type
@RunWith(SpringRunner.class)
public class NoteMapperTests {
    @Autowired
    NoteMapper noteMapper;

    @Test
    public void insertNote(){
        Note note = new Note();

        note.setNoteDetails("test11");

        noteMapper.insertNote(note);

        System.out.println(note.getNoteId());
    };

    @Test
    public void updateNoteDetails(){
        noteMapper.updateNoteDetails(1, "testNote001new");

    };

    @Test
    public void deleteNote(){
        noteMapper.deleteNote(8);
    };

    @Test
    public void getNote(){
        System.out.println(noteMapper.getNote(6));
    };



}
