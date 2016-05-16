package com.guanweiming.mvpdemo3;

/**
 * Created by zziaguan on 2016/5/16.
 * 这里具体做事儿，但是不管为什么这么做
 */
public interface MainModel {
    interface OnFinishedListener{
        void onSuccess();
        void onFailed();
    }
    void download();
    String getImageUrl();
    String getUserName();
}
