package com.bawei.luyapan20200106.presenter;

import com.bawei.luyapan20200106.contract.HomeContract;
import com.bawei.luyapan20200106.model.HomeModel;

import java.util.HashMap;

/**
 * author :Administrator
 * time :2020/01/06上午 10:13
 */
public class HomePresenter implements HomeContract.IPresenter {
    private HomeContract.IView iView;
    private HomeModel homeModel;

    public HomePresenter(HomeContract.IView iView) {
        this.iView = iView;
        this.homeModel = new HomeModel();
    }

    @Override
    public void getleftData() {
        homeModel.getleftData(new HomeContract.IModel.ModelCallback() {
            @Override
            public void success(Object o) {
                iView.success(o);
            }

            @Override
            public void error(Throwable throwable) {
                iView.error(throwable);
            }
        });
    }

    @Override
    public void getRightData(HashMap<String, String> params) {
        homeModel.getRightData(params, new HomeContract.IModel.ModelCallback() {
            @Override
            public void success(Object o) {
                iView.success(o);
            }

            @Override
            public void error(Throwable throwable) {
                iView.error(throwable);
            }
        });
    }
}
