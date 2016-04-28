package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10.02.2016.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data.html";


    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> list = new ArrayList<>();
        try
        {
            while (true)
            {
                int documentPage = 0;
                Document document;
                document = getDocument(searchString, documentPage++);
                if (document == null)
                    break;
            }
        }
        catch (Exception e)
        {
        }
        return list;

    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, searchString, page);//searchString город, 1 это страница

        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.109 Safari/537.36")
                .referrer("http://google.ru")
                .get();
        return document;

    }
}
