package siamese.todolist.model.dao;

import org.springframework.data.repository.CrudRepository;
import siamese.todolist.model.entity.Todo;

public interface TodoDao extends CrudRepository<Todo, Integer> {

}
