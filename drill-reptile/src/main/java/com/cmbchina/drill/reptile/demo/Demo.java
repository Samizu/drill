//package com.cmbchina.drill.reptile.demo;
//
//import com.cmbchina.drill.common.utils.ConnectUtils;
//import java.io.IOException;
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
///**
// * Created by sanshui on 2018/1/3.
// */
//public class Demo {
//
//    public static void main(String[] args) throws IOException {
//        final String url = "http://www.dianping.com/shanghai/ch10";
//        ConnectUtils connectUtils = new ConnectUtils();
//        Document document = connectUtils.jsoupConnect(url);
//        System.out.println(document);
//        Connection conn = Jsoup.connect(url);
//        //conn.header("User-Agent", "Mozilla");
//        try {
//            Document doc = conn.get();
//            Element elementDiv = doc.getElementById("shop-all-list");
//            Elements elementsUl = elementDiv.getElementsByTag("ul");
//            Elements elements = elementsUl.first().getElementsByTag("li");
//            for (Element element : elements) {
//                Elements elements1 = element.children();
//                String targetUrl = elements1.get(0).getElementsByTag("a").attr("href");
//
//                String img = elements1.get(0).getElementsByTag("img").first().attr("data-src");
//                if (img.contains(".jpg")) {
//                    int a = img.indexOf(".jpg");
//                    img = img.substring(0, a + 4);
//                }
//
//                String radiumName = elements1.get(1).child(0).getElementsByTag("h4").text();
//                String address0 = elements1.get(1).child(2).getElementsByTag("a").get(1).text();
//
//                String address1 = elements1.get(1).child(2).getElementsByClass("addr").text();
//            }
//            System.out.println("");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
