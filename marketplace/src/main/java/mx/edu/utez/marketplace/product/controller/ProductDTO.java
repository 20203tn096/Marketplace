package mx.edu.utez.marketplace.product.controller;

import mx.edu.utez.marketplace.product.model.ProductImage;
import mx.edu.utez.marketplace.status.model.Status;
import mx.edu.utez.marketplace.subCategory.model.SubCategory;

import java.util.List;

public class ProductDTO {
    private long id;
    private String name;
    private String description;
    private String brand;
    private String price;
    private int  quantity;
    Status status;
    SubCategory subCategory;
    List<ProductImageDTO> images;

    public ProductDTO() {
    }

    public ProductDTO(String name, String description, String brand, String price, int quantity, Status status, SubCategory subCategory, List<ProductImageDTO> images) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.subCategory = subCategory;
        this.images = images;
    }

    public ProductDTO(long id, String name, String description, String brand, String price, int quantity, Status status, SubCategory subCategory, List<ProductImageDTO> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.subCategory = subCategory;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public List<ProductImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ProductImageDTO> images) {
        this.images = images;
    }
}
