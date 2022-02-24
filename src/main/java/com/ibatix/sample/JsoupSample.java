package com.ibatix.sample;

import com.ibatix.util.NullUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class JsoupSample {
//    private final static String TARGET = "http://www.gov.cn/zhengce/content/2022-02/17/content_5674176.htm";
        private final static String TARGET = "http://sousuo.gov.cn/column/30469/0.htm";
    private final static String CHARSET = "UTF-8";

    public static void main(String[] args) throws Exception {
        Document document = Jsoup.parse(new URL(TARGET).openStream(), CHARSET, TARGET);   //利用Jsoup类的静态方法，将html转换成一个Document对象
        Elements elements = document.select("ul.listTxt a[href]"); //利用select选择器，取得需要的li元素集合
//        Elements elements = document.select("div.wrap table tbody tr td tbody tr"); //利用select选择器，取得需要的li元素集合

        for (Element ele : elements) {
            System.out.println(elements.get(0).text());
                System.out.println(ele.getElementsByTag("a").attr("href"));
            Elements htmlTag = ele.getElementsByTag("a");
            String targetLink = htmlTag.attr("href");
            String targetName = htmlTag.text();
            System.out.println(targetName + ":" + targetLink);
        }

//        Elements elements = document.select("div.wrap table tbody");
//        int size = elements.size();
//        System.out.println(size);
//        for (Element element : elements) {
//            System.out.println(element);
//        }
    }

    /**
     * 发送GET请求
     *
     * @param url 目标地址
     * @return HTML页面
     */
    public static String doGet(String url) {
        HttpGet get = new HttpGet(url);                //定义一个get请求
        CloseableHttpClient httpClient = getDefaultClient();

        CloseableHttpResponse response = null;//定义一个响应
        HttpEntity entity = null;
        String content = null;
        try {
            response = httpClient.execute(get);
            entity = response.getEntity();        //获取响应实体
            content = EntityUtils.toString(entity);    //将实体的内容转换为字符串

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (NullUtils.isNotNull(response)) response.close();
                if (NullUtils.isNotNull(httpClient)) httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    /**
     * 定义一个默认的请求客户端
     *
     * @return HTTP客户端
     */
    public static CloseableHttpClient getDefaultClient() {
        return HttpClients.createDefault();
    }
}
