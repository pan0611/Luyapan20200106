package com.bawei.luyapan20200106.api;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author :Administrator
 * time :2020/01/06上午 10:16
 */
@Entity
public class GreenDaoEntity {
    @Id(autoincrement = true)
    private Long id;
    private String json;
    private String key;
    @Generated(hash = 190248859)
    public GreenDaoEntity(Long id, String json, String key) {
        this.id = id;
        this.json = json;
        this.key = key;
    }
    @Generated(hash = 1963997359)
    public GreenDaoEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }
    public String getKey() {
        return this.key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
