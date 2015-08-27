package org.elu.groovy.ch01;

import java.util.List;
import java.util.ArrayList;

public class Todo {
    String name;
    String note;

    public static void main(String[] args) {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo(name: "1", note: "one"));
        todos.add(new Todo(name: "2", note: "two"));
        todos.add(new Todo(name: "3", note: "three"));

        for (Todo todo: todos) {
            System.out.println(todo.name + " " + todo.note);
        }
    }
}