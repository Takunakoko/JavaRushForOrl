package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by admin on 06.04.2016.
 */
public class FileBucket
{
    private Path path;

    public FileBucket()
    {
        try
        {
            this.path = Files.createTempFile(null, null);
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize()
    {
        return path.toFile().length();
    }

    public void putEntry(Entry entry)
    {
        try (FileOutputStream fos = new FileOutputStream(path.toString());
             ObjectOutputStream out = new ObjectOutputStream(fos))
        {
            out.writeObject(entry);
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry()
    {
        Entry entry = null;
        if (getFileSize() > 0)
            try (FileInputStream fis = new FileInputStream(path.toString());
                 ObjectInputStream in = new ObjectInputStream(fis))
            {
                Object obj = in.readObject();
                fis.close();
                in.close();
                entry = (Entry) obj;
            }
            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }

        return entry;
    }

    public void remove()
    {
        try
        {
            Files.delete(path);
        }
        catch (IOException e)
        {
        }
    }
}
