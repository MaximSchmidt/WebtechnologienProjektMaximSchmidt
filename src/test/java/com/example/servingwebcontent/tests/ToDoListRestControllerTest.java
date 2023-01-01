package com.example.servingwebcontent.tests;



import com.example.servingwebcontent.ToDoListController;
import com.example.servingwebcontent.api.ToDoList;
import com.example.servingwebcontent.service.ToDoListService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ToDoListController.class)
class ToDoListControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoListService toDoListService;

    @Test
    @DisplayName("returns 404 if todo not found")
    void returns404IfTodoNotFound() throws Exception {
        doReturn(null).when(toDoListService).findById(anyLong());
        mockMvc.perform(get("/api/v1/todolist/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("validates create todo request")
    void validatesCreateTodoRequest() throws Exception {
        String toDoListToCreateAsJson = "{\"titel\":, \"description\":, \"category\":, \"date\":,\"complete\":, \"priority\":}";
        mockMvc.perform(
                        post("/api/v1/todolist")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(toDoListToCreateAsJson)
                )
                .andExpect(status().isBadRequest());
    }
}
