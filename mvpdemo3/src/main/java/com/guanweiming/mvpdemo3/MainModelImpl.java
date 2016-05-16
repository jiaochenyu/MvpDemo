package com.guanweiming.mvpdemo3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by zziaguan on 2016/5/16.
 */
public class MainModelImpl implements MainModel {

    OnFinishedListener listener;
    String username;
    String url;

    public MainModelImpl(OnFinishedListener listener){
        this.listener=listener;
    }

    @Override
    public void download() {
        RequestParams params = new RequestParams("http://fuwuqi.guanweiming.top/json/testdata2");
        params.addBodyParameter("begin","1");
        params.addBodyParameter("end","1");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject object = new JSONObject(result);
                    JSONArray users=object.getJSONArray("users");
                    JSONObject user=users.getJSONObject(0);
                    username=user.getString("userName");
                    url = user.getString("imageUrl");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                listener.onFailed();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                listener.onFailed();
            }

            @Override
            public void onFinished() {
                //通知presenter数据加载完毕
                listener.onSuccess();
            }
        });
    }

    @Override
    public String getImageUrl() {
        return url;
    }

    @Override
    public String getUserName() {
        return username;
    }
}
