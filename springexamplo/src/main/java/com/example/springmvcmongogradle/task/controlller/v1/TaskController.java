package com.example.springmvcmongogradle.task.controlller.v1;

import com.example.springmvcmongogradle.task.models.TaskRequest;
import com.example.springmvcmongogradle.task.models.TaskResponse;
import com.example.springmvcmongogradle.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/v1/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping()
    @ResponseStatus(CREATED)
    public TaskResponse create(@Valid @RequestBody TaskRequest taskRequest) {
        return taskService.createTask(taskRequest);
    }

    @GetMapping()
    @ResponseStatus(OK)
    public List<TaskResponse> getTodo() {
        return taskService.getTask();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public TaskResponse getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/filter/")
    @ResponseStatus(OK)
    public List<TaskResponse> getTaskFiltration(@RequestParam(required = false) String id,
                                                @RequestParam(required = false) String description,
                                                @RequestParam(required = false) Boolean completed) {
        return taskService.getTask(id, description, completed);
    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public void deleteNTodo(@RequestParam(required = false) List<String> id) {
        if (id != null) {
            taskService.deleteNTask(id);
        } else {
            taskService.deleteNTask();
        }
    }

}
