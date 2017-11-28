package com.lesson.vv_bobkov.a2l1_bobkov;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.etNotesTitle)
    EditText etNotesTitle;
    @BindView(R.id.etNotesText)
    EditText etNotesText;
    @BindView(R.id.tvTitleOfNote)
    TextView tvTitleOfNote;
    @BindView(R.id.tvNotesText)
    TextView tvNotesText;
    @BindView(R.id.btnOk)
    Button btnOk;
    @BindView(R.id.btnCancel)
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        ButterKnife.bind(this);

        if (App.NOTES_MODE) {

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnOk:
                break;
            case R.id.btnCancel:
                break;
        }
    }
}
