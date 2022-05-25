package com.example.springmvcmongogradle.task.service;

import com.example.springmvcmongogradle.task.models.TaskEntity;
import com.example.springmvcmongogradle.task.models.TaskRequest;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;

@DataMongoTest(properties = {"spring.mongodb.embedded.version=4.0.2"})
@ExtendWith(SpringExtension.class)
public class TaskServiceEmbeddedTest {

    private TaskRequest taskRequest = TaskRequest.builder().todo("Todo").completed(false).description("Description").build();

    private TaskEntity taskEntityStub = TaskEntity.builder().id("1").todo("Todo1").completed(false).description("Description1").build();

    @Test
    public void test(@Autowired MongoTemplate mongoTemplate) {
        // when
        mongoTemplate.save(taskEntityStub, "Task");

        // then
        assertTrue(mongoTemplate.findAll(TaskEntity.class, "Task").contains(taskEntityStub));
    }

}
