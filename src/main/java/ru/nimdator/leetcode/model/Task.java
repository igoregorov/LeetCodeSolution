package ru.nimdator.leetcode.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Task {
    private String taskId;
    private String className;
    private String methodName;
    private String code;
    private String description;
}