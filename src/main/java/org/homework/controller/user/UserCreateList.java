package org.homework.controller.user;

import lombok.NoArgsConstructor;
import org.homework.config.ScannerConsole;
import org.homework.controller.EnterCommands;
import org.homework.controller.interfaces.Controller;
import org.homework.model.User;
import org.homework.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class UserCreateList implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private final EnterCommands enterCommands = EnterCommands.getEnterCommands();
  private final List<User> userList = new ArrayList<>();
  private static UserCreateList userCreateListController;

  public static UserCreateList getUserCreateListController() {
    if (userCreateListController == null) {
      userCreateListController = new UserCreateList();
    }
    return userCreateListController;
  }

  private Long completeList() {
    return userService.createListUsers(userList);
  }

  private void createUser() {
    User user = new User();
    user.setId(enterCommands.enterId());
    user.setUsername(enterCommands.enterUserName());
    user.setFirstName(enterCommands.enterFirstName());
    user.setLastName(enterCommands.enterLastName());
    user.setEmail(enterCommands.enterEmail());
    user.setPassword(enterCommands.enterPassword());
    user.setPhone(enterCommands.enterPhone());
    user.setUserStatus(200);
    userList.add(user);
    start();
  }

  @Override
  public void start() {
    System.out.print("Create new user ? \n \uD83D\uDC49 yes \n \uD83D\uDC49 no \n \uD83D\uDC49 ");
    String next = scanner.next();
    Long status = 0L;
    if (next.equalsIgnoreCase("yes")) {
      createUser();
    }
    if (next.equalsIgnoreCase("no")) {
      status = completeList();
    }
    if (status == 200) {
      System.out.println(" ✅ Successfully");
    }
  }

  @Override
  public void stop() {
    System.exit(0);
  }

  public List<User> getUserList() {
    start();
    return userList;
  }
}
