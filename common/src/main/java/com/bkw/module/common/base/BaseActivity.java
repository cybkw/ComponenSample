package com.bkw.module.common.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.bkw.module.common.R;
import com.bkw.module.common.utils.DisplayUtils;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * 基类Activity
 *
 * @author bkw
 */
public abstract class BaseActivity extends SupportActivity {

    /**
     * 全局上下文对象
     */
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("common BaseActivity");
        init(savedInstanceState);


    }

    protected void init(Bundle savedInstanceState) {
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mContext = BaseApplication.getContext();
        DisplayUtils.setCustomDensity(this, getApplication());

        initView(savedInstanceState);
    }


    /**
     * 初始化View
     */
    protected abstract void initView(Bundle savedInstanceState);

    protected abstract int getLayoutId();

    @Override
    public boolean isActivityTransitionRunning() {
        return true;
    }

    /**
     * 提示窗口
     */
    public void showHint(Context context, String msg) {
        new AlertDialog.Builder(context)
                .setMessage(msg)
                .setNegativeButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    private void fadeAnimation() {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void slideAnimation() {
    }

    private void zoomAnimation() {
        overridePendingTransition(R.anim.activity_finish_zoom_in, R.anim.activity_finish_zoom_out);
    }

    protected void startAc(Class<?> clz) {
        startActivity(new Intent(this, clz));
        zoomAnimation();
    }

    protected void startAc(Intent intent) {
        startActivity(intent);
        zoomAnimation();
    }


    /**
     * [页面跳转]
     *
     * @param clz    要跳转的Activity
     * @param intent intent
     */
    public void startAc(Class<?> clz, Intent intent) {
        intent.setClass(this, clz);
        startActivity(intent);
        zoomAnimation();
    }

    /**
     * [携带数据的页面跳转]
     *
     * @param clz    要跳转的Activity
     * @param bundle bundel数据
     */
    public void startAc(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        zoomAnimation();
    }
}
