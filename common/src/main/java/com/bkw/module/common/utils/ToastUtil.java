package com.bkw.module.common.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class ToastUtil {

    private static Toast toast;

    public static void showToast(Context context, String msg) {
        if (TextUtils.isEmpty(msg)) {
            msg = "好像出了点小问题~";
        }
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
