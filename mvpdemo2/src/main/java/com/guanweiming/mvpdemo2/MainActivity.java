package com.guanweiming.mvpdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {

    ImageView icon;
    TextView username;
    Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        icon = (ImageView) findViewById(R.id.imageview);
        username = (TextView) findViewById(R.id.username);
    }

    public void download(View view) {
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
                    username.setText(user.getString("userName"));
                    Glide.with(MainActivity.this)
                            .load(user.getString("imageUrl"))
                            .into(icon);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                show("onError");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                show("onCancelled");
            }

            @Override
            public void onFinished() {
                show("onFinished");
            }
        });
    }
    public void show(String text){
        if(mToast!=null){
            mToast.setText(text);
        }else{
            mToast=Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
