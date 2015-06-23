package org.elu.learning.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    List<User> users = new ArrayList<>();
    users.add(new User("qwe"));
    users.add(new User("rty"));
    users.add(new User("uio"));
    users.add(new User("edu"));

    Optional<User> user1 = fetchUserByName(users, "edu");
    Optional<User> user2 = fetchUserByName(users, "ude");
    if (user1.isPresent()) {
      System.out.println("User 1: " + user1.get());
    }
    if (user2.isPresent()) {
      System.out.println("User 2: " + user2.get());
    } else {
      System.out.println("User not found: " + user2);
    }
  }

  private static Optional<User> fetchUserByName(List<User> users, String name) {
    return users.stream().filter(user -> name.equals(user.getName())).findFirst();
  }
}
