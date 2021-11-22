package com.example.trelloclone2.controller;

import com.example.trelloclone2.model.TaskItem;
import com.example.trelloclone2.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/s2/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity list(){
        return ResponseEntity.ok(taskService.list());
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable Long id){
        return ResponseEntity.ok(taskService.get(id));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody TaskItem taskItem){
        return ResponseEntity.ok(taskService.add(taskItem));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody TaskItem taskItem){
        return ResponseEntity.ok(taskService.update(id, taskItem));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.delete(id));
    }
}
