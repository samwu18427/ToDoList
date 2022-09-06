package siamese.todolist.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siamese.todolist.dao.TodoDao;
import siamese.todolist.entity.Todo;

@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;

    public Iterable<Todo> getTodos (){
        return todoDao.findAll();
    }
}
