package com.bkw.module.order;

import android.os.Bundle;
import android.view.View;

import com.bkw.arouterapi.ParameterManager;
import com.bkw.arouterapi.RouterManager;
import com.bkw.module.arouter_annotation.ARouter;
import com.bkw.module.arouter_annotation.Parameter;
import com.bkw.module.common.base.BaseActivity;
import com.orhanobut.logger.Logger;

import butterknife.OnClick;

/**
 * 正式环境：isRelease=true
 */
@ARouter(path = "/order/Order_MainActivity")
public class Order_MainActivity extends BaseActivity {

    @Parameter
    String name;

    @Override
    protected void initView(Bundle savedInstanceState) {

        Logger.d("order/Order_MainActivity");
        //懒加载的方式：接收参数值
        ParameterManager.getInstance().loadParameter(this);

        Logger.d("接收的参数值:" + name);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.order_activity_main;
    }

    @OnClick({R2.id.bt_home, R2.id.bt_personal})
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.bt_home) {
            RouterManager.getInstance()
                    .build("/app/MainActivity")
                    .withResultString("call","call me by")
                    .navigation(this,10);
        } else if (i == R.id.bt_personal) {
            RouterManager.getInstance()
                    .build("/personal/Personal_MainActivity")
                    .withString("name", "bkw")
                    .navigation(this);
        }
    }

}
