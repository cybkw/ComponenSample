package com.bkw.module;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bkw.arouterapi.ParameterManager;
import com.bkw.arouterapi.RouterManager;
import com.bkw.module.arouter_annotation.ARouter;
import com.bkw.module.arouter_annotation.Parameter;
import com.bkw.module.common.base.BaseActivity;
import com.bkw.module.common.order.drawable.OrderDrawable;
import com.bkw.module.common.order.interfaces.OrderAddress;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends BaseActivity {

    @BindView(R.id.imageView)
    ImageView imageView;

    @Parameter
    String name;

    @Parameter
    int age;

    @Parameter(name = "/order/getDrawable")
    OrderDrawable drawable;

    @Parameter(name = "/order/getOrderBean")
    OrderAddress orderAddress;

    @Override
    protected void initView(Bundle savedInstanceState) {
        Logger.d("common/MainActivity");

        ParameterManager.getInstance().loadParameter(this);

        imageView.setImageResource(drawable.getDrawable());


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.bt_order, R.id.bt_personal})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_order:
                //以下就是APT生成路由跳转的核心原理
                // 最终集成化模式，所有子模块app/order/personal通过APT生成的类文件都会打包到apk里面，不用担心找不到
//                ARouterLoadGroup group = new ARouter$$Group$$order();
//                Map<String, Class<? extends ARouterLoadPath>> map = group.loadGroup();
//                // 通过order组名获取对应路由路径对象
//                Class<? extends ARouterLoadPath> clazz = map.get("order");
//
//                try {
//                    // 类加载动态加载路由路径对象
//                    ARouter$$Path$$order path = (ARouter$$Path$$order) clazz.newInstance();
//                    Map<String, RouterBean> pathMap = path.loadPath();
//                    // 获取目标对象封装
//                    RouterBean bean = pathMap.get("/order/Order_MainActivity");

//                        Intent intent = new Intent(this, Order_MainActivity.class);
//                        intent.putExtra("name", "bkw");
//                        startActivity(intent);
//                RouterManager.getInstance().build("/order/Order_MainActivity")
//                        .withStringResult("call", "is callback")
//                        .navigation(this, 100);

                RouterManager.getInstance().build("/order/Order_MainActivity")
                        .withString("name", "bkw")
                        .navigation(this, 10);
                break;
            case R.id.bt_personal:
                Bundle bundle = new Bundle();
                bundle.putString("name", "simon");
                bundle.putInt("age", 35);
                bundle.putBoolean("isSuccess", true);
                bundle.putString("netease", "net163");


                RouterManager.getInstance().build("/personal/Personal_MainActivity")
                        .withBundle(bundle)
                        .navigation(this);
                break;
            default:
                break;
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
