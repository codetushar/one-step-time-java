package com.example.onesteptimejava.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.onesteptimejava.dto.ISBN;
import com.example.onesteptimejava.service.ISBNService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/isbn")
public class IBSNController {
    @Autowired
    ISBNService isbnService;

    @GetMapping("/get-all-books")
    public ResponseEntity<List<ISBN>> getAllBooks() {
        return new ResponseEntity<List<ISBN>>(isbnService.getAllBooks(), null, HttpStatus.OK);
    }

    @GetMapping("/book")
    public ResponseEntity<ISBN> getBook(@RequestParam String isbn) {
        try {
            return new ResponseEntity<ISBN>(isbnService.getBook(isbn), null, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<ISBN>(HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/book")
    public ResponseEntity<ISBN> createBook(@RequestBody ISBN book,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<ISBN>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ISBN>(isbnService.createBook(book), null, HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<ISBN> updateBook(@RequestBody ISBN book,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<ISBN>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ISBN>(isbnService.updateBook(book), null, HttpStatus.OK);
    }
}
