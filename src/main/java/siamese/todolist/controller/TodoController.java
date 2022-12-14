package siamese.todolist.controller;

import org.springframework.web.bind.annotation.*;
import siamese.todolist.model.entity.Todo;
import siamese.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.persistence.PersistenceUnit;

@Controller
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public String getTodos(Model model) {
        Iterable<Todo> todoList = todoService.getTodos();
        model.addAttribute("todolist", todoList);
        Todo todo = new Todo();
        model.addAttribute("todoObject", todo);
        return "todolist";
    }

    @PostMapping("/todos")
    public String createTodo(@ModelAttribute Todo todo, Model model) {
        Iterable<Todo> allTodoList = todoService.createTodo(todo);
        Todo emptyTodo = new Todo();
        model.addAttribute("todolist", allTodoList);
        model.addAttribute("todoObject", emptyTodo);
        return "redirect:/todos";
    }

    @ResponseBody
    @PutMapping("/todos/{id}")
    public void updateTodo(@PathVariable Integer id, @RequestBody Todo todo){
        todoService.updateTodo(id,todo);
    }

    @ResponseBody
    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable Integer id){
        todoService.deleteTodo(id);
    }
}
