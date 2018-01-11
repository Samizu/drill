package com.cmbchina.drill.producer.helper.convert;

import com.cmbchina.drill.common.dto.DivAreaDto;
import com.cmbchina.drill.common.utils.UUIDUtils;
import com.cmbchina.drill.dao.po.drill.CityAreaInfoPo;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.springframework.beans.BeanUtils;


public class CommonConvert {

    public static Function<List<DivAreaDto>, List<CityAreaInfoPo>> areaConvertCity = originalList -> {
        List<CityAreaInfoPo> afterList = new ArrayList<>();
        originalList.forEach(dto -> {
            CityAreaInfoPo po = new CityAreaInfoPo();
            BeanUtils.copyProperties(dto,po);
            po.setId(UUIDUtils.getUUID());
            afterList.add(po);
        });
        return afterList;
    };
}
