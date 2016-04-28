package com.javarush.test.level36.lesson04.big01.controller;

import com.javarush.test.level36.lesson04.big01.model.Model;
import com.javarush.test.level36.lesson04.big01.view.EditUserView;
import com.javarush.test.level36.lesson04.big01.view.UsersView;

/**
 * Created by Администратор on 21.04.2016.
 */
public class Controller
{
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setModel(Model model)
    {
        this.model = model;
    }

    public void setUsersView(UsersView usersView)
    {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView)
    {
        this.editUserView = editUserView;
    }

    public void onShowAllUsers()
    {
        //обратиться к модели и инициировать загрузку юзеров
        model.loadUsers();
        //Вью сама не умеет себя обновлять. Это делает Контроллер.
        // Пойди в контроллер и добавь обновление данных во Вью. Напомню, данные хранятся в Моделе
        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers()
    {
        model.loadDeletedUsers();
        //обновить Вью.
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long id){
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }

    public void onUserChange(String name, long id, int level)
    {
        model.changeUserData(name, id, level);
        usersView.refresh(model.getModelData());
    }
}
