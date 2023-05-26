package com.example.demo.repository;

import com.example.demo.RestController.Todo;

public interface CrudRepository<T, T1> {
    Todo save(Todo todo);
}
