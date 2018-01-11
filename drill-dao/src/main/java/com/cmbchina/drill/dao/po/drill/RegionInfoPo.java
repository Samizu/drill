package com.cmbchina.drill.dao.po.drill;

import java.io.Serializable;

public class RegionInfoPo implements Serializable {
    /**
     *
     */
    private String id;

    /**
     *行政区
     */
    private String regionId;

    /**
     *行政区名
     */
    private String regionName;

    /**
     *城市ID
     */
    private String cityId;

    /**
     *url
     */
    private String regionUrl;

    private static final long serialVersionUID = 1557865085672080298L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getRegionUrl() {
        return regionUrl;
    }

    public void setRegionUrl(String regionUrl) {
        this.regionUrl = regionUrl == null ? null : regionUrl.trim();
    }
}