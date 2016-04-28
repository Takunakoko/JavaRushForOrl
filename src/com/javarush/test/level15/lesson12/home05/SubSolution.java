package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Администратор on 13.08.2015.
 */
public class SubSolution extends Solution
{
    public SubSolution(String name)
    {
        super(name);
    }

    public SubSolution(Integer name)
    {
        super(name);
    }

    public SubSolution(boolean name)
    {
        super(name);
    }

    protected SubSolution(float name)
    {
        super(name);
    }

    protected SubSolution(Double name)
    {
        super(name);
    }

    protected SubSolution(double name)
    {
        super(name);
    }

    SubSolution(String name, String name2)
    {
        super(name, name2);
    }

    SubSolution(String name, Integer name2)
    {
        super(name, name2);
    }

    SubSolution(String name, double name2)
    {
        super(name, name2);
    }

    private SubSolution(short name) { super(name); }
    private SubSolution(long name) { super(name); }
    private SubSolution(char name) { super(name); }
}
