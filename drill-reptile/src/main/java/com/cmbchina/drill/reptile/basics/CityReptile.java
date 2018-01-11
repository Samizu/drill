package com.cmbchina.drill.reptile.basics;

import com.cmbchina.drill.common.dto.DivAreaDto;
import com.cmbchina.drill.common.utils.ConnectUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取城市数据
 * Created by sanshui on 2018/1/3.
 */
public class CityReptile {

    private static Logger logger = LoggerFactory.getLogger(CityReptile.class);

    public static List<DivAreaDto> searchCity(String url) throws IOException {
        ConnectUtils connectUtils = new ConnectUtils();
        Document doc = connectUtils.jsoupConnect(url);
        Element elementCityList = doc.getElementById("divArea");
        Elements elementsLi = elementCityList.getElementsByTag("li");
        List<DivAreaDto> divAreaDtoList = new ArrayList<>();
        if(elementsLi.size()>0){
            for (int i = 0; i < elementsLi.size(); i++) {
                String vocabulary = elementsLi.get(i).getElementsByClass("vocabulary").html();
                Elements elementsTerms = elementsLi.get(i).getElementsByTag("a");
                if(elementsTerms.size()>0){
                    for (int j = 0; j < elementsTerms.size(); j++) {
                        DivAreaDto dto = new DivAreaDto();
                        dto.setVocabulary(vocabulary);
                        if(elementsTerms.get(j).children().size()>0){
                            dto.setCityName(elementsTerms.get(j).getElementsByTag("strong").html());
                        }else{
                            dto.setCityName(elementsTerms.get(j).html());
                        }
                        if(!StringUtils.equals(dto.getCityName(),"更多")){
                            divAreaDtoList.add(dto);
                            dto.setCityUrl(elementsTerms.get(j).attr("href").substring(2));
                            dto.setCityId(dto.getCityUrl().substring(17));
                        }

                    }
                }
            }
        }
        logger.info("初始化城市列表结束，本次共操作城市地区数据[{}]条",divAreaDtoList.size());
        return divAreaDtoList;
    }

    public static void main(String[] args) throws IOException {
//        String url = "http://www.dianping.com/citylistguonei?redir=aHR0cDovL3d3dy5kaWFucGluZy5jb20v";
//        CityReptile.searchCity(url);

        String url = "http://www.dianping.com/Hengchun";
        System.out.println(url.substring(24));
    }

}
