package org.elu.learning.java8;

/** Created by luhtonen on 23/06/15. */
public class User {
  String name;

  public User(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    return !(name != null ? !name.equals(user.name) : user.name != null);
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        '}';
  }
}
