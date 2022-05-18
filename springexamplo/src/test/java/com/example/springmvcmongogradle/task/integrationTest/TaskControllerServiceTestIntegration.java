package com.example.springmvcmongogradle.task.integrationTest;

import com.example.springmvcmongogradle.task.models.TaskEntity;
import com.example.springmvcmongogradle.task.models.TaskResponse;
import com.example.springmvcmongogradle.task.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskControllerServiceTestIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    private TaskResponse taskResponse = TaskResponse.builder()
            .id("1")
            .todo("todo1")
            .completed(true)
            .description("description1")
            .build();

    @BeforeAll
    public void setup() {
        taskRepository.save(TaskEntity.builder().id("1").todo("todo1").completed(true).description("description1").build());
        taskRepository.save(TaskEntity.builder().id("2").todo("todo2").completed(true).description("description2").build());
        taskRepository.save(TaskEntity.builder().id("3").todo("todo3").completed(true).description("description3").build());
        taskRepository.save(TaskEntity.builder().id("4").todo("todo4").completed(true).description("description4").build());
    }

    @Test
    public void test_getById_successfull() throws Exception {
        String id = "1";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(taskResponse);

        mockMvc.perform(get("http://localhost:8080/v1/task/"+ id))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));        ;
    }
}
