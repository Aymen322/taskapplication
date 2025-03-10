package com.example.task.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    private final TaskRepository taskRepository = mock(TaskRepository.class);
    private final TaskService taskService = new TaskService(taskRepository);

    @Test
    void getAllTasks_ShouldReturnEmptyList_WhenNoTasks() {
        when(taskRepository.findAll()).thenReturn(List.of());
        assertTrue(taskService.getAllTasks().isEmpty());
    }

    @Test
    void createTask_ShouldReturnSavedTask() {
        Task task = new Task(null, "Test Task", "Testing a task", false);
        when(taskRepository.save(task)).thenReturn(new Task(1L, "Test Task", "Testing a task", false));

        Task savedTask = taskService.createTask(task);
        assertNotNull(savedTask.getId());
        assertEquals("Test Task", savedTask.getTitle());
    }

    @Test
    void thisTestShouldFail() {
        // This assertion will fail because 2 is not equal to 3
        assertEquals(2, 3, "This test is designed to fail.");
    }

    @Disabled("This test is disabled for demonstration purposes")
    @Test
    void skippedTest() {
        fail("This test should be skipped and not executed.");
    }
}
