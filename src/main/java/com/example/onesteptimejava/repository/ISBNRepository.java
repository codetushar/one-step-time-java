package com.example.onesteptimejava.repository;

import org.springframework.stereotype.Repository;

import com.example.onesteptimejava.dto.ISBN;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ISBNRepository extends JpaRepository<ISBN, String> {
    
}
