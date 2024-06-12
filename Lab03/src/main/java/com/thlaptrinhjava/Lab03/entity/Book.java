package com.thlaptrinhjava.Lab03.entity;


import com.thlaptrinhjava.Lab03.Validator.annotation.ValidCategoryId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    @NotEmpty(message = "Title khong duoc de trong")
    @Size(max = 50, min = 1, message = "Title khong vuot qua 50 ky tu va toi thieu 1 ky tu")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    @NotNull(message = "Gia khong duoc de trong")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @ValidCategoryId
    private Category category;
}
