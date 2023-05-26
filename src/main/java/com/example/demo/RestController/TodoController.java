package com.example.demo.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private ArrayList<Todo> todos = new ArrayList<>();
    Todo todoes = new Todo();
    Todo LoSientoAlberto = new Todo();

    @GetMapping("/showtodos")
    public ResponseEntity<List<Todo>> getAllTodos() {
        LoSientoAlberto.setId("4567");
        LoSientoAlberto.setAuthor("espero que no explote");

        todos.add(LoSientoAlberto);
        todos.add(todoes);

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> createdTodo(@RequestBody Todo todo) {
        todos.add(todo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Todo> DeleteTodo(@RequestBody Todo tododelete) {
     for ( Todo todo : todos) {
         if (todo.getId() == tododelete.getId()) {
             todos.remove(tododelete);
         }
     }
     return new ResponseEntity<>(tododelete, HttpStatus.OK);

    }


      /*
    @Override


    public void run(String... args) {
        // Optional: You can add some initial Todos here if needed
        Todo todo1 = new Todo();
        todo1.setText("Example Todo 1");
        todo1.setCompleted(false);
        todo1.setAuthor("John");
        todo1.setDue(new Date());
        todoRepository.save(todo1);

       */

    }
