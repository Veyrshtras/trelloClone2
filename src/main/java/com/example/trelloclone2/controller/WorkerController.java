package com.example.trelloclone2.controller;

import com.example.trelloclone2.model.CategoryItem;
import com.example.trelloclone2.model.WorkerItem;
import com.example.trelloclone2.service.CategoryService;
import com.example.trelloclone2.service.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/s2/worker")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }
    @GetMapping
    public ResponseEntity list(){
        return ResponseEntity.ok(workerService.list());
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable Long id){
        return ResponseEntity.ok(workerService.get(id));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody WorkerItem workerItem){
        return ResponseEntity.ok(workerService.add(workerItem));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody WorkerItem workerItem){
        return ResponseEntity.ok(workerService.update(id, workerItem));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(workerService.delete(id));
    }
}
