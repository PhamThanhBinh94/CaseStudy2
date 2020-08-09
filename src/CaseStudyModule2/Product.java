package CaseStudyModule2;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String id;
    private double price;
    private String brand;
    private int amount;

    public Product() {
    }

    public Product(String name, String id, double price, String brand, int amount) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.brand = brand;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", amount=" + amount +
                '}';
    }
}
