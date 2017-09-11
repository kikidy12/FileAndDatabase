package com.example.the.fileanddatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.the.fileanddatabase.util.ObjectManager2;

import java.util.HashMap;

public class ObjectMamoActivity extends BaseActivity {

    ObjectManager2 mObjectManager2 = new ObjectManager2(mContext);

    private android.widget.Button loadBtn;
    private android.widget.Button saveBtn;
    private android.widget.Button deleteBtn;
    private android.widget.EditText titleEdt;
    private android.widget.EditText contentEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_mamo);
        BindViews();
        SetupEvents();
        SetValues();
    }

    @Override
    public void SetupEvents() {
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> inputData = new HashMap<String, String>();
                inputData.put("title", titleEdt.getText().toString());
                inputData.put("content", contentEdt.getText().toString());

                titleEdt.setText("");
                contentEdt.setText("");

                mObjectManager2.save(inputData);
                Toast.makeText(mContext, "메모 세이브 완료", Toast.LENGTH_SHORT).show();
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleEdt.setText(mObjectManager2.load().get("title"));
                contentEdt.setText(mObjectManager2.load().get("content"));

                Toast.makeText(mContext, "메모 로드 완료", Toast.LENGTH_SHORT).show();
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mObjectManager2.delete();

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
        this.contentEdt = (EditText) findViewById(R.id.contentEdt);
        this.titleEdt = (EditText) findViewById(R.id.titleEdt);
        this.deleteBtn = (Button) findViewById(R.id.deleteBtn);
        this.saveBtn = (Button) findViewById(R.id.saveBtn);
        this.loadBtn = (Button) findViewById(R.id.loadBtn);
    }
}
