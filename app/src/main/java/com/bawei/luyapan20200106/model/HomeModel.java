package com.bawei.luyapan20200106.model;

import com.bawei.luyapan20200106.api.HomeApiService;
import com.bawei.luyapan20200106.contract.HomeContract;
import com.bawei.luyapan20200106.entity.LeftEntity;
import com.bawei.luyapan20200106.entity.RightEntity;
import com.bawei.luyapan20200106.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author :Administrator
 * time :2020/01/06上午 9:54
 */
public class HomeModel implements HomeContract.IModel {

    @Override
    public void getleftData(final ModelCallback modelCallback) {
        RetrofitUtils.getRetrofitUtils().createView(HomeApiService.class)
                .getCls()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeftEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LeftEntity leftEntity) {
                        modelCallback.success(leftEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallback.error(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRightData(HashMap<String, String> params, final ModelCallback modelCallback) {
        RetrofitUtils.getRetrofitUtils().createView(HomeApiService.class)
                .getRight(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RightEntity rightEntity) {
                        modelCallback.success(rightEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallback.error(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
