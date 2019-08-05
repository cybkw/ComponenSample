package com.bkw.arouterapi;

import android.content.Context;
import android.os.Bundle;

import com.bkw.arouterapi.core.Call;

import org.jetbrains.annotations.Nullable;

/**
 * 参数传递管理
 */
public class BundleManager {

    private Bundle bundle = new Bundle();
    // 底层业务接口
    private Call call;
    // 是否回调setResult()
    private boolean isResult;

    Bundle getBundle() {
        return bundle;
    }

    Call getCall() {
        return call;
    }

    void setCall(Call call) {
        this.call = call;
    }

    boolean isResult() {
        return isResult;
    }

    // @NonNull不允许传null，@Nullable可以传null
    public BundleManager withString(String key, @Nullable String value) {
        bundle.putString(key, value);
        return this;
    }

    // 示例代码，需要拓展
    public BundleManager withResultString(String key, @Nullable String value) {
        bundle.putString(key, value);
        isResult = true;
        return this;
    }

    public BundleManager withBoolean(String key, boolean value) {
        bundle.putBoolean(key, value);
        return this;
    }

    public BundleManager withInt(String key, int value) {
        bundle.putInt(key, value);
        return this;
    }

    public BundleManager withBundle(Bundle bundle) {
        this.bundle = bundle;
        return this;
    }

    public Object navigation(Context context) {
//        return RouterManager.getInstance().navigation(context, this, -1);
        return navigation(context, -1);
    }

    /**
     * @param code 这里的code，可能是requestCode，也可能是resultCode。取决于isResult
     *             跳转方如果设置了withResultString()参数，就为requestCode
     */
    public Object navigation(Context context, int code) {
        return RouterManager.getInstance().navigation(context, this, code);
    }

}
