package com.cmbchina.drill.common.utils;

import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by sanshui on 2018/1/3.
 */
public class ConnectUtils {

    public Document jsoupConnect(String url) throws IOException {
        Connection conn = Jsoup.connect(url);
        return conn.get();
    }
}
