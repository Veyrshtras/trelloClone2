package com.example.trelloclone2.service.impl;

import com.example.trelloclone2.entity.Worker;
import com.example.trelloclone2.model.WorkerItem;
import com.example.trelloclone2.repositorty.WorkerRepository;
import com.example.trelloclone2.service.WorkerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WrokerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;

    public WrokerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<WorkerItem> list() {
        return workerRepository.findAll()
                .stream()
                .map(WorkerItem::fromWorker)
                .collect(Collectors.toList());
    }

    @Override
    public WorkerItem add(WorkerItem workerItem) {
        Worker worker=new Worker();
        worker.setMail(workerItem.getMail());
        worker.setName(workerItem.getName());
        worker.setPhone(workerItem.getPhone());
        workerRepository.save(worker);
        return workerItem;
    }

    @Override
    public WorkerItem get(Long id) {
        return WorkerItem.fromWorker(workerRepository.getById(id));
    }

    @Override
    public WorkerItem update(Long id, WorkerItem workerItem) {
        Worker worker=workerRepository.getById(id);
        worker.setMail(workerItem.getMail());
        worker.setName(workerItem.getName());
        worker.setPhone(workerItem.getPhone());
        workerRepository.save(worker);
        return workerItem;
    }

    @Override
    public boolean delete(Long id) {
        workerRepository.deleteById(id);
        return true;
    }
}
