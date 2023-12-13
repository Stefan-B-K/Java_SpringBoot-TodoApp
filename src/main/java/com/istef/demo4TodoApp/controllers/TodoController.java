package com.istef.demo4TodoApp.controllers;


import com.istef.demo4TodoApp.dao.TodoRepository;
import com.istef.demo4TodoApp.entities.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("user")
@RequestMapping("todo")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("list")
    public String listTodos(ModelMap model) {
        String username = (String) model.get("user");
        model.addAttribute("todos", todoRepository.findTodoByUsername(username));
        return "todo";
    }

    @GetMapping("add")
    public String newTodo(Todo todo, ModelMap model) {
        model.addAttribute("editForm", false);
        return "todo-add-edit";
    }

    @PostMapping("add")
    public String addTodo(@Valid Todo todo,
                          BindingResult bindingResult,
                          ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("editForm", false);
            return "todo-add-edit";
        }
        String username = (String) model.get("user");
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list";
    }

    @PostMapping("delete/{id}")
    public String deleteTodo(@PathVariable("id") int id) {
        todoRepository.deleteById(id);
        return "redirect:/todo/list";
    }

    @GetMapping("edit/{id}")
    public String editTodo(@PathVariable("id") int id, ModelMap model) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isEmpty()) return "redirect:/todo/add";
        model.addAttribute("editForm", true);
        model.addAttribute("todo", todo.get());
        return "todo-add-edit";
    }

    @PostMapping("edit/{id}")
    public String saveTodo(@Valid Todo todo,
                           BindingResult bindingResult,
                           ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("editForm", true);
            return "todo-add-edit";
        }
        String username = (String) model.get("user");
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:/todo/list";
    }
}
