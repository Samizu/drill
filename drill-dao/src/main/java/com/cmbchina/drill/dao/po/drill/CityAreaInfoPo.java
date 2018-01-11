package com.cmbchina.drill.dao.po.drill;

import java.io.Serializable;

public class CityAreaInfoPo implements Serializable {
    /**
     *区域划分
     */
    private String id;

    /**
     *
     */
    private String vocabulary;

    /**
     *城市名字
     */
    private String cityName;

    /**
     *城市ID
     */
    private String cityId;

    /**
     *
     */
    private String cityUrl;

    private static final long serialVersionUID = -292958675832858013L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary == null ? null : vocabulary.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getCityUrl() {
        return cityUrl;
    }

    public void setCityUrl(String cityUrl) {
        this.cityUrl = cityUrl == null ? null : cityUrl.trim();
    }
}