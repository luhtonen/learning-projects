package org.elu.learning.java8;

import java.util.HashSet;
import java.util.Set;

/** Created by luhtonen on 24/06/15. */
public class Component {
  String name;
  Set<Item> items = new HashSet<>();

  public Component(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Item> getItems() {
    return items;
  }
}
