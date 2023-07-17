package com.ft1.cycleApp.service;

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
public class NoteServiceTests {
    @Autowired
    private INoteService noteService;

    @Test
    public void updateNodeDetails(){
        noteService.updateNodeDetails(3, "this is new update from service layer to no3");
    };

    @Test
    public void insertNote(){
        Note note = new Note();

        note.setNoteDetails("test12");

        noteService.insertNote(note);
    };

    @Test
    public void  deleteNote(){
        noteService.deleteNote(5);
    };

    @Test
    public void getNote(){
        System.out.println(noteService.getNote(7));
    };
}
