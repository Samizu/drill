package com.cmbchina.drill.common.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by sanshui on 2018/1/10.
 */
@Data
public class DivAreaDto implements Serializable{

    private String vocabulary;

    private String cityName;

    private String cityId;

    private String cityUrl;
}
