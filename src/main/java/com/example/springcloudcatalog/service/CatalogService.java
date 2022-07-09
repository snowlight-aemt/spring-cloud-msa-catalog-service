package com.example.springcloudcatalog.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.springcloudcatalog.controller.ResponseCatalog;
import com.example.springcloudcatalog.model.CatalogEntity;
import com.example.springcloudcatalog.model.CatalogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CatalogService {
    private final CatalogRepository catalogRepository;

    private final ModelMapper mapper;

    public List<ResponseCatalog> getAllCatalog() {
        Iterable<CatalogEntity> catalogs = catalogRepository.findAll();

        List<ResponseCatalog> result = new ArrayList<>();

        catalogs.forEach(c -> {
            result.add(mapper.map(c, ResponseCatalog.class));
        });

        return result;
    }

}
