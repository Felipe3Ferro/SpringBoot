//package com.example.spring_mvc_mongo_gradle.controller;
//
//import java.net.URI;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class TodoControllerTest {
//
//  @Autowired
//  private MockMvc mockMvc;
//
//  @Test
//  public void createTodo_StatusCode_201() throws Exception {
//    URI uri = new URI("http://localhost:8080/v1/todo/");
//    String json = "{ \"todo\" : \"Criar post\" , \"description\" : \"descricao generica\",\"completed\" : false }";
//
//    mockMvc
//        .perform(MockMvcRequestBuilders
//            .post(uri)
//            .content(json)
//            .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(MockMvcResultMatchers
//            .status()
//            .is(201));
//  }
//
//  @Test
//  public void createTodo_StatusCode_400() throws Exception {
//    URI uri = new URI("http://localhost:8080/v1/todo/");
//    String json = "{ \"description\" : \"descricao generica\",\"completed\" : false }";
//
//    mockMvc
//        .perform(MockMvcRequestBuilders
//            .post(uri)
//            .content(json)
//            .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(MockMvcResultMatchers
//            .status()
//            .is(400));
//  }
//
//  @Test
//  public void editTodoById_StatusCode_204() throws Exception {
//    URI uri = new URI("http://localhost:8080/v1/todo/61d7c593f6bc2076df13623e");
//    String json = "{ \"todo\" : \"Criar post\" , \"description\" : \"descricao generica\",\"completed\" : false }";
//
//    mockMvc
//        .perform(MockMvcRequestBuilders
//            .put(uri)
//            .content(json)
//            .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(MockMvcResultMatchers
//            .status()
//            .is(204));
//  }
//
//  @Test
//  public void editTodoById_StatusCode_404() throws Exception {
//    URI uri = new URI("http://localhost:8080/v1/todo/620533cc36c4d26be8dd0");
//    String json = "{ \"todo\" : \"Criar post\" , \"description\" : \"descricao generica\",\"completed\" : false }";
//
//    mockMvc
//        .perform(MockMvcRequestBuilders
//            .put(uri)
//            .content(json)
//            .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(MockMvcResultMatchers
//            .status()
//            .is(404));
//  }
//
//  @Test
//  public void findTodoById_StatusCode_204() throws Exception {
//    URI uri = new URI("http://localhost:8080/v1/todo/61d7c593f6bc2076df13623e");
//
//    mockMvc
//        .perform(MockMvcRequestBuilders
//            .get(uri))
//        .andExpect(MockMvcResultMatchers
//            .status()
//            .is(200));
//  }
//
//  @Test
//  public void findTodoById_StatusCode_404() throws Exception {
//    URI uri = new URI("http://localhost:8080/v1/todo/61d7c593f6bc2076df1362");
//
//    mockMvc
//        .perform(MockMvcRequestBuilders
//            .get(uri))
//        .andExpect(MockMvcResultMatchers
//            .status()
//            .is(404));
//  }
//
//}