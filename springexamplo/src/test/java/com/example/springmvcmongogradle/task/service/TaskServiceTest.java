package com.example.springmvcmongogradle.task.service;

import com.example.springmvcmongogradle.task.exception.NotFoundException;
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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private List<TaskEntity> taskEntityListStub = List.of(TaskEntity.builder()
            .todo("Todo")
            .completed(false)
            .description("Description")
            .build());

    private List<TaskResponse> taskResponseListStub = List.of(TaskResponse.builder()
            .todo("Todo")
            .completed(false)
            .description("Description")
            .build());

    private TaskEntity taskEntityResponseStub = TaskEntity.builder()
            .id("1")
            .todo("todo1")
            .description("description1")
            .build();

    private TaskEntity taskEntityRequestStub = TaskEntity.builder()
            .todo("todo1")
            .description("description1")
            .build();


    private TaskResponse taskResponseStub = TaskResponse.builder()
            .id("1")
            .todo("todo1")
            .description("description1")
            .build();

    private TaskRequest taskRequestStub = TaskRequest.builder()
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
//
//    @Test
//    public void createTask() {
//        Mockito.when(taskRepository.save(taskEntityRequest))
//                .thenReturn(taskEntityResponse);
//
//        assertThat(taskEntityResponse).isSameAs(taskEntityRequest);
//    }


    @Test
    void testGetTask_Should_Return_TaskResponseStub() {
        Mockito.when(taskRepository.findAll())
                .thenReturn(taskEntityListStub);

        var result = taskService.getTask();
        assertEquals(taskResponseListStub, result);
    }

    @Test
    void testGetTaskById_ShouldReturn_TaskResponseStub() {
        Mockito.when(taskRepository.findById("1"))
                .thenReturn(Optional.ofNullable(taskEntityResponseStub));

        var result = taskService.getTaskById("1");
        assertEquals(taskResponseStub, result);
    }

    @Test
    void testGetTaskById_ShouldReturn_NotFoundException() {
        Mockito.when(taskRepository.findById("2"))
                .thenThrow(new NotFoundException("id not found"));

        NotFoundException notFoundException = assertThrows(NotFoundException.class, () ->
                taskService.getTaskById("2"));

        assertEquals(notFoundException, new NotFoundException("id not found"));
    }

    @Test
    void testPostTask_ShouldReturn_TaskResponse() {
        Mockito.when(taskRepository.save(taskEntityRequestStub))
                .thenReturn(taskEntityResponseStub);

        var result = taskService.createTask(taskRequestStub);

        assertNotNull(result);
        assertEquals(result.getTodo(),taskResponseStub.getTodo());
    }



    @Test
    void test() {
        Mockito.when(taskRepository.save(taskEntityRequestStub)).thenReturn(taskEntityResponseStub);

        var result = taskService.createTask(taskRequestStub);

        assertEquals(result.getTodo(),taskResponseStub.getTodo());
    }

}