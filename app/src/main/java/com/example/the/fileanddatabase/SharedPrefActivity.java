package com.example.the.fileanddatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.the.fileanddatabase.util.ContextUtil;

public class SharedPrefActivity extends BaseActivity {

    private android.widget.CheckBox pushCheckBox;
    private android.widget.Switch autoLoginSwitch;
    private android.widget.EditText nameEdt;
    private android.widget.Button okBtn;
    private android.widget.ToggleButton soundUseToggleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        BindViews();
        SetupEvents();
        SetValues();
    }

    @Override
    public void SetupEvents() {
        pushCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ContextUtil.setPush(mContext, isChecked);
            }
        });

        autoLoginSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ContextUtil.setAuto(mContext, isChecked);
            }
        });

        soundUseToggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ContextUtil.setSound(mContext, isChecked);
            }
        });
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContextUtil.setName(mContext, nameEdt.getText().toString());
                Toast.makeText(mContext, "입력 완료", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void SetValues() {
        pushCheckBox.setChecked(ContextUtil.getPush(mContext));
        autoLoginSwitch.setChecked(ContextUtil.getAuto(mContext));
        soundUseToggleBtn.setChecked(ContextUtil.getSound(mContext));
        nameEdt.setText(ContextUtil.getName(mContext));
    }

    @Override
    public void BindViews() {
        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.soundUseToggleBtn = (ToggleButton) findViewById(R.id.soundUseToggleBtn);
        this.autoLoginSwitch = (Switch) findViewById(R.id.autoLoginSwitch);
        this.pushCheckBox = (CheckBox) findViewById(R.id.pushCheckBox);
    }

}
