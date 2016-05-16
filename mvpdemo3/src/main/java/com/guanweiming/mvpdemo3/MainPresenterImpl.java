package com.guanweiming.mvpdemo3;

/**
 * Created by zziaguan on 2016/5/16.
 */
public class MainPresenterImpl implements MainPresenter,MainModel.OnFinishedListener {

    MainView mainView;
    MainModel mainModel;

    public MainPresenterImpl(MainView mainView){
        this.mainView=mainView;
        mainModel = new MainModelImpl(this);
    }
    @Override
    public void download() {
        mainModel.download();
    }

    @Override
    public void onSuccess() {
        mainView.showMessage("加载成功");
        String url = mainModel.getImageUrl();
        mainView.loadImage(url);
        String name = mainModel.getUserName();
        mainView.loadName(name);
    }

    @Override
    public void onFailed() {
        mainView.showMessage("加载失败");
    }
}
