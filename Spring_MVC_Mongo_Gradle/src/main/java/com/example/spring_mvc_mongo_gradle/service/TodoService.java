package com.example.spring_mvc_mongo_gradle.service;

import com.example.spring_mvc_mongo_gradle.exception.notFound.ResourceNotFoundException;
import com.example.spring_mvc_mongo_gradle.models.Todo;
import com.example.spring_mvc_mongo_gradle.repositories.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;



@AllArgsConstructor
@Service
public class TodoService {

    private final TodoRepository repository;

    public Todo createTodo(Todo todo) {
        return repository.save(todo);
    }

    public List<Todo> getTodo(){
       return repository.findAll();
    }

    public List<Todo> getTodo(String id, String description, Boolean completed){

//        repository.findByTodo(); **
        return repository.findAll().stream().filter(getTodoFiltrado(id,description,completed)).collect(Collectors.toList());
    }

    private Predicate<Todo> getTodoFiltrado(String id, String description,Boolean completed) {
        return t -> t.getDescription().equals(description) || t.getId().equals(id) || t.getCompleted().equals(completed);
    }

    public Todo editTodo(String id,Todo todo){
        Todo todoModel = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ID not found"));
        todo.setId(todoModel.getId());
        return repository.save(todo);
    }

    public void deleteTodo(String id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID not found"));
        repository.deleteById(id);
    }

    public void deleteAllTodo() {
        repository.deleteAll(repository.findAll());
    }


    public void deleteNTodo(List<String> id) {
        if(!id.isEmpty()){
            var a =repository.findAllById(id);
            repository.deleteAll(a);
        }
    }
}