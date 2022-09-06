package siamese.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import siamese.todolist.entity.Todo;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public Iterable<Todo> getTodoList() {
        Iterable<Todo> todoList = todoService.getTodos();
        return todoList;
    }
}
