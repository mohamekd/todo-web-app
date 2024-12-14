package com.kood.Todo.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kood.Todo.Entities.Todo;
import com.kood.Todo.Repos.TodoRepo;
import com.kood.Todo.Services.TodoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {


	private TodoRepo todoRepo;
	
	public TodoControllerJPA(TodoRepo todoRepo) {
		super();
		this.todoRepo = todoRepo;
	}
	

	@RequestMapping(value = "todos")
	public String listAllTodos(ModelMap map) {
		List<Todo> studyTodosList = todoRepo.findByUsername(getLoggedName());
		map.addAttribute("studyTodosList", studyTodosList);
		return "todos-list";
	}

	@RequestMapping(value = "newtodo", method = RequestMethod.GET)
	public String showNewTodo(ModelMap map) {
		Todo todo = new Todo(0, getLoggedName(),"",LocalDate.now().plusWeeks(1), false);
		map.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "newtodo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap map,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setName(getLoggedName());
		todoRepo.save(todo);
		return "redirect:todos";
	}
	
	@RequestMapping(value = "delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepo.deleteById(id);
		return "redirect:todos";
	}
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id,ModelMap map) {
		Todo todo = todoRepo.findById(id).get();
		map.addAttribute("todo",todo);
		return "todo";
	}

	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap map,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setName(getLoggedName());
		todoRepo.save(todo);
		return "redirect:todos";
	}



	private String getLoggedName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
}
