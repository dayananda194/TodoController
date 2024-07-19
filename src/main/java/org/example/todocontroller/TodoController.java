package org.example.todocontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Todo>> getTodoList() {

        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo newTodo) {

            todoList.add(newTodo);
            return new ResponseEntity<>(newTodo,HttpStatus.CREATED);
    }

}
