package com.example.springcloudcatalog.controller;

import java.io.Serializable;

public class CatalogDto implements Serializable {
    private String productId;
    private Integer dty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;
}