package com.example.onesteptimejava.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.onesteptimejava.dto.ISBN;
import com.example.onesteptimejava.library.JSON;
import com.example.onesteptimejava.repository.ISBNRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("ISBNService")
public class ISBNService {

    @Autowired
    private ISBNRepository isbn;

    private static HttpURLConnection con;

    public ISBNService() {

    }

    public static StringBuilder getBookDetails(String isbn) throws MalformedURLException,
            ProtocolException, IOException {

        String url = "https://api2.isbndb.com/book/" + isbn.trim();
        StringBuilder content;
        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "48428_7a5994c7fe97cce48d08959054455ee4");
            con.setRequestMethod("GET");
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                }
            }
        } finally {
            con.disconnect();
        }
        return content;
    }

    public List<ISBN> getAllBooks() {
        List<ISBN> out = this.isbn.findAll((Sort.by(Sort.Direction.DESC, "isbn")));
        return out;
    }

    public ISBN getBook(String isbn) throws JsonMappingException, JsonProcessingException, MalformedURLException,
            ProtocolException, IOException {
        ISBN out = this.isbn.getReferenceById(isbn);
        try {
            if(out.authors != null) {
                return out;
            }
            throw new Exception("Book not found");
        } catch (Exception e) {
            ObjectMapper objectMapper = new ObjectMapper();
            ISBN book = objectMapper.convertValue(JSON.convertToMap(getBookDetails(isbn).toString()).get("book"),
                    ISBN.class);
            ISBN newBook = this.createBook(book);
            System.out.println(newBook.toString());
            return newBook;
        }
    }

    public ISBN updateBook(ISBN book) {
        return this.isbn.saveAndFlush(book);
    }

    public ISBN createBook(ISBN book) {
        return this.isbn.save(book);
    }
}
