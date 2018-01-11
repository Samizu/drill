package com.cmbchina.drill.common.utils;

import java.util.UUID;

/**
 * Created by sanshui on 2018/1/9.
 */
public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
