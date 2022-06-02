package com.example.springmvcmongogradle.task.end2end;


import com.example.springmvcmongogradle.task.controlller.v1.TaskController;
import com.example.springmvcmongogradle.task.controlller.v1.TaskControllerTest;
import com.example.springmvcmongogradle.task.models.TaskEntity;
import com.example.springmvcmongogradle.task.models.TaskResponse;
import com.example.springmvcmongogradle.task.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class endToEnd {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskController taskController;

    private URI uri = new URI("http://localhost:8080/v1/task");

    private ObjectMapper objectMapper = new ObjectMapper();

    private TaskResponse taskResponseRequestStub = TaskResponse.builder()
            .description("description")
            .todo("todo")
            .completed(true)
            .build();

    private TaskEntity taskEntityRequestStub = TaskEntity.builder()
            .id("id")
            .description("description")
            .todo("todo")
            .completed(true)
            .build();

    private TaskEntity taskEntityResponseStub = TaskEntity.builder()
            .id("id")
            .description("description")
            .todo("todo")
            .completed(true)
            .build();

    public endToEnd() throws URISyntaxException {
    }

    @Test
    public void shouldReturnTasks() throws Exception {
        Mockito.when(taskRepository.save(taskEntityRequestStub))
                .thenReturn(taskEntityResponseStub);

        String jsonRequest = objectMapper.writeValueAsString(taskResponseRequestStub);
        String jsonResponse = objectMapper.writeValueAsString(taskEntityResponseStub);

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(content().json(jsonResponse));
    }
}
