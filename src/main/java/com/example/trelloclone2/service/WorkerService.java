package com.example.trelloclone2.service;

import com.example.trelloclone2.model.WorkerItem;

import java.util.List;

public interface WorkerService {
    List<WorkerItem> list();

    WorkerItem add(WorkerItem workerItem);

    WorkerItem get(Long id);

    WorkerItem update(Long id, WorkerItem workerItem);

    boolean delete(Long id);
}
