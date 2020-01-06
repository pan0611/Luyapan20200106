package com.bawei.luyapan20200106.contract;

import java.util.HashMap;

/**
 * author :Administrator
 * time :2020/01/06上午 9:55
 */
public interface HomeContract  {

    interface IModel{
        void getleftData(ModelCallback modelCallback);
        void getRightData(HashMap<String,String> params,ModelCallback modelCallback);
        interface ModelCallback{
            void success(Object o);
            void error(Throwable throwable);
        }
    }
    interface IView{
        void success(Object o);
        void error(Throwable throwable);
    }
    interface IPresenter{
        void getleftData();
        void getRightData(HashMap<String,String> params);
    }
}
