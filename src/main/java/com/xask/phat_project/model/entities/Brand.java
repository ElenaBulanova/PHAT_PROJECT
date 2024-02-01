package com.xask.phat_project.model.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//@Data
@Setter
@Getter
@NoArgsConstructor
@Entity

@Table(name = "brand_t")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true)
    private String brand;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<Item> stock;

    public Brand(String brand) {
        this.brand = brand;
        stock = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", stock=" + stock
                .stream()
                .map(Item::getId)
                .collect(Collectors.toSet())
                +
                '}';
    }
}
