package com.example.springcloudcatalog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcloudcatalog.service.CatalogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogService catalogService;

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs() {
        return ResponseEntity.ok(catalogService.getAllCatalog());
    }

    @GetMapping("/health_check")
    public String status(HttpServletRequest request) {
        return String.format("it's Working in User SErvice on port %s", request.getServerPort());
    }
}
