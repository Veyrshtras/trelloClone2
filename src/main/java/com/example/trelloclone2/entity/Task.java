package com.example.trelloclone2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Column(columnDefinition = "text")
    private String description;

    private Date date=new Date();

    @Column(columnDefinition = "text")
    private String tags;

    @Column(columnDefinition = "text")
    private String check_list;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private Set<Worker> workers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Category category;
}
