package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ProductMgmtApp {

    public static void main(String[] args) {
        Product[] products = {
                new Product(3128874119L, "Banana", "2023-01-24", 124, 0.55),
                new Product(2927458265L, "Apple", "2022-12-09", 18, 1.09),
                new Product(9189927460L, "Carrot", "2023-03-31", 89, 2.99)
        };

        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getName));

        System.out.println("Printed in JSON Format:");
        System.out.println("[");
        System.out.print(
                Arrays.stream(products)
                        .map(p -> String.format(
                                "  {\"productId\": %d, \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %d, \"unitPrice\": %.2f}",
                                p.getProductId(), p.getName(), p.getDateSupplied().toString(), p.getQuantityInStock(), p.getUnitPrice()))
                        .collect(Collectors.joining(",\n"))
        );
        System.out.println("\n]");

        System.out.println("-------------------------------------------");

        System.out.println("Printed in XML Format:");
        System.out.println("<?xml version=\"1.0\"?>");
        System.out.println("<products>");
        Arrays.stream(products)
                .forEach(p -> System.out.printf(
                        "  <product productId=\"%d\" name=\"%s\" dateSupplied=\"%s\" quantityInStock=\"%d\" unitPrice=\"%.2f\"/>%n",
                        p.getProductId(), p.getName(), p.getDateSupplied().toString(), p.getQuantityInStock(), p.getUnitPrice()));
        System.out.println("</products>");

        System.out.println("-------------------------------------------");

        System.out.println("Printed in Comma-Separated Value(CSV) Format:");
        System.out.println("ProductId,Name,DateSupplied,QuantityInStock,UnitPrice");
        Arrays.stream(products)
                .forEach(p -> System.out.printf(
                        "%d,%s,%s,%d,%.2f%n",
                        p.getProductId(), p.getName(), p.getDateSupplied().toString(), p.getQuantityInStock(), p.getUnitPrice()));
    }
}
