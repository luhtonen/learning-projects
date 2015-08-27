package org.elu.groovy.ch01;

public class Todo {
    String name
    String note

    public static void main(String[] args) {
        def todos = [
                new Todo(name: "1", note: "one"),
                new Todo(name: "2", note: "two"),
                new Todo(name: "3", note: "three")
        ]

        todos.each {
            println "${it.name} ${it.note}"
        }
    }
}