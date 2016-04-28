package com.javarush.test.level35.lesson10.bonus01;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static void main(String[] args)
    {
        Set<? extends Animal> allAnimals = getAllAnimals("C://pathToClasses/");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals)
    {
        Set<Animal> animals = new HashSet<>();
        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
            pathToAnimals = pathToAnimals + "/";

        File dirOfClass = new File(pathToAnimals);
        String[] classList = dirOfClass.list(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.toLowerCase().endsWith(".class");
            }
        });
        for (String m : classList)
        {
            try
            {
                final String finalPathToAnimals = pathToAnimals;
                ClassLoader loader = new ClassLoader()
                {
                    @Override
                    protected Class<?> findClass(String className) throws ClassNotFoundException
                    {
                        try
                        {
                            byte b[] = Files.readAllBytes(Paths.get(finalPathToAnimals + className + ".class"));
                            return defineClass(null, b, 0, b.length);
                        }
                        catch (IOException e)
                        {
                            return super.findClass(className);
                        }
                    }
                };
                String mName = m.substring(0, m.length()-6);
                Class clazz = loader.loadClass(mName);
                boolean hasInterface = false;
                Class[] interfaces = clazz.getInterfaces();
                for (Class i : interfaces)
                {
                    if (Animal.class == i)
                    {
                        hasInterface = true;
                        break;
                    }
                }
                if (!hasInterface) continue;
                boolean hasConstructor = false;
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor c : constructors)
                {
                    if (Modifier.isPublic(c.getModifiers()) && c.getParameterTypes().length == 0)
                    {
                        hasConstructor = true;
                        break;
                    }
                }
                if (!hasConstructor) continue;
                animals.add((Animal) clazz.newInstance());
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }


        return animals;
    }
}
