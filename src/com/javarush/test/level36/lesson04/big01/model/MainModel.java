package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by Администратор on 22.04.2016.
 */
public class MainModel implements Model
{
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        modelData.setDisplayDeletedUserList(false);

        List<User> users = userService.getUsersBetweenLevels(1, 100);
        modelData.setUsers(getActiveUser(users));
    }

    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);

        List<User> users = userService.getAllDeletedUsers();
        //данные, полученные с сервера, необходимо положить в ModelData
        modelData.setUsers(users);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long id)
    {
        userService.deleteUser(id);
        modelData.setDisplayDeletedUserList(false);

        List<User> users = userService.getUsersBetweenLevels(1, 100);
        modelData.setUsers(getActiveUser(users));
    }

    @Override
    public void changeUserData(String name, long id, int level)
    {
        userService.createOrUpdateUser(name, id, level);
        modelData.setDisplayDeletedUserList(false);
        List<User> users = userService.getUsersBetweenLevels(1, 100);
        modelData.setUsers(getActiveUser(users));
    }

    private List<User> getActiveUser(List<User> userList)
    {
        return userService.filterOnlyActiveUsers(userList);
    }
}
