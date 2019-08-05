package com.bkw.module.personal.debug;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bkw.module.personal.R;
import com.orhanobut.logger.Logger;

public class Personal_DebugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("common/Personal_DebugActivity");
        setContentView(R.layout.personal_activity_debug);
    }
}
