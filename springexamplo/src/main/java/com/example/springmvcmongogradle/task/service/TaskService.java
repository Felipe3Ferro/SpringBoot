package com.example.springmvcmongogradle.task.service;

import com.example.springmvcmongogradle.task.exception.NotFoundException;
import com.example.springmvcmongogradle.task.mapper.TaskResponseMapper;
import com.example.springmvcmongogradle.task.models.TaskEntity;
import com.example.springmvcmongogradle.task.models.TaskRequest;
import com.example.springmvcmongogradle.task.models.TaskResponse;
import com.example.springmvcmongogradle.task.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

import static com.example.springmvcmongogradle.task.mapper.TaskEntityMapper.toTaskEntity;
import static com.example.springmvcmongogradle.task.mapper.TaskResponseMapper.toTaskResponse;

@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskResponse createTask(TaskRequest taskRequest) {
        var taskEntity = toTaskEntity(taskRequest);
        return toTaskResponse(taskRepository.save(taskEntity));
    }

    public List<TaskResponse> getTask() {
        return taskRepository.findAll().stream()
                .map(TaskResponseMapper::toTaskResponse)
                .toList();
    }

    public TaskResponse getTaskById(String id) {
        return toTaskResponse(taskRepository.findById(id).orElseThrow(() -> new NotFoundException("ID not found")));
    }


    public List<TaskResponse> getTask(String id, String description, Boolean completed) {

        return taskRepository.findAll().stream().filter(getTaskFiltration(id, description, completed))
                .map(TaskResponseMapper::toTaskResponse)
                .toList();
    }

    private Predicate<TaskEntity> getTaskFiltration(String id, String description, Boolean completed) {
        return t -> t.getDescription().equals(description) || t.getId().equals(id) || t.getCompleted().equals(completed);
    }

    public void deleteNTask() {
        taskRepository.deleteAll(taskRepository.findAll());
    }

    public void deleteNTask(List<String> id) {
        if (!id.isEmpty()) {
            var a = taskRepository.findAllById(id);
            taskRepository.deleteAll(a);
        }
    }

    public TaskResponse editTodo(String id, TaskRequest taskRequest) {
        TaskResponse taskModel = taskRepository.findById(id)
                .map(TaskResponseMapper::toTaskResponse)
                .orElseThrow(() -> new NotFoundException("ID not found"));


        taskModel.setTodo(taskRequest.getTodo());
        taskModel.setDescription(taskRequest.getDescription());
        taskModel.setCompleted(taskRequest.getCompleted());
        taskModel.setDataUpdate();
        return toTaskResponse(taskRepository.save(toTaskEntity(taskModel)));
    }

}
