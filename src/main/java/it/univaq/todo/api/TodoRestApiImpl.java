package it.univaq.todo.api;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Produces;
import java.util.List;
import it.univaq.todo.dao.TodoDAO;
import it.univaq.todo.model.Todo;

@Path("/todos")
@Produces({ MediaType.APPLICATION_JSON })
public class TodoRestApiImpl implements TodoRestApi {
    @Override
    public List<Todo> getTodos() {
        return TodoDAO.getTodos();
    }

    @Override
    public Todo getTodo(String id) {
        List<Todo> todos = TodoDAO.getTodos();
        if (todos.contains(new Todo(Long.valueOf(id)))) {
            return todos.get(todos.indexOf(new Todo(Long.valueOf(id))));
        }
        return null;
    }

    @Override
    public boolean create(Todo todo) {
        return TodoDAO.getTodos().add(todo);
    }

    @Override
    public boolean update(Todo todo) {
        List<Todo> todos = TodoDAO.getTodos();
        int index = todos.indexOf(todo);
        if (index >= 0) {
            todos.set(index, todo);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        return TodoDAO.getTodos().remove(new Todo(Long.valueOf(id)));
    }
}
