package Models.Entities;

import java.util.UUID;

public class Product {
    private final UUID id;
    private String code;
    private String info;
    private double price;
    private String unit;

    Product(String code, String info, double price, String unit) {
        this.id = UUID.randomUUID();
        this.code = code;
        this.info = info;
        this.price = price;
        this.unit = unit;
    }

    // Getters

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    // Setters

    public void setCode(String code) {
        this.code = code;
        System.out.println("Product code set to: " + this.code);
    }

    public void setInfo(String info) {
        this.info = info;
        System.out.println("Product info set to: " + this.info);
    }

    public void setPrice(double price) {
        this.price = price;
        System.out.println("Product price set to: " + this.price);
    }

    public void setUnit(String unit) {
        this.unit = unit;
        System.out.println("Product unit set to: " + this.unit);
    }
}
