package com.xask.phat_project.model.entities;

import jakarta.persistence.*;
import lombok.*;

//@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "item_t")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "model")
    String model;

    @Column(name = "color")
    String color;

    @Column(name = "amount")
    String amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", nullable = false )
    Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    public Item(String model, String color, String amount, Brand brand, Category category) {
        this.model = model;
        this.color = color;
        this.amount = amount;
        this.brand = brand;
        this.category = category;
    }

    @Override
    public String toString() {
        return "{" +
                 model + '\'' +
                ", color='" + color + '\'' +
                ", brand=" + brand.getBrand() +
                '}';
    }
}
