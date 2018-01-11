package com.cmbchina.drill.producer.helper;

import com.cmbchina.drill.common.dto.CommercialDistrictDto;
import com.cmbchina.drill.common.utils.ConnectUtils;
import com.cmbchina.drill.dao.mapper.drill.gen.RegionInfoPoMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;


@Component
public class RegionInit {

    @Resource
    private RegionInfoPoMapper regionInfoPoMapper;

    /**
     * 初始化上海的所有商圈数据
     * @throws IOException
     */
    @PostConstruct
    public void init() throws IOException {
        String url = "http://www.dianping.com/shanghai/ch10";
        ConnectUtils connectUtils = new ConnectUtils();
        Document doc = connectUtils.jsoupConnect(url);
        Element element = doc.getElementById("region-nav");
        Elements elements = element.getElementsByTag("a");
        List<CommercialDistrictDto> dtoList = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            CommercialDistrictDto dto = new CommercialDistrictDto();
        }
    }
}
