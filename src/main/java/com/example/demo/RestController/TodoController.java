package com.example.demo.RestController;

import com.example.demo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController implements CommandLineRunner {

    private final TodoRepository todoRepository;

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoRepository.save(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @Override
    public void run(String... args) {
        // Optional: You can add some initial Todos here if needed
        Todo todo1 = new Todo();
        todo1.setText("Example Todo 1");
        todo1.setCompleted(false);
        todo1.setAuthor("John");
        todo1.setDue(new Date());
        todoRepository.save(todo1);
    }
}