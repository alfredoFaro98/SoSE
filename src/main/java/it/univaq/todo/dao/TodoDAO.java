package it.univaq.todo.dao;

import java.util.ArrayList;
import java.util.List;
import it.univaq.todo.model.Todo;

public class TodoDAO {

    private static final List<Todo> TODOS = new ArrayList<>();

    static {
        TODOS.add(new Todo(1L, "summary of the todo 1", "description of the todo 1"));
        TODOS.add(new Todo(2L, "summary of the todo 2", "description of the todo 2"));
        TODOS.add(new Todo(3L, "summary of the todo 3", "description of the todo 3"));
        TODOS.add(new Todo(123L, "summary test", "description test"));

    }

    public static List<Todo> getTodos() {
        return TODOS;
    }
}
