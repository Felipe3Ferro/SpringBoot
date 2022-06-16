package com.example.springmvcmongogradle.task.end2end;

import com.example.springmvcmongogradle.task.models.TaskEntity;
import com.example.springmvcmongogradle.task.models.TaskResponse;
import com.example.springmvcmongogradle.task.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class endToEnd {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TaskRepository taskRepository;

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



    @Test
    public void shouldReturnTasks() throws Exception {
        System.out.println("oi");
        Mockito.when(taskRepository.save(taskEntityRequestStub))
                .thenReturn(taskEntityResponseStub);

        String jsonRequest = objectMapper.writeValueAsString(taskResponseRequestStub);
        String jsonResponse = objectMapper.writeValueAsString(taskEntityResponseStub);

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/v1/task")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(content().json(jsonResponse));
    }

}
