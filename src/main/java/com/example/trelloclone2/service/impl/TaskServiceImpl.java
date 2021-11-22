package com.example.trelloclone2.service.impl;

import com.example.trelloclone2.entity.Task;
import com.example.trelloclone2.entity.Worker;
import com.example.trelloclone2.model.TaskItem;
import com.example.trelloclone2.repositorty.CategoryRepository;
import com.example.trelloclone2.repositorty.TaskRepository;
import com.example.trelloclone2.repositorty.WorkerRepository;
import com.example.trelloclone2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;
    private final WorkerRepository workerRepository;
    public TaskServiceImpl(TaskRepository taskRepository, CategoryRepository categoryRepository, WorkerRepository workerRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
        this.workerRepository = workerRepository;
    }

    @Override
    public List<TaskItem> list() {
        return taskRepository.findAll()
                .stream()
                .map(TaskItem::fromTask)
                .collect(Collectors.toList());
    }

    @Override
    public TaskItem add(TaskItem taskItem) {
        Task task =new Task();
        task.setName(taskItem.getName());
        task.setDate(taskItem.getDate());
        task.setTags(taskItem.getTags());
        task.setDescription(taskItem.getDescription());
        task.setCheck_list(taskItem.getCheck_list());

        task.setCategory(categoryRepository.getById(taskItem.getCategory()));

        Set<Worker> items=new HashSet<>();
        for (Long worker : taskItem.getWorkers()) {
            items.add(workerRepository.getById(worker));
            sendMessage(workerRepository.getById(worker).getMail());
        }
        task.setWorkers(items);
        taskRepository.save(task);

        return taskItem;
    }

    @Override
    public TaskItem get(Long id) {
        return TaskItem.fromTask(taskRepository.getById(id));
    }

    @Override
    public TaskItem update(Long id, TaskItem taskItem) {
        Task task =taskRepository.getById(id);
        task.setName(taskItem.getName());
        task.setDate(taskItem.getDate());
        task.setTags(taskItem.getTags());
        task.setDescription(taskItem.getDescription());
        task.setCheck_list(taskItem.getCheck_list());

        task.setCategory(categoryRepository.getById(taskItem.getCategory()));

        Set<Worker> items=new HashSet<>();
        for (Long worker : taskItem.getWorkers()) {
            items.add(workerRepository.getById(worker));
        }
        task.setWorkers(items);
        taskRepository.save(task);
        return taskItem;
    }

    @Override
    public boolean delete(Long id) {
        taskRepository.deleteById(id);
        return true;
    }

    @Autowired
    private JavaMailSender javaMailSender;

    private void sendMessage(String toMail){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(toMail);
        simpleMailMessage.setSubject("from spring boot");
        simpleMailMessage.setText("vazifa yuklatildi");
        javaMailSender.send(simpleMailMessage);
    }
}
