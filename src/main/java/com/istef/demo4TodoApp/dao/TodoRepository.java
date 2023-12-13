package com.istef.demo4TodoApp.dao;

import com.istef.demo4TodoApp.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
     List<Todo> findTodoByUsername(String username);
}
