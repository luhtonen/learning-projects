package org.elu.learning.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    System.out.println("###");
    System.out.println("testing optional");
    testOptional();
    System.out.println("###");
    System.out.println("testing stream match");
    testStreamMatch();
  }

  private static void testStreamMatch() {
    List<Item> items = buildComponentList().stream()
        .flatMap(c -> c.getItems().stream())
        .collect(Collectors.toList());

    System.out.println("###");
    System.out.println("items = " + items);

    Map<String, Set<String>> itemsByComponents = items.stream()
        .collect(Collectors.groupingBy(item -> item.getComponent().getName(),
            Collectors.mapping(Item::getName, Collectors.toSet())));

    System.out.println("###");
    System.out.println("map = " + itemsByComponents);

    Set<String> adjustedItems1 = new HashSet<>(Arrays.asList("item1", "item2", "item3", "item4", "item5"));
    Set<String> adjustedItems2 = new HashSet<>(Arrays.asList("item2", "item3", "item4", "item5"));
    Set<String> adjustedItems3 = new HashSet<>(Arrays.asList("item4", "item5"));

    System.out.println("###");
    System.out.println("adjustedItems1 = " + adjustedItems1);
    System.out.println("adjustedItems2 = " + adjustedItems2);
    System.out.println("adjustedItems3 = " + adjustedItems3);
    System.out.println("###");

    itemsByComponents.keySet().stream().forEach(key -> {
      if (itemsByComponents.get(key).stream().anyMatch(adjustedItems1::contains) &&
          !itemsByComponents.get(key).stream().allMatch(adjustedItems1::contains)) {
        System.out.println("Mismatch found in adjustedItems1");
      }
    });
    System.out.println("Done with adjustedItems1");

    itemsByComponents.keySet().stream().forEach(key -> {
      if (itemsByComponents.get(key).stream().anyMatch(adjustedItems2::contains) &&
          !itemsByComponents.get(key).stream().allMatch(adjustedItems2::contains)) {
        System.out.println("Mismatch found in adjustedItems2");
      }
    });

    System.out.println("Done with adjustedItems2");
    itemsByComponents.keySet().stream().forEach(key -> {
      if (itemsByComponents.get(key).stream().anyMatch(adjustedItems3::contains) &&
          !itemsByComponents.get(key).stream().allMatch(adjustedItems3::contains)) {
        System.out.println("Mismatch found in adjustedItems3");
      }
    });
    System.out.println("Done with adjustedItems3");
  }

  private static List<Component> buildComponentList() {
    List<Component> components = new ArrayList<>();
    Component component = new Component("component1");
    Set<Item> items = new HashSet<>();
    items.add(new Item("item1", component));
    items.add(new Item("item2", component));
    items.add(new Item("item3", component));
    component.getItems().addAll(items);
    components.add(component);
    component = new Component("component2");
    items = new HashSet<>();
    items.add(new Item("item4", component));
    items.add(new Item("item5", component));
    component.getItems().addAll(items);
    components.add(component);
    return components;
  }

  private static void testOptional() {
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
