package com.example.springmvcmongogradle.task.service;

import com.example.springmvcmongogradle.task.models.TaskRequest;
import com.example.springmvcmongogradle.task.models.TaskResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    private List<TaskResponse> tasksResponse = List.of(TaskResponse.builder()
            .todo("Todo")
            .completed(false)
            .description("Description")
            .build());

    private TaskRequest taskRequest = TaskRequest.builder()
            .todo("Todo")
            .completed(false)
            .description("Description")
            .build();

    private TaskResponse taskResponse = TaskResponse.builder()
            .todo("Todo")
            .completed(false)
            .description("Description")
            .build();

    private TaskRequest taskRequestWithoutTodo = TaskRequest.builder()
            .todo("")
            .completed(false)
            .description("Description")
            .build();


//    @Test
//    public void createTask() {
//            Mockito.doThrow(new RuntimeException())
//                    .when(registerImplMediator)
//                    .register(null);
//
//            var stubExpect = RuntimeException.class;
//            assertThrows(stubExpect,
//                    () -> implFacade.register(null));
//        }
//    }

    @Test
    void getTask() {

    }

    @Test
    void getTaskById() {

    }

    @Test
    void testGetTask() {

    }

    @Test
    void deleteNTask() {

    }

    @Test
    void testDeleteNTask() {

    }

    @Test
    void editTodo() {

    }
}