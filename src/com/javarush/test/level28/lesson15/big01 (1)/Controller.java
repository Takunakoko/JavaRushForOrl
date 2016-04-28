package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by admin on 10.02.2016.
 */
public class Controller
{
    private Provider[] providers;

    public Controller(Provider... providers)
    {
        this.providers = providers;
        if (providers.length == 0)
            throw new IllegalArgumentException();
    }

    @Override
    public String toString()
    {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan()
    {
        ArrayList<Vacancy> list = new ArrayList<>();
        try
        {
            for (Provider provider : providers)
            {
                for (Vacancy vacancy : provider.getJavaVacancies("java"))
                {
                    list.add(vacancy);
                }
            }
        }catch (NullPointerException e) {}

        System.out.println(list.size());
    }
}
