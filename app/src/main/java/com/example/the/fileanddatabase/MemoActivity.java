package com.example.the.fileanddatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.the.fileanddatabase.util.ObjectFileManager;

import java.util.HashMap;

public class MemoActivity extends BaseActivity {

    ObjectFileManager ofm = new ObjectFileManager(mContext);

    private android.widget.Button loadBtn;
    private android.widget.Button saveBtn;
    private android.widget.Button deleteBtn;
    private android.widget.EditText contentEdt;
    private EditText titleEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BindViews();
        SetupEvents();
        SetValues();
    }

    @Override
    public void SetupEvents() {

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titleEdt.setText(ofm.load().get("title"));
                contentEdt.setText(ofm.load().get("content"));

                Toast.makeText(mContext, "메모 로드 완료", Toast.LENGTH_SHORT).show();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> memoData = new HashMap<String, String>();

                memoData.put("title", titleEdt.getText().toString());
                memoData.put("content", contentEdt.getText().toString());
                titleEdt.setText("");
                contentEdt.setText("");
                ofm.svae(memoData);

                Toast.makeText(mContext, "메모 세이브 완료", Toast.LENGTH_SHORT).show();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ofm.delete();
                titleEdt.setText("");
                contentEdt.setText("");

                Toast.makeText(mContext, "메모 삭제 완료", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void SetValues() {

    }

    @Override
    public void BindViews() {
        setContentView(R.layout.activity_memo);
        this.contentEdt = (EditText) findViewById(R.id.contentEdt);
        this.titleEdt = (EditText) findViewById(R.id.titleEdt);
        this.deleteBtn = (Button) findViewById(R.id.deleteBtn);
        this.saveBtn = (Button) findViewById(R.id.saveBtn);
        this.loadBtn = (Button) findViewById(R.id.loadBtn);
    }
}
