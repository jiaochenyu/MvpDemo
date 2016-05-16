package com.guanweiming.mvpdemo3;

import android.app.Application;
import org.xutils.*;

/**
 * Created by zziaguan on 2016/5/16.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
