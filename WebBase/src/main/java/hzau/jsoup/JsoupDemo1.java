package hzau.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: su
 * @date: 2020/2/15
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "UTF-8");
        Elements elements = document.getElementsByTag("xing");
        System.out.println(elements);
        System.out.println("-------------------");
        Elements el = document.getElementsByAttribute("id");
        System.out.println(el);
        Element e = document.getElementById("itcast");
        System.out.println("------");
        System.out.println(e);
    }
}
