package org.example.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.PostBookRequestDto;
import org.example.springbootdeveloper.dto.response.PostBookResponseDto;
import org.example.springbootdeveloper.dto.response.GetBookListResponseDto;
import org.example.springbootdeveloper.dto.response.GetBookResponseDto;
import org.example.springbootdeveloper.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/test/books")
@RequiredArgsConstructor
public class BookController {

        private final BookService bookService;


        @GetMapping("/{id}")
        public ResponseEntity<GetBookResponseDto> getBookById(@PathVariable Long id) {
            GetBookResponseDto response = bookService.getBookById(id);
            return ResponseEntity.ok(response);
        }

        @GetMapping
        public ResponseEntity<GetBookListResponseDto> getAllBooks() {
            GetBookListResponseDto response = bookService.getAllBooks();
            return ResponseEntity.ok(response);
        }

        @PostMapping
        public ResponseEntity<PostBookResponseDto> createBook(@RequestBody PostBookRequestDto requestDto) {
            PostBookResponseDto response = bookService.createBook(requestDto);
            return ResponseEntity.ok(response);
        }

        @PutMapping("/{id}")
        public ResponseEntity<PostBookResponseDto> updateBook(
                @PathVariable Long id, @RequestBody PostBookRequestDto requestDto) {
            PostBookResponseDto response = bookService.updateBook(id, requestDto);
            return ResponseEntity.ok(response);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteBook(@PathVariable Long id) {
            bookService.deleteBook(id);
            return ResponseEntity.ok("Book deleted successfully");
        }
    }
