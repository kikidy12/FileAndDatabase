package com.example.the.fileanddatabase;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by the on 2017-09-11.
 */

public abstract class BaseActivity extends AppCompatActivity{

    Context mContext = this;

    public abstract void SetupEvents();
    public abstract void SetValues();
    public abstract void BindViews();
}
