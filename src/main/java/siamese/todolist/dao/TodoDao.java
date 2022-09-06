package siamese.todolist.dao;

import org.springframework.data.repository.CrudRepository;
import siamese.todolist.entity.Todo;

public interface TodoDao extends CrudRepository<Todo, Integer> {

}
