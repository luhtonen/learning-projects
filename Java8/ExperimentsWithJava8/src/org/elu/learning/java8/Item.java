package org.elu.learning.java8;

/** Created by luhtonen on 24/06/15. */
public class Item {
  String name;
  Component component;

  public Item(String name, Component component) {
    this.name = name;
    this.component = component;
  }

  public Item(String name) {
    this.name = name;
  }

  public Component getComponent() {
    return component;
  }

  public void setComponent(Component component) {
    this.component = component;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Item{" +
        "name='" + name + '\'' +
        '}';
  }
}
