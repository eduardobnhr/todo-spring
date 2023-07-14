package service;

import java.util.List;
import org.springframework.stereotype.Service;

import entity.Todo;
import repository.TodoRepository;

@Service
public class TodoService {

	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	List<Todo> create(Todo todo) {
		todoRepository.save(todo);
		return list();

	}

	List<Todo> list() {
		org.springframework.data.domain.Sort sort = org.springframework.data.domain.Sort.by("prioridade")
		.descending().and(org.springframework.data.domain.Sort.by("nome").ascending());
		return todoRepository.findAll(sort);
	}

	List<Todo> update(Todo todo) {
		todoRepository.save(todo);
		return list();

	}

	List<Todo> delete(Long id) {
		todoRepository.deleteById(id);;
		return list();
	}

}
