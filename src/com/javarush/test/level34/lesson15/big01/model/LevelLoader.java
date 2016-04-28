package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE;

/**
 * Created by admin on 13.04.2016.
 */
public class LevelLoader
{
    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

    public GameObjects getLevel(int level)
    {
        Set<Home> setHome = new HashSet<>();
        Set<Box> setBox = new HashSet<>();
        Set<Wall> setWall = new HashSet<>();
        Player player = new Player(0, 0);
        ArrayList<String> levelList = new ArrayList<>();
        int x0 = FIELD_SELL_SIZE / 2;
        int y0 = FIELD_SELL_SIZE / 2;

        while (level > 60)
        {
            level -= 60;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(levels.toString())))
        {
            while (true)
            {
                String maze = reader.readLine();
                if (maze.contains("Maze: " + level))
                {
                    levelList.add(maze);
                    break;
                }
            }
            String temp;
            while(!("*************************************").equals(temp = reader.readLine()))
            {
                levelList.add(temp);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < 7; i++)
            levelList.remove(0);
        for (int y = 0; y < levelList.size(); y++)
        {
            char[] line = levelList.get(y).toCharArray();
            for(int x=0; x < line.length; x++)
            {
                switch (line[x])
                {
                    case ' ':
                        break;
                    case 'X':
                        setWall.add(new Wall(x * FIELD_SELL_SIZE + x0, y * FIELD_SELL_SIZE + y0));
                        break;
                    case '*':
                        setBox.add(new Box(x * FIELD_SELL_SIZE + x0, y * FIELD_SELL_SIZE + y0));
                        break;
                    case '.':
                        setHome.add(new Home(x * FIELD_SELL_SIZE + x0, y * FIELD_SELL_SIZE + y0));
                        break;
                    case '&':
                        setBox.add(new Box(x0 + x * Model.FIELD_SELL_SIZE, y0 + y * Model.FIELD_SELL_SIZE));
                        setHome.add(new Home(x0 + x * Model.FIELD_SELL_SIZE, y0 + y * Model.FIELD_SELL_SIZE));
                        break;
                    case '@':
                        player = new Player(x * FIELD_SELL_SIZE + x0, y * FIELD_SELL_SIZE + y0);
                        break;
                }
            }
        }

        GameObjects gameObjects = new GameObjects(setWall, setBox, setHome, player);
        return gameObjects;
    }
}
