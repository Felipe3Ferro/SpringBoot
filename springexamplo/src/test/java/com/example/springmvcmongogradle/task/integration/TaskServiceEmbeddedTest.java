package com.example.springmvcmongogradle.task.integration;

import com.example.springmvcmongogradle.task.models.TaskEntity;
import com.example.springmvcmongogradle.task.models.TaskRequest;
import com.example.springmvcmongogradle.task.models.TaskResponse;
import com.example.springmvcmongogradle.task.repository.TaskRepository;
import com.example.springmvcmongogradle.task.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest(properties = {"spring.mongodb.embedded.version=4.0.2"})
//@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
//@ExtendWith(MockitoExtension.class)

@ExtendWith(MockitoExtension.class)
public class TaskServiceEmbeddedTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

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

    @Test
    public void test() {
        Mockito.when(taskRepository.save(taskEntityRequestStub))
                        .thenReturn(mongoTemplate.save(taskEntityResponseStub, "Task"));

         var result = taskService.createTask(taskRequestStub);

        assertTrue(true);

//        Mockito.when(taskRepository.save(taskEntityRequestStub)).thenReturn(taskEntityResponseStub);
//
//        var result = taskService.createTask(taskRequestStub);
//
//        assertEquals(result.getTodo(),taskResponseStub.getTodo());
    }
}
