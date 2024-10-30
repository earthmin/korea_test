package org.example.springbootdeveloper.service;

import org.example.springbootdeveloper.dto.request.PostBookRequestDto;
import org.example.springbootdeveloper.dto.response.PostBookResponseDto;
import org.example.springbootdeveloper.dto.response.GetBookListResponseDto;
import org.example.springbootdeveloper.dto.response.GetBookResponseDto;
import org.example.springbootdeveloper.entity.Book;
import org.example.springbootdeveloper.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 단건 조회
    public GetBookResponseDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return new GetBookResponseDto(book.getId(), book.getTitle(), book.getAuthor(), book.getCategory());
    }

    // 전체 조회
    public GetBookListResponseDto getAllBooks() {
        List<GetBookResponseDto> books = bookRepository.findAll().stream()
                .map(book -> new GetBookResponseDto(book.getId(), book.getTitle(), book.getAuthor(), book.getCategory()))
                .collect(Collectors.toList());
        return new GetBookListResponseDto(books);
    }

    // 책 추가
    public PostBookResponseDto createBook(PostBookRequestDto requestDto) {
        Book book = new Book();
        book.setTitle(requestDto.getTitle());
        book.setAuthor(requestDto.getAuthor());
        book.setCategory(requestDto.getCategory());
        Book savedBook = bookRepository.save(book);
        return new PostBookResponseDto(savedBook.getId(), "책이 정보가 추가 되었습니다.");
    }

    // 책 업데이트
    public PostBookResponseDto updateBook(Long id, PostBookRequestDto requestDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(requestDto.getTitle());
        book.setAuthor(requestDto.getAuthor());
        book.setCategory(requestDto.getCategory());
        Book updatedBook = bookRepository.save(book);
        return new PostBookResponseDto(updatedBook.getId(), "책 정보가 성공적으로 업데이트 되었습니다.");
    }

    // 책 삭제
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }
    }
