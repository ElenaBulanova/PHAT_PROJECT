package com.xask.phat_project.model.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table(name = "category_t")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    Set<Item> items;

    public Category(String name) {
        this.name = name;
        items = new HashSet<>();
    }
}
