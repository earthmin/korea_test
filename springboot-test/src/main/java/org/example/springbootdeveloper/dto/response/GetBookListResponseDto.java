package org.example.springbootdeveloper.dto.response;

import lombok.Data;
import org.example.springbootdeveloper.entity.Category;

import java.util.List;

@Data
public class GetBookListResponseDto {
    private Long id;
    private String title;
    private String author;
    private Category category;

    public GetBookListResponseDto(Long id, Long id1, String title,
                                  String author, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;

    }

    public GetBookListResponseDto(List<GetBookResponseDto> books) {
    }
}
