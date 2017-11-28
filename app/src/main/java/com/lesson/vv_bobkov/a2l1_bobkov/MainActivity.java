package com.lesson.vv_bobkov.a2l1_bobkov;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lvNotes)
    ListView lvNotes;

    private NoteWithTitleAdapter mNoteWithTitleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mNoteWithTitleAdapter = new NoteWithTitleAdapter(this);
        lvNotes.setAdapter(mNoteWithTitleAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        if (App.noteWithTitleListIsEmpty()) {
            menu.getItem(2).setVisible(false);
        } else {
            menu.getItem(2).setVisible(true);
        }

        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.actionAdd:
                mNoteWithTitleAdapter.addNewNoteToNoteWithTitleList();
                return true;

            case R.id.actionRem:

                if (!App.selectedItemsIsEmpty()) {

                    for (HashMap.Entry selectNote:
                         App.getSelectedItems().entrySet()) {

                        mNoteWithTitleAdapter.remNoteFromNoteWithTitleList((int)selectNote.getKey());
                    }
                }
                return true;

            case R.id.actionOpen:

                if (!App.selectedItemsIsEmpty()) {

                        mNoteWithTitleAdapter.openNoteFromNoteWithTitleList();
                }
                return true;

            case R.id.actionEdit:

                if (!App.selectedItemsIsEmpty()) {

                    mNoteWithTitleAdapter.editNoteFromNoteWithTitleList();
                }
                return true;
        }
        return false;
    }
}
