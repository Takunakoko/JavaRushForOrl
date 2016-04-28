package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

/**
 * Created by Администратор on 21.04.2016.
 */
public class UsersView implements View
{
    private Controller controller;

    @Override
    public void refresh(ModelData modelData)
    {
        if (!modelData.isDisplayDeletedUserList())
        {
            System.out.println("All users:");
        }
        if (modelData.isDisplayDeletedUserList())
        {
            System.out.println("All deleted users:");
        }

        for (User users : modelData.getUsers())
        {
            System.out.println(String.format("\t%s", users));
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void fireEventShowAllUsers()
    {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers()
    {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id)
    {
        controller.onOpenUserEditForm(id);
    }
}
