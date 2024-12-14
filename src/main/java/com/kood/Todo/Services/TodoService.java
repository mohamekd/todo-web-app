package com.kood.Todo.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.kood.Todo.Entities.Todo;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;
//	static {
//		todos.add(new Todo(++todosCount, "medo", "Learn AWS", LocalDate.now().plusYears(1), false));
//		todos.add(new Todo(++todosCount, "Kood", "Go to the gym", LocalDate.now().plusMonths(6), false));
//		todos.add(new Todo(++todosCount, "kood", "German", LocalDate.now().plusMonths(8), false));
//		todos.add(new Todo(++todosCount, "Medo", "fixing the car", LocalDate.now().plusDays(2), false));
//	}
	
	public List<Todo> findByName(String userName){
		Predicate<? super Todo> userNameCheck= todo-> todo.getName().equalsIgnoreCase(userName);
		return todos.stream().filter(userNameCheck).toList();
	}
	
	public void addTodo(String name, String description, LocalDate target, boolean done) {
		Todo t = new Todo(++todosCount, name, description, target, done);
		todos.add(t);
	}
	public void deleteTodo(int id) {
		Predicate<? super Todo> idCheck= todo-> todo.getId() == id;
		todos.removeIf(idCheck);
	}
	
	public Todo findById(int id) {
		Predicate<? super Todo> idCheck= todo-> todo.getId() == id;
		return todos.stream().filter(idCheck).findFirst().get();
	}

	public void updateTodo(@Valid Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}
		
	
	
}
