package com.example.demo.repository;

import com.example.demo.RestController.Todo;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, String> {
    List<Todo> findAll();
}