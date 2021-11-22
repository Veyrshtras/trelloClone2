package com.example.trelloclone2.service;

import com.example.trelloclone2.model.TaskItem;

import java.util.List;

public interface TaskService {

    List<TaskItem> list();

    TaskItem add(TaskItem taskItem);

    TaskItem get(Long id);

    TaskItem update(Long id, TaskItem taskItem);

    boolean delete(Long id);
}
