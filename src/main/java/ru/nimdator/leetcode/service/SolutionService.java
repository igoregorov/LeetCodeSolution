package ru.nimdator.leetcode.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.nimdator.leetcode.model.Task;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class SolutionService {

    private final Map<String, Task> taskMap = new HashMap<>();

    @PostConstruct
    public void init() {
        Task task = new Task();
        task.setTaskId("1226");
        task.setClassName("DiningPhilosophers");
        task.setCode(loadCodeFromFile("task1226/DiningPhilosophers.java"));
        taskMap.put("1226", task);
    }

    public Task getTask(String taskId) {
        return taskMap.get(taskId);
    }

    public String executeTask(String taskId, Object... args) {
        return "Executed";
    }

    private String loadCodeFromFile(String path) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(path);
            return new String(is.readAllBytes());
        } catch (Exception e) {
            return "Code not found";
        }
    }
}