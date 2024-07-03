package com.example.Shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductCategory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {
    @Transient
  public static final String SEQUENCE_NAME = "category_id";
    @Id
    private long categoryId;
    private String categoryName;

}