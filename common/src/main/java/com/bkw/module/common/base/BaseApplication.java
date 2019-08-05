package com.bkw.module.common.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * 全局application
 *
 * @author bkw
 */
public class BaseApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                System.out.println("Logger工具初始化");
                return true;
            }
        });
    }

    public static Context getContext() {
        return context;
    }
}
