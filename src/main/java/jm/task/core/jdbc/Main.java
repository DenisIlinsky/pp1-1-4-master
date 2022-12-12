package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        // реализуйте алгоритм здесь


        userService.createUsersTable();

        userService.saveUser("Denis", "Ilyinsky", (byte) 26);
        userService.saveUser("Viktoria", "Ilyinskaya", (byte) 24);
        userService.saveUser("Diana", "Ilyinskaya", (byte) 2);
        userService.saveUser("Sergei", "Sergeevich", (byte) 27);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
