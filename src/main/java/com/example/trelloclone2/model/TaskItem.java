package com.example.trelloclone2.model;

import com.example.trelloclone2.entity.Category;
import com.example.trelloclone2.entity.Task;
import com.example.trelloclone2.entity.Worker;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class TaskItem {
    private String name;

    private String description;

    private Date date= new Date();

    private String tags;

    private String check_list;

    private Set<Long> workers;

    private Long category;

    public static TaskItem fromTask(Task task){
        TaskItem taskItem=new TaskItem();
        taskItem.setName(task.getName());
        taskItem.setDate(task.getDate());
        taskItem.setTags(task.getTags());
        taskItem.setDescription(task.getDescription());
        Set<Long> items=new HashSet<>();
        for (Worker worker : task.getWorkers()) {
            items.add(worker.getId());
        }
        taskItem.setWorkers(items);
        taskItem.setCategory((task.getCategory().getId()));

        return taskItem;
    }
}
