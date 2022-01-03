package com.example.spring_mvc_mongo_gradle.controller;

import com.example.spring_mvc_mongo_gradle.models.Todo;
import com.example.spring_mvc_mongo_gradle.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/Todo")
public class TodoControllers {


    private final TodoService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public Todo create(@RequestBody @Valid Todo todo){
        return service.createTodo(todo);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<Todo> getTodo(){
        return service.getTodo();
    }

    @GetMapping("/filter/")
    @ResponseStatus(OK)
    public List<Todo> getTodoFiltrado(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Boolean completed){
        return service.getTodo(id,description,completed);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public Todo editTodo(@PathVariable String id, @RequestBody @Valid Todo todo){
        return service.editTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteTodo(@PathVariable("id") String id){
         service.deleteTodo(id);
    }

    @DeleteMapping("/")
    @ResponseStatus(NO_CONTENT)
    public void deleteAllTodo(){
        service.deleteAllTodo();
    }

    @DeleteMapping("/delete3/")
    @ResponseStatus(NO_CONTENT)
    public void delete3Todo(@RequestParam(required = false) List<String> id){
        service.deleteNTodo(id);
    }
}