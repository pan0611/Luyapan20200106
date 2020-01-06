package com.bawei.luyapan20200106;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bawei.greendao.DaoSession;
import com.bawei.luyapan20200106.api.GreenDaoEntity;
import com.bawei.luyapan20200106.contract.HomeContract;
import com.bawei.luyapan20200106.entity.LeftEntity;
import com.bawei.luyapan20200106.presenter.HomePresenter;
import com.bawei.luyapan20200106.utils.RetrofitUtils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeContract.IView {

    private RecyclerView rv_left;
    private RecyclerView rv_right;
    private HomePresenter homePresenter;
    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homePresenter = new HomePresenter(this);
        rv_left = findViewById(R.id.rv_left);
        rv_right = findViewById(R.id.rv_right);
        rv_left.setLayoutManager(new LinearLayoutManager(this));
        rv_right.setLayoutManager(new GridLayoutManager(this,2));
        //Events
        EventBus.getDefault().unregister(this);

        if (RetrofitUtils.getRetrofitUtils().isNet()){
            homePresenter.getleftData();
        }else{
            List<GreenDaoEntity> greenDaoEntities = daoSession.getGreenDaoEntityDao().loadAll();
            if (greenDaoEntities!=null&&greenDaoEntities.size()>0){
                GreenDaoEntity greenDaoEntity = greenDaoEntities.get(0);
                String json = greenDaoEntity.getJson();
                LeftEntity leftEntity = new Gson().fromJson(json, LeftEntity.class);

            }
        }
    }

    @Override
    public void success(Object o) {

    }

    @Override
    public void error(Throwable throwable) {

    }
}
