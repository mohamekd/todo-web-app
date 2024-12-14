package com.kood.Todo.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kood.Todo.Entities.Todo;

public interface TodoRepo extends JpaRepository<Todo, Integer> {
	public List<Todo> findByUsername(String username);
}
