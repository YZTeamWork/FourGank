package com.yibh.fourgank.utils;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.yibh.fourgank.FourApp;

/**
 * Created by yibh on 2016/8/17  19:34.
 */

public class ToastSnackUtil {
    public static void toastShort(String msg) {
        Toast.makeText(FourApp.mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public static void toastLong(String msg) {
        Toast.makeText(FourApp.mContext, msg, Toast.LENGTH_LONG).show();
    }

    public static void snackbarShort(View view, String content) {
        Snackbar.make(view, content, Snackbar.LENGTH_SHORT).show();
    }

    public static void snackbarLong(View view, String content) {
        Snackbar.make(view, content, Snackbar.LENGTH_LONG).show();
    }
}
