package com.example.springmvcmongogradle.task.service;

import com.example.springmvcmongogradle.task.models.TaskEntity;
import com.example.springmvcmongogradle.task.models.TaskRequest;
import com.example.springmvcmongogradle.task.models.TaskResponse;
import com.example.springmvcmongogradle.task.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @MockBean
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private TaskEntity taskEntityRequest = TaskEntity.builder()
            .id("1")
            .todo("todo1")
            .description("description1")
            .build();

    private TaskEntity taskEntityResponse = TaskEntity.builder()
            .id("1")
            .todo("todo1")
            .description("description1")
            .build();


//    @Test
//    public void createTask() {
//        Mockito.doThrow(new RuntimeException())
//                .when(registerImplMediator)
//                .register(null);
//
//        var stubExpect = RuntimeException.class;
//
//        assertThrows(stubExpect,
//                () -> implFacade.register(null));
//    }

//    @Test
//    public void createTask() {
//        Mockito.when(taskRepository.save(taskEntityRequest))
//                .thenReturn(taskEntityResponse);
//
//        assertThat(taskEntityResponse).isSameAs(taskEntityRequest);
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