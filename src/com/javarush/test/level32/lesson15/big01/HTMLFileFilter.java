package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by admin on 31.03.2016.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File f)
    {
        if(f.isDirectory())
            return true;
        else
        {
            String string = f.getName().toLowerCase();
            return (string.endsWith(".html") ||
                    string.endsWith(".htm"));
        }
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
