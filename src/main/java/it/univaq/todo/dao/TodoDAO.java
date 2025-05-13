package it.univaq.todo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.univaq.todo.model.Todo;

public class TodoDAO {

    public static List<Todo> getTodos() {
        return new ArrayList<>(Arrays.asList(
            new Todo(1L, "summary of the todo 1", "description of the todo 1"),
            new Todo(2L, "summary of the todo 2", "description of the todo 2"),
            new Todo(3L, "summary of the todo 3", "description of the todo 3")
        ));
    }
}
