package com.bkw.module;

import android.os.Bundle;

import com.bkw.module.arouter_annotation.ARouter;
import com.bkw.module.common.base.BaseActivity;

@ARouter(path = "/app/LoginAc")
public class LoginAc extends BaseActivity {
    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
