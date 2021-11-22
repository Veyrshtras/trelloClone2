package com.example.trelloclone2.model;

import com.example.trelloclone2.entity.Worker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerItem {
    private String name;

    private String mail;

    private String phone;

    public static WorkerItem fromWorker(Worker worker){

        WorkerItem item=new WorkerItem();
        item.setMail(worker.getMail());
        item.setPhone(worker.getPhone());
        item.setName(worker.getName());
        return item;
    }
}
