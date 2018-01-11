package com.cmbchina.drill.reptile.basics;

import com.cmbchina.drill.common.utils.ConnectUtils;
import com.cmbchina.drill.common.utils.UUIDUtils;
import com.cmbchina.drill.dao.po.drill.RegionInfoPo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 获取商区数据
 * Created by sanshui on 2018/1/3.
 */
public class CommercialDistrict {

    public static List<RegionInfoPo> serachCd(String url) throws IOException {
        ConnectUtils connectUtils = new ConnectUtils();
        Document doc = connectUtils.jsoupConnect(url);
        Element element = doc.getElementById("region-nav");
        Elements elements = element.getElementsByTag("a");
        List<RegionInfoPo> poList = new ArrayList<>();
        Pattern pattern = Pattern.compile("(http://www.dianping.com/)(\\w+)(/\\w+/)(\\w+)");
        for (int i = 0; i < elements.size(); i++) {
            RegionInfoPo po = new RegionInfoPo();
            String wholeUrl = elements.get(i).attr("href");
            po.setId(UUIDUtils.getUUID());
            po.setRegionId(pattern.matcher(wholeUrl).replaceAll("$4"));
            po.setCityId(pattern.matcher(wholeUrl).replaceAll("$2"));
            po.setRegionUrl(wholeUrl);
            po.setRegionName(elements.get(i).getElementsByTag("span").html());
            poList.add(po);
        }
        return poList;
    }

    public static void main(String[] args) throws IOException {
        String url = "http://www.dianping.com/shanghai/ch10";
        CommercialDistrict.serachCd(url);
    }

}
