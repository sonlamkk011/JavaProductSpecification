package com.example.javaproduct.entity;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String name;
    private String description;
    private String gender;
    private String color;
    private String size;
    private double price;
    private LocalDateTime createAt;
    private int status;


}
