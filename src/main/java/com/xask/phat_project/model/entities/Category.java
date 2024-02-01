package com.xask.phat_project.model.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "category_t")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    Set<Item> items;

    public Category(String name) {
        this.name = name;
        items = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category='" + name + '\'' +
                ", stock=" + items
                .stream()
                .map(Item::getId)
                .collect(Collectors.toSet())
                +
                '}';
    }
}
