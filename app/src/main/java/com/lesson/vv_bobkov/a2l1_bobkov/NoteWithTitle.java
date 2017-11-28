package com.lesson.vv_bobkov.a2l1_bobkov;

/**
 * Created by samsung on 28.11.2017.
 */

class NoteWithTitle {

    private String mTitle, mText;

    NoteWithTitle() {
        mTitle = "";
        mText = "";
    }


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public void editNote(NoteWithTitle noteWithTitle) {
        mTitle = noteWithTitle.getTitle();
        mText = noteWithTitle.getText();
    }
}
