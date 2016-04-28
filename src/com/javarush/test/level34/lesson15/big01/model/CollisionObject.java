package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by admin on 12.04.2016.
 */
public abstract class CollisionObject extends GameObject
{
    public CollisionObject(int x, int y)
    {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction)
    {
        int x = getX();
        int y = getY();

        switch (direction.ordinal()){
            case 0:
                x -= Model.FIELD_SELL_SIZE;
                break;
            case 1:
                x += Model.FIELD_SELL_SIZE;
                break;
            case 2:
                y -= Model.FIELD_SELL_SIZE;
                break;
            case 3:
                y += Model.FIELD_SELL_SIZE;
                break;
        }
        return x == gameObject.getX() && y == gameObject.getY() ? true : false;
    }
}
