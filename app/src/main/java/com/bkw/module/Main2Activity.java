package com.bkw.module;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bkw.arouterapi.core.ARouterLoadGroup;
import com.bkw.arouterapi.core.ARouterLoadPath;
import com.bkw.module.apt.ARouter$$Group$$order;
import com.bkw.module.apt.ARouter$$Path$$order;
import com.bkw.module.arouter_annotation.ARouter;
import com.bkw.module.arouter_annotation.Parameter;
import com.bkw.module.arouter_annotation.model.RouterBean;
import com.bkw.module.common.base.BaseActivity;
import com.bkw.module.personal.Personal_MainActivity;
import com.orhanobut.logger.Logger;

import java.util.Map;

import butterknife.OnClick;


@ARouter(path = "/app/MainActivity")
public class Main2Activity extends BaseActivity {

    @Parameter
    String username;

    @Override
    protected void initView(Bundle savedInstanceState) {
        Logger.d("common/MainActivity");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.bt_order, R.id.bt_personal})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_order:
//                startAc(Order_MainActivity.class);
                //以下就是APT生成路由跳转的核心原理
                // 最终集成化模式，所有子模块app/order/personal通过APT生成的类文件都会打包到apk里面，不用担心找不到
                ARouterLoadGroup group = new ARouter$$Group$$order();
                Map<String, Class<? extends ARouterLoadPath>> map = group.loadGroup();
                // 通过order组名获取对应路由路径对象
                Class<? extends ARouterLoadPath> clazz = map.get("order");

                try {
                    // 类加载动态加载路由路径对象
                    ARouter$$Path$$order path = (ARouter$$Path$$order) clazz.newInstance();
                    Map<String, RouterBean> pathMap = path.loadPath();
                    // 获取目标对象封装
                    RouterBean bean = pathMap.get("/order/Order_MainActivity");

                    if (bean != null) {
                        Intent intent = new Intent(this, bean.getClazz());
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case R.id.bt_personal:
                startAc(Personal_MainActivity.class);
                break;
            default:
                break;
        }
    }


}
