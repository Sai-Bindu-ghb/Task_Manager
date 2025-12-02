package com.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.entity.Task;
import com.taskmanager.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

	@Autowired
    private TaskService taskService;

    // -------------------------
    // CREATE TASK
    // -------------------------
    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // -------------------------
    // UPDATE TASK
    // -------------------------
    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    // -------------------------
    // DELETE TASK
    // -------------------------
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }

    // -------------------------
    // GET ALL TASKS
    // -------------------------
    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // -------------------------
    // GET TASKS ASSIGNED TO A USER
    // -------------------------
    @GetMapping("/assigned/{userId}")
    public List<Task> getTasksAssignedToUser(@PathVariable Long userId) {
        return taskService.getTasksAssignedToUser(userId);
    }

    // -------------------------
    // GET TASKS CREATED BY MANAGER
    // -------------------------
    @GetMapping("/created/{managerId}")
    public List<Task> getTasksCreatedByManager(@PathVariable Long managerId) {
        return taskService.getTasksCreatedByManager(managerId);
    }

    // -------------------------
    // UPDATE TASK STATUS
    // -------------------------
    @PutMapping("/status/{id}")
    public Task updateTaskStatus(@PathVariable Long id,
                                 @RequestParam String status) {
        return taskService.updateStatus(id, status);
    }
}

