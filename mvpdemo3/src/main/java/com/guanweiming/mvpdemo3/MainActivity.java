package com.guanweiming.mvpdemo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements MainView {

    ImageView icon;
    TextView username;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        icon = (ImageView) findViewById(R.id.imageview);
        username = (TextView) findViewById(R.id.username);
        presenter = new MainPresenterImpl(MainActivity.this);
    }

    @Override
    public void loadImage(String url) {
        Glide.with(MainActivity.this)
                .load(url)
                .into(icon);
    }

    @Override
    public void loadName(String name) {
        username.setText(name);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    public void download(View view) {
        presenter.download();
    }
}
