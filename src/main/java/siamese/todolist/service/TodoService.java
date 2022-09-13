package siamese.todolist.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siamese.todolist.model.dao.TodoDao;
import siamese.todolist.model.entity.Todo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;

    public Iterable<Todo> getTodos (){
        return todoDao.findAll();
    }

    public Iterable<Todo> createTodo(Todo todo){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date = df.format(new Date());
        todo.setCreateTime(date);
        todo.setUpdateTime(date);
        todoDao.save(todo );
        return getTodos();
    }

    public Todo updateTodo(Integer id,Todo todo){
        try{
            Todo resTodo = findById(id);
            Integer status = todo.getStatus();
            resTodo.setStatus(status);
            return todoDao.save(resTodo);
        }catch(Exception e){
            return null;
        }
    }

    public Todo findById(Integer id){
        Todo todo = todoDao.findById(id).get();
        return todo;
    }

    public Boolean deleteTodo(Integer id){
        try {
            Todo resTodo = findById(id);
            todoDao.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
