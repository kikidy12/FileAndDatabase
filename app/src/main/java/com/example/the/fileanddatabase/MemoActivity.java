package com.example.the.fileanddatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.the.fileanddatabase.util.TxtManager;

public class MemoActivity extends BaseActivity {

    TxtManager mTxtManager = new TxtManager(mContext);

    private android.widget.Button loadBtn;
    private android.widget.Button saveBtn;
    private android.widget.Button deleteBtn;
    private android.widget.EditText contentEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        BindViews();
        SetupEvents();
        SetValues();
    }

    @Override
    public void SetupEvents() {

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String memoContent = mTxtManager.loadMemo();

                contentEdt.setText(memoContent);

                Toast.makeText(mContext, "메모 로드 완료", Toast.LENGTH_SHORT).show();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTxtManager.saveMemo(contentEdt.getText().toString());

                Toast.makeText(mContext, "메모 세이브 완료", Toast.LENGTH_SHORT).show();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTxtManager.close();
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
        this.deleteBtn = (Button) findViewById(R.id.deleteBtn);
        this.saveBtn = (Button) findViewById(R.id.saveBtn);
        this.loadBtn = (Button) findViewById(R.id.loadBtn);
    }
}
