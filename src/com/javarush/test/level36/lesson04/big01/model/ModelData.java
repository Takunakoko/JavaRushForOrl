package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.List;

/**
 * Created by Администратор on 21.04.2016.
 */
public class ModelData
{
    private List<User> users;
    private User activeUser;
    private boolean displayDeletedUserList;

    public boolean isDisplayDeletedUserList()
    {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeleteUserList)
    {
        this.displayDeletedUserList = displayDeleteUserList;
    }

    public User getActiveUser()
    {
        return activeUser;
    }

    public void setActiveUser(User activeUser)
    {
        this.activeUser = activeUser;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

}
