package com.lesson.vv_bobkov.a2l1_bobkov;

import android.app.Application;
import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by samsung on 28.11.2017.
 */

public class App extends Application {

    static final boolean
            NOTES_MODE_OPEN = false,
            NOTES_MODE_EDIT = true;
    static boolean NOTES_MODE = false;

    private static ArrayList<NoteWithTitle> mNoteWithTitleList = null;
    private static HashMap<Integer, NoteWithTitle> mSelectedItems;
    private static App mApp;

    public App(){
        mApp = this;
    }

    public static App getApp() {
        return mApp;
    }

    public static void setNoteWithTitleList(ArrayList<NoteWithTitle> noteWithTitleList) {
        App.mNoteWithTitleList = noteWithTitleList;
    }

    public static List<NoteWithTitle> getNoteWithTitleList() {
        return mNoteWithTitleList;
    }

    public static boolean noteWithTitleListIsEmpty() {

        if (mNoteWithTitleList == null ||
                (mNoteWithTitleList.size() == 1 &&
                        mNoteWithTitleList.get(0).getTitle().equals(
                                mApp.getResources().getString(R.string.notes_no)
                        ))) return true;
        return false;
    }

    public static void addNewNoteToNoteWithTitleList(NoteWithTitle noteWithTitle) {
        mNoteWithTitleList.add(noteWithTitle);
    }

    public static void remNoteFromNoteWithTitleList(int position) {
        mNoteWithTitleList.remove(position);
    }

    public static void editNoteFromNoteWithTitleList(int position, NoteWithTitle noteWithTitle) {
        mNoteWithTitleList.get(position).editNote(noteWithTitle);
    }

    public static boolean selectedItemsIsEmpty() {
        return mSelectedItems == null;
    }

    public static HashMap<Integer, NoteWithTitle> getSelectedItems() {
        return mSelectedItems;
    }

    public static void createSelectedItems() {
        App.mSelectedItems = new HashMap<>();
    }

    public static NoteWithTitle getSelectedItem(Integer positoin) {
        return App.mSelectedItems.get(positoin);
    }

    public static void addSelectedItem(Integer positoin, NoteWithTitle noteWithTitle) {
        App.mSelectedItems.put(positoin, noteWithTitle);
    }
}
