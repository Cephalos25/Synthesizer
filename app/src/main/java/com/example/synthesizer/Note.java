package com.example.synthesizer;

public class Note {
    private int NoteId;
    private float rate;
    public static final int WHOLE_NOTE = 1000;

    public Note(int noteId) {
        NoteId = noteId;
        rate = 1.0f;
    }

    public Note(int noteId, float rate) {
        NoteId = noteId;
        this.rate = rate;
    }

    public int getNoteId() {
        return NoteId;
    }

    public void setNoteId(int noteId) {
        NoteId = noteId;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "NoteId=" + NoteId +
                ", rate=" + rate +
                '}';
    }
}
