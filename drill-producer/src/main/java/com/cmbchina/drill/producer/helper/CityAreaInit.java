package com.cmbchina.drill.producer.helper;

import com.cmbchina.drill.common.dto.DivAreaDto;
import com.cmbchina.drill.dao.mapper.drill.gen.CityAreaInfoPoMapper;
import com.cmbchina.drill.dao.po.drill.CityAreaInfoPoExample;
import com.cmbchina.drill.producer.helper.convert.CommonConvert;
import com.cmbchina.drill.reptile.basics.CityReptile;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CityAreaInit {

    private static Logger logger = LoggerFactory.getLogger(CityAreaInit.class);

    private static String REDIS_KEY_CITY_AREA = "drillCityArea";

    @Resource
    private CityAreaInfoPoMapper cityAreaInfoPoMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 初始化城市地区列表
     */
    @PostConstruct
    public void init() throws IOException {
        String url = "http://www.dianping.com/citylistguonei?redir=aHR0cDovL3d3dy5kaWFucGluZy5jb20v";
        List<DivAreaDto> divAreaDtoList = CityReptile.searchCity(url);
        //持久化
        redisTemplate.delete(REDIS_KEY_CITY_AREA);
        redisTemplate.opsForValue().set(REDIS_KEY_CITY_AREA, divAreaDtoList);
        cityAreaInfoPoMapper.deleteByExample(new CityAreaInfoPoExample());
        cityAreaInfoPoMapper.insertBatch(CommonConvert.areaConvertCity.apply(divAreaDtoList));
        logger.info("地区数据持久化结束");

    }
}
