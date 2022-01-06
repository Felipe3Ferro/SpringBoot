package com.example.spring_mvc_mongo_gradle.controller;

import com.example.spring_mvc_mongo_gradle.models.Todo;
import com.example.spring_mvc_mongo_gradle.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/todo")
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

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public void deleteNTodo(@RequestParam(required = false) List<String> id){
        if(id != null) {
            service.deleteNTodo(id);
        }else{
            service.deleteNTodo();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public Todo editTodo(@RequestBody @Valid Todo todo, @PathVariable String id){
        return service.editTodo(id, todo);
    }
}