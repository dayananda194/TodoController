package org.example.todocontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private static List<Todo> todoList;

    public TodoController() {
        todoList = new ArrayList<>();
        todoList.add(new Todo(1,false,"Wake up at 7 O clock",1));
        todoList.add(new Todo(2,false,"Do a LeetCode Daily Problem",1));

    }
    @GetMapping("/todos")
    public List<Todo> getTodoList() {
        return todoList;
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo newTodo) {

            todoList.add(newTodo);
            return newTodo;
    }

}
