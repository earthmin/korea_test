package org.example.springbootdeveloper.dto.response;

import org.example.springbootdeveloper.entity.Category;

public class GetBookResponseDto {
    private Long id;
    private String title;
    private String author;
    private Category category;

    public GetBookResponseDto(Long id, String title, String author, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }



}
