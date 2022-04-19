package com.playground.reactivemongocrud.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private Integer qty;
    private BigDecimal price;
}
