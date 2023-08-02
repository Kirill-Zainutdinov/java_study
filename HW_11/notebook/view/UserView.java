package HW_11.notebook.view;

import HW_11.notebook.controller.UserController;
import HW_11.notebook.model.User;
import HW_11.notebook.util.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case SHOW_LIST:
                    List<User> users = userController.readAll();
                    System.out.println(users);
                    break;
                case CREATE:
                    String firstName = prompt("Имя: ");
                    String lastName = prompt("Фамилия: ");
                    String phone = prompt("Номер телефона: ");
                    userController.createUser(firstName, lastName, phone);
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case UPDATE:
                    String userId = prompt("Enter user id: ");
                    firstName = prompt("Имя: ");
                    lastName = prompt("Фамилия: ");
                    phone = prompt("Номер телефона: ");
                    userController.updateUser(userId, firstName, lastName, phone);
                    break;
                case DELETE:
                    userId = prompt("Enter user id: ");
                    userController.deleteUser(userId);
                    break;

            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
