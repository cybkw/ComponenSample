package com.bkw.module.order;

import android.os.Bundle;

import com.bkw.arouterapi.ParameterManager;
import com.bkw.module.arouter_annotation.ARouter;
import com.bkw.module.arouter_annotation.Parameter;
import com.bkw.module.common.base.BaseActivity;
import com.orhanobut.logger.Logger;

@ARouter(path = "/order/Order_DetailActivity")
public class Order_DetailActivity extends BaseActivity {

    @Parameter
    String name;

    @Override
    protected void initView(Bundle savedInstanceState) {
        //懒加载的方式：接收参数值
        ParameterManager.getInstance().loadParameter(this);
        Logger.e( name);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.order_activity_detail;
    }
}
