package com.bawei.luyapan20200106.api;

import com.bawei.luyapan20200106.entity.LeftEntity;
import com.bawei.luyapan20200106.entity.RightEntity;


import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * author :Administrator
 * time :2020/01/06上午 10:04
 */
public interface HomeApiService {
    @GET("small/commodity/v1/findcategory")
    Observable<LeftEntity> getCls();
    @GET("small/commodity/v1/findCommodityBycategory")
    Observable<RightEntity> getRight(@QueryMap HashMap<String,String> params);
}
