package org.elu.groovy.ch01;

public class Todo {
    String name
    String note

    public static void main(String[] args) {
        def todos = new ArrayList()
        todos.add(new Todo(name: "1", note: "one"))
        todos.add(new Todo(name: "2", note: "two"))
        todos.add(new Todo(name: "3", note: "three"))

        for (Todo todo: todos) {
            println "${todo.name} ${todo.note}"
        }
    }
}