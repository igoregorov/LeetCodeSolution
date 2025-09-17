package ru.nimdator.leetcode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nimdator.leetcode.model.Task;
import ru.nimdator.leetcode.service.SolutionService;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class SolutionController {

    private final SolutionService solutionService;

    @GetMapping("/{taskId}/code")
    public ResponseEntity<String> getCode(@PathVariable String taskId) {
        Task task = solutionService.getTask(taskId);
        return task != null ? ResponseEntity.ok(task.getCode()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{taskId}/execute")
    public ResponseEntity<String> execute(@PathVariable String taskId, @RequestBody Object[] args) {
        String result = solutionService.executeTask(taskId, args);
        return ResponseEntity.ok(result);
    }
}