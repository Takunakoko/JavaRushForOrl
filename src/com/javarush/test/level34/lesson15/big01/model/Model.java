package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

/**
 * Created by admin on 12.04.2016.
 */
public class Model
{
    public static final int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;

    private LevelLoader levelLoader = new LevelLoader(Paths.get("../res/levels.txt"));

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects()
    {
        return gameObjects;
    }

    public void restartLevel(int level)
    {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart()
    {
        restartLevel(currentLevel);
    }

    public void startNextLevel()
    {
        restartLevel(++currentLevel);
    }

    public void move(Direction direction)
    {
        Player player = gameObjects.getPlayer();
        int sellSize = FIELD_SELL_SIZE;
        if (checkWallCollision(player, direction) || checkBoxCollision(direction))
        {
            return;
        }
        switch (direction.ordinal())
        {
            case 0:
                player.move(-sellSize, 0);
                break;
            case 1:
                player.move(sellSize, 0);
                break;
            case 2:
                player.move(0, -sellSize);
                break;
            case 3:
                player.move(0, sellSize);
                break;
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction)
    {
        for(Wall wall : gameObjects.getWalls())
        {
            if(gameObject.isCollision(wall, direction))
                return true;
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction)
    {
        Player player = gameObjects.getPlayer();

        // найдем во что уперся игрок
        GameObject  stoped = null;
        for (GameObject gameObject: gameObjects.getAll()){
            if (!(gameObject instanceof Player)&&!(gameObject instanceof Home) && player.isCollision(gameObject, direction)){
                stoped = gameObject;
            }
        }
        //свободное место или дом
        if ((stoped == null)){
            return false;
        }
        if (stoped instanceof Box){
            Box stopedBox = (Box)stoped;
            if (checkWallCollision(stopedBox, direction)){
                return true;
            }
            for (Box box : gameObjects.getBoxes()){
                if(stopedBox.isCollision(box, direction)){
                    return true;
                }
            }
            switch (direction)
            {
                case LEFT:
                    stopedBox.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_SELL_SIZE);
            }
        }
        return false;
    }

    public void checkCompletion()
    {
        boolean flag = true;
        for (Home home : gameObjects.getHomes())
        {
            boolean currentHomeFlag = false;
            for (Box box : gameObjects.getBoxes())
                if(box.getX() == home.getX() && box.getY() == home.getY())
                    currentHomeFlag = true;
            if(!currentHomeFlag)
                flag = false;
        }

        if(flag)
            eventListener.levelCompleted(currentLevel);
    }


}
