package org.example.springbootdeveloper.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springbootdeveloper.dto.response.GetBookResponseDto;
import org.example.springbootdeveloper.entity.Category;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostBookRequestDto {

    private Long id;
    private String title;
    private String author;
    private Category category;

    public void PostBookResponseDto(Long id, String title,
                                    String author, Category category,
                                    List<GetBookResponseDto> GetResponseDto
                               ) {

    }
}
