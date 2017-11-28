package com.lesson.vv_bobkov.a2l1_bobkov;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by samsung on 28.11.2017.
 */

class NoteWithTitleAdapter extends BaseAdapter {

    private Context mCxt;
    private LayoutInflater layoutInflater;

    @BindView(R.id.tvNotesTitle)
    TextView tvNotesTitle;

    NoteWithTitleAdapter(Context cxt) {

        if (App.noteWithTitleListIsEmpty()) {
            App.setNoteWithTitleList(new ArrayList<NoteWithTitle>());
        }
        mCxt = cxt;
        layoutInflater = (LayoutInflater)cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return App.getNoteWithTitleList().size();
    }

    @Override
    public Object getItem(int i) {
        return App.getNoteWithTitleList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_view_item, viewGroup, false);
        }

        ButterKnife.bind(view);
        tvNotesTitle.setText(App.getNoteWithTitleList().get(i).getTitle());
        tvNotesTitle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (App.selectedItemsIsEmpty()) {
                    App.createSelectedItems();
                } else {
                    App.getSelectedItems().clear();
                }
                App.addSelectedItem(Integer.valueOf(i), App.getNoteWithTitleList().get(i));
            }
        });

        return view;
    }

    public void addNewNoteToNoteWithTitleList() {
        App.NOTES_MODE = App.NOTES_MODE_EDIT;
        App.getSelectedItems().clear();
        Intent intent = new Intent(mCxt, NoteActivity.class);
        mCxt.startActivity(intent);
    }

    public void remNoteFromNoteWithTitleList(int position) {
        App.remNoteFromNoteWithTitleList(position);
    }

    public void openNoteFromNoteWithTitleList() {
        App.NOTES_MODE = App.NOTES_MODE_OPEN;
        Intent intent = new Intent(mCxt, NoteActivity.class);
        mCxt.startActivity(intent);
    }

    public void editNoteFromNoteWithTitleList() {
        App.NOTES_MODE = App.NOTES_MODE_EDIT;
        Intent intent = new Intent(mCxt, NoteActivity.class);
        mCxt.startActivity(intent);
    }
}
