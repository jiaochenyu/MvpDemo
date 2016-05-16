package com.guanweiming.mvpdemo3;

/**
 * Created by zziaguan on 2016/5/16.
 * 这里定义了activity需要做的事儿
 */
public interface MainView {
    void loadImage(String url);
    void loadName(String username);
    void showMessage(String message);
}
