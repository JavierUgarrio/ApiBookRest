package com.company.books.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.books.backend.request.AuthRequest;
import com.company.books.backend.response.TokenResponse;

@RestController
@RequestMapping("/v1")
public class TokenController {

    @PostMapping("/authenticate")
    public ResponseEntity<TokenResponse> authenticate(@RequestBody AuthRequest request) {
		return null;
        
    }
}