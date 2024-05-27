package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {
    private long productId;
    private String name;
    private LocalDate dateSupplied;
    private int quantityInStock;
    private double unitPrice;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Product() {
        this.productId = 0;
        this.name = "";
        this.dateSupplied = LocalDate.now();
        this.quantityInStock = 0;
        this.unitPrice = 0.0;
    }

    public Product(long productId, String name, String dateSupplied, int quantityInStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = LocalDate.parse(dateSupplied, DATE_FORMATTER);
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product(long productId, String name, int quantityInStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = LocalDate.now();
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(String dateSupplied) {
        this.dateSupplied = LocalDate.parse(dateSupplied, DATE_FORMATTER);
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return String.format("%-12d %-10s %-12s %-17d $%-14.2f", productId, name, dateSupplied.format(DATE_FORMATTER), quantityInStock, unitPrice);
    }
}
