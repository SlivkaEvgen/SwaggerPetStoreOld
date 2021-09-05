package org.example.controller.user;import org.example.config.ScannerConsole;import org.example.controller.Controller;import org.example.controller.Validator;import org.example.model.User;import org.example.service.UserServiceImpl;import java.util.ArrayList;import java.util.List;import java.util.Scanner;// donepublic class UserCreateControllerImpl implements Controller {  private final Scanner scanner = ScannerConsole.getInstance();  private final List<User> userList = new ArrayList<>();  @Override  public void start() {    System.out.print(        "\n \uD83D\uDC49 USER\n \uD83D\uDC49 LIST \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");    String next = scanner.next();    if (next.equalsIgnoreCase("user")) {      create();      start();    }    if (next.equalsIgnoreCase("list")) {      createList();      start();    }    if (next.equalsIgnoreCase("back")) {      new UserControllerImpl().start();    }    if (next.equalsIgnoreCase("stop")) {      stop();    } else {      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");      start();    }  }  private void createList() {    System.out.print(        "Create users and add to List? \n \uD83D\uDC49 yes \n \uD83D\uDC49 no \n \uD83D\uDC49 ");    String answer = scanner.next();    if (Validator.validString(answer)) {      if (answer.equalsIgnoreCase("yes")) {        create();      }      if (answer.equalsIgnoreCase("no")) {        start();      } else {        System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");        createList();      }    } else {      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");      createList();    }  }  private void create() {    final UserServiceImpl userService = new UserServiceImpl();    Integer id = Integer.valueOf(enterId());    String userName = enterUserName();    String firstName = enterFirstName();    String lastName = enterLastName();    String password = enterPassword();    String email = enterEmail();    String phone = enterPhone();    User newUser =        userService.createNewUser(id, userName, firstName, lastName, password, email, phone);    userList.add(newUser);    System.out.println(" ✅ Successfully");    System.out.print("Create new user ? \n \uD83D\uDC49 yes \n \uD83D\uDC49 no \n \uD83D\uDC49 ");    String answer = scanner.next();    if (Validator.validString(answer)) {      if (answer.equalsIgnoreCase("yes")) {        create();      }      if (answer.equalsIgnoreCase("no")) {        Integer listUsers = userService.createListUsers(userList);        if (listUsers == 200) {          System.out.println(" ✅ LIST Successfully");        }        start();      } else {        System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");        create();      }    } else {      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");      create();    }  }  private String enterId() {    System.out.print(" ENTER ID \n \uD83D\uDC49 ");    String id = scanner.next();    if (!Validator.validNumber(id)) {      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");      return enterId();    }    return id;  }  private String enterUserName() {    System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");    String userName = scanner.next();    if (!Validator.validString(userName)) {      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");      return enterUserName();    }    return userName;  }  private String enterFirstName() {    System.out.print(" ENTER FIRSTNAME \n \uD83D\uDC49 ");    String firstName = scanner.next();    if (!Validator.validString(firstName)) {      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");      return enterLastName();    }    return firstName;  }  private String enterLastName() {    System.out.print(" ENTER LASTNAME \n \uD83D\uDC49 ");    String lastName = scanner.next();    if (!Validator.validString(lastName)) {      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");      return enterLastName();    }    return lastName;  }  private String enterPassword() {    System.out.print(" ENTER PASSWORD \n \uD83D\uDC49 ");    String password = scanner.next();    if (!Validator.validString(password)) {      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");      return enterPassword();    }    return password;  }  private String enterEmail() {    System.out.print(" ENTER EMAIL \n \uD83D\uDC49 ");    String email = scanner.next();    if (!Validator.validString(email)) {      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");      return enterEmail();    }    if (!email.contains("@")) {      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");      return enterEmail();    }    return email;  }  private String enterPhone() {    System.out.print(" ENTER NUMBER PHONE \n \uD83D\uDC49 ");    String number = scanner.next();    if (!Validator.validNumber(number)) {      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");      return enterPhone();    }    return number;  }  @Override  public void stop() {    System.exit(0);    scanner.close();  }}