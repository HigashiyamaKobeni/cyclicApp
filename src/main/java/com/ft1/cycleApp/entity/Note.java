package com.ft1.cycleApp.entity;

import java.io.Serializable;

public class Note implements Serializable {
    private Integer noteId;
    private String noteDetails;

    public Note() {}

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getNoteDetails() {
        return noteDetails;
    }

    public void setNoteDetails(String noteDetails) {
        this.noteDetails = noteDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;

        Note note = (Note) o;

        if (getNoteId() != null ? !getNoteId().equals(note.getNoteId()) : note.getNoteId() != null) return false;
        return getNoteDetails() != null ? getNoteDetails().equals(note.getNoteDetails()) : note.getNoteDetails() == null;
    }

    @Override
    public int hashCode() {
        int result = getNoteId() != null ? getNoteId().hashCode() : 0;
        result = 31 * result + (getNoteDetails() != null ? getNoteDetails().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", noteDetails='" + noteDetails + '\'' +
                '}';
    }
}
