package org.example.todocontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Todo>> getTodoList() {

        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo newTodo) {

            todoList.add(newTodo);
            return new ResponseEntity<>(newTodo,HttpStatus.CREATED);
    }
    @GetMapping("/todos/{userId}")
    public ResponseEntity<?> getTodo(@PathVariable int userId) {
        List<Todo> reqTodos = new ArrayList<>();
        for (Todo todo : todoList) {
            if (todo.getUserId() == userId) {
                    reqTodos.add(todo);
            }
        }
        if(reqTodos.isEmpty()) {
            return new ResponseEntity<>("There were no Todos for with userId "+userId ,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reqTodos, HttpStatus.OK);
    }

}
