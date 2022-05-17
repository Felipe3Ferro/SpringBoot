package com.example.springmvcmongogradle.task.controlller.v1;

import com.example.springmvcmongogradle.task.exception.NotFoundException;
import com.example.springmvcmongogradle.task.models.TaskEntity;
import com.example.springmvcmongogradle.task.models.TaskRequest;
import com.example.springmvcmongogradle.task.models.TaskResponse;
import com.example.springmvcmongogradle.task.repository.TaskRepository;
import com.example.springmvcmongogradle.task.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureDataMongo
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    @MockBean
    private TaskService taskService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private URI uri = new URI("http://localhost:8080/v1/task");

    @BeforeAll
    public void setup(){

        taskRepository.save(TaskEntity.builder().id("1").todo("todo1").completed(true).description("description1").build());
        taskRepository.save(TaskEntity.builder().id("2").todo("todo2").completed(true).description("description2").build());
        taskRepository.save(TaskEntity.builder().id("3").todo("todo3").completed(true).description("description3").build());
        taskRepository.save(TaskEntity.builder().id("4").todo("todo4").completed(true).description("description4").build());

    }

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
            .id("627beed7e5c4157c27332a0c")
            .todo("Todo")
            .completed(false)
            .description("Description")
            .build();

    private TaskRequest taskRequestWithoutTodo = TaskRequest.builder()
            .todo("")
            .completed(false)
            .description("Description")
            .build();

    public TaskControllerTest() throws URISyntaxException {
    }

    @Test
    public void shouldGetTasks() throws Exception {
        Mockito.when(taskService.getTask())
                .thenReturn(tasksResponse);

        String jsonResponse = objectMapper.writeValueAsString(tasksResponse);

        mockMvc.perform(get(uri))
                .andExpect(status().is(200))
                .andExpect(content().json(jsonResponse));
    }

    @Test
    public void createTask_StatusCode_201() throws Exception {
        Mockito.when(taskService.createTask(taskRequest))
                .thenReturn(taskResponse);

        String jsonResponse = objectMapper.writeValueAsString(taskResponse);
        String jsonRequest = objectMapper.writeValueAsString(taskRequest);

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(content().json(jsonResponse));
    }

    @Test
    public void createTodo_StatusCode_400() throws Exception {
        Mockito.when(taskService.createTask(taskRequestWithoutTodo))
                .thenReturn(taskResponse);

        String jsonRequest = objectMapper.writeValueAsString(taskRequestWithoutTodo);

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getTaskById_StatusCode_200() throws Exception {
        String id = "627beed7e5c4157c27332a0c";
        Mockito.when(taskService.getTaskById(id))
                .thenReturn(taskResponse);

        String jsonResponse = objectMapper.writeValueAsString(taskResponse);

        mockMvc.perform(get(uri + "/" + id))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
    }

    @Test
    public void getTaskById_StatusCode_404() throws Exception {
        String id = "13";
        Mockito.doThrow(new NotFoundException("ID not found")).when(taskService).getTaskById(id);

        mockMvc.perform(get(uri + "/" + id))
                .andExpect(status().isNotFound());
    }

    @Test
    public void test_getById_successfull() throws Exception {
        mockMvc.perform(get("/").param("id", "1")).andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"firstName\":\"James\",\"lastName\":\"Bond\"}"));        ;
    }

}   