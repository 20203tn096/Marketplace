package mx.edu.utez.marketplace.status.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.marketplace.category.model.Category;
import mx.edu.utez.marketplace.product.model.Product;
import mx.edu.utez.marketplace.subCategory.model.SubCategory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<Category> categoria;

    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<SubCategory> subcategory;

    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<Product> products;

    public Status() {
    }

    public Status(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
