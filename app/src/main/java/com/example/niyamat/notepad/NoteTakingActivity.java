package com.example.niyamat.notepad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class NoteTakingActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String FILE_NAME = "fileName";
    private EditText mNoteEditTitle;
    private EditText mNoteEditBody;
    private String mNoteTitle;
    private String mNoteBody;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_taking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mNoteEditTitle = (EditText) findViewById(R.id.noteTitle);
        mNoteEditBody = (EditText) findViewById(R.id.noteBody);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNoteTitle = mNoteEditTitle.getText() + "";
                mNoteBody = mNoteEditBody.getText() + "";
                if (mNoteTitle.equals("") || mNoteBody.equals("")) {
                    Toast.makeText(NoteTakingActivity.this, R.string.empty_edit_text, Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra(Constants.KEY_TITLE, mNoteTitle);
                    intent.putExtra(Constants.KEY_BODY, mNoteBody);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }



}
