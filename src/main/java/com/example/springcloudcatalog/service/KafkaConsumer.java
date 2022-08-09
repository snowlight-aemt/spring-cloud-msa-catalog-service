package com.example.springcloudcatalog.service;

import java.util.Map;

import org.apache.naming.factory.FactoryBase;
import org.bouncycastle.jcajce.provider.digest.GOST3411.HashMac;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Service;

import com.example.springcloudcatalog.model.CatalogEntity;
import com.example.springcloudcatalog.model.CatalogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final CatalogRepository catalogRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "example-order-topic")
    public void processMessage(String kafkaMessage) {
        log.info("Kafka Message =============> " + kafkaMessage);

        Map<String, Object> readValue = null;
        try {
            // TODO type token 방식에 대해서 공부
            readValue = objectMapper.readValue(kafkaMessage, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        CatalogEntity catalogEntity = catalogRepository.findByProductId((String) readValue.get("productId"));
        catalogEntity.setStock(catalogEntity.getStock() - (Integer) readValue.get("qty"));

        catalogRepository.save(catalogEntity);
    }
}

