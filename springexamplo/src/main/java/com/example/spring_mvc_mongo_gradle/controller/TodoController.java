//package com.example.spring_mvc_mongo_gradle.controller;
//
//import lombok.AllArgsConstructor;
//
//
//import org.springframework.web.bind.annotation.*;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//
//import javax.validation.Valid;
//
//import com.example.spring_mvc_mongo_gradle.models.todo.response.Todo;
//import com.example.spring_mvc_mongo_gradle.service.TodoService;
//
//import java.util.List;
//import static org.springframework.http.HttpStatus.*;
//
//@AllArgsConstructor
//@RestController
//@RequestMapping(value = "/v1/todo")
//public class TodoController {
//
//
//    private final TodoService todoService;
//
//
//    @Operation(summary = "Cria um Todo e salva no Mongo", description = "Cria um Todo e salva no Mongo", tags = {"Todo"})
//    @ApiResponses(value = {
//        @ApiResponse(responseCode = "200", description = "Todo criado com sucesso")
//    })
//    @PostMapping
//    @ResponseStatus(CREATED)
//    public Todo create(@Parameter(description = "Passa por corpo o Todo", required = true) @RequestBody @Valid Todo todo) {
//        return todoService.createTodo(todo);
//    }
//
//
//    @Operation(summary = "Retorna lista de Todos existentes", description = "Retorna lista de Todos existentes", tags = {"Todo"})
//    @ApiResponses(value = {
//        @ApiResponse(responseCode = "200", description = "Retornou a lista com sucesso")
//    })
//    @GetMapping
//    @ResponseStatus(OK)
//    public List<Todo> getTodo() {
//        return todoService.getTodo();
//    }
//
//
//    @Operation(summary = "Retorna um Todo apartir do ID", description = "Retorna um Todo apartir do ID", tags = {"Todo"})
//    @ApiResponses(value = {
//        @ApiResponse(responseCode = "200", description = "Retornou o todo com sucesso"),
//        @ApiResponse(responseCode = "404", description = "Não pode encontrar o Todo indicado")
//    })
//    @GetMapping("/{id}")
//    @ResponseStatus(OK)
//    public Todo getTodoById(@Parameter(description = "Id do Todo a ser pesquisado", required = true) @PathVariable String id) {
//        return todoService.getTodoById(id);
//    }
//
//
//    @Operation(summary = "Retorna um Todo apartir dos filtros ", description = "Retorna um Todo apartir dos filtros", tags = {"Todo"})
//    @ApiResponses(value = {
//        @ApiResponse(responseCode = "200", description = "Retornou o todo com sucesso"),
//        @ApiResponse(responseCode = "404", description = "Não pode encontrar o Todo indicado")
//    })
//    @GetMapping("/filter/")
//    @ResponseStatus(OK)
//    public List<Todo> getTodoFiltrado(
//        @Parameter(description = "Id do Todo a ser pesquisado", required = false) @RequestParam(required = false) String id,
//        @Parameter(description = "Descrição do Todo a ser pesquisado", required = false) @RequestParam(required = false) String description,
//        @Parameter(description = "Estado do Completed do Todo a ser pesquisado", required = false) @RequestParam(required = false) Boolean completed) {
//        return todoService.getTodo(id, description, completed);
//    }
//
//
//    @Operation(summary = "Deleta uma lista de Todo, ou todo Todos", description = "Deleta uma lista de Todo, ou todo Todos", tags = {"Todo"})
//    @ApiResponses(value = {
//        @ApiResponse(responseCode = "200", description = "Deletado com sucesso"),
//        @ApiResponse(responseCode = "404", description = "Todo não encontrado")
//    })
//    @DeleteMapping
//    @ResponseStatus(NO_CONTENT)
//    public void deleteNTodo(@Parameter(description = "Id dos Todos a serem deletados", required = false) @RequestParam(required = false) List<String> id) {
//        if (id != null) {
//            todoService.deleteNTodo(id);
//        } else {
//            todoService.deleteNTodo();
//        }
//    }
//
//
//    @Operation(summary = "Altera um Todo", description = "Altera um Todo", tags = {"Todo"})
//    @ApiResponses(value = {
//        @ApiResponse(responseCode = "200", description = "Alterado com sucesso"),
//        @ApiResponse(responseCode = "404", description = "Todo não encontrado")
//    })
//    @PutMapping("/{id}")
//    @ResponseStatus(NO_CONTENT)
//    public Todo editTodo(@Parameter(description = "Corpo do novo Todo", required = true) @RequestBody @Valid Todo todo, @Parameter(description = "Id do Todo a ser alterado", required = true) @PathVariable String id) {
//        return todoService.editTodo(id, todo);
//    }
//
//    // === === === === === === === === === === === === === === === === === === ===
//    // === === === === ===
//
//    // @PostMapping("/cookie")
//    // public void createCookie() {
//    //     ResponseCookie.from("user-id", "123")
//    //             .httpOnly(true)
//    //             .secure(true)
//    //             .path("/")
//    //             .maxAge(60)
//    //             .domain("example.com")
//    //             .build();
//    // }
//
//    // @GetMapping("/cookie")
//    // public String readCookie(
//    //         @CookieValue(name = "user-id", defaultValue = "123") String userId) {
//    //     return userId;
//
//    // }
//
//    // @GetMapping("header")
//    // public String getheader(@RequestHeader(value = "clientId") String clientId) { // HttpHeaders
//    //     return clientId;
//    // }
//
//}