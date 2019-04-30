package com.example.demo.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;

@RestController
@Transactional
@RequestMapping("/api/books")
public class BookControlleur {
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping
	public ResponseEntity<?> createBook(@RequestBody Book book){
		return ResponseEntity.ok(bookRepository.save(book));
	}

}
