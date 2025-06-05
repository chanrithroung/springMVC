package com.springapp.springApplication.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Product {
    Integer code;
    String title;
    Double price;
    Integer quantity;
}
