package com.worthto.common.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gezz on 2019/2/19.
 */
public class Person implements Serializable {

    private String id;
    private String name;
    private Map detailData;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Map getDetailData() {
        return detailData;
    }

    public void setDetailData(Map detailData) {
        this.detailData = detailData;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", detailData=" + detailData +
                '}';
    }
}