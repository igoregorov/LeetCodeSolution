package ru.nimdator.leetcode.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Task {
    private String taskId;
    private String className;
    private String methodName;
    private String code;
    private String description;
}