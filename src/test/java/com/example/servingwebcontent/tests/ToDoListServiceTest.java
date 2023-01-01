package com.example.servingwebcontent.tests;

import com.example.servingwebcontent.persistence.ToDoListRepository;
import com.example.servingwebcontent.service.ToDoListService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ToDoListServiceTest implements WithAssertions {

    @Mock
    private ToDoListRepository toDoListRepository;

    @InjectMocks
    private ToDoListService toDoListService;

    @Test
    @DisplayName("returns true if delete successful")
    void returnTrueIfDeleteSuccessful() {
        Long givenId = 111L;
        doReturn(true).when(toDoListRepository).existsById(givenId);
        boolean result = toDoListService.deleteById(givenId);
        verify(toDoListRepository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("returns false if todo to delete not exists")
    void returnFalseIfTodoDeleteNotExist() {
        Long givenId = 111L;
        doReturn(false).when(toDoListRepository).existsById(givenId);
        boolean result = toDoListService.deleteById(givenId);
        verifyNoMoreInteractions(toDoListRepository);
        assertThat(result).isFalse();
    }
}
