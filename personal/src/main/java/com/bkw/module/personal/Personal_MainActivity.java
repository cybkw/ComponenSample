package com.bkw.module.personal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.bkw.arouterapi.ParameterManager;
import com.bkw.arouterapi.RouterManager;
import com.bkw.module.arouter_annotation.ARouter;
import com.bkw.module.arouter_annotation.Parameter;
import com.bkw.module.common.base.BaseActivity;
import com.bkw.module.common.user.bean.BaseUser;
import com.bkw.module.common.user.interfaces.IUser;
import com.bkw.module.common.utils.Cons;
import com.orhanobut.logger.Logger;

import butterknife.OnClick;

@ARouter(path = "/personal/Personal_MainActivity")
public class Personal_MainActivity extends BaseActivity {

    @Parameter(name = "/app/getUserInfo")
    IUser iUser;

    @Parameter
    String name;

    @Override
    protected void initView(Bundle savedInstanceState) {
        ParameterManager.getInstance().loadParameter(this);
        Logger.d("personal/Personal_MainActivity," + name);

        Logger.e("接收参数值：" + name);
        BaseUser userInfo = iUser.getUserInfo();
        if (userInfo != null) {
            Log.e(Cons.TAG, userInfo.getName() + " / "
                    + userInfo.getAccount() + " / "
                    + userInfo.getPassword());
        }


    }

    @Override
    protected int getLayoutId() {
        return R.layout.personal_activity_personal_main;
    }

    @OnClick({R2.id.bt_home, R2.id.bt_order})
    public void onClick(View view) {
        int i = view.getId();
        //方案二
        if (i == R.id.bt_home) {
            RouterManager.getInstance()
                    .build("/app/MainActivity")
                    .navigation(this);
        } else if (i == R.id.bt_order) {
            RouterManager.getInstance()
                    .build("/order/Order_MainActivity")
                    .withResultString("call", "call is contents")
                    .navigation(this, 166);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Logger.e("call=" + data.getStringExtra("call"));
        }
    }
}
