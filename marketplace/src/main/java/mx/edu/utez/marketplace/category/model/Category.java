package mx.edu.utez.marketplace.category.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.marketplace.status.model.Status;
import mx.edu.utez.marketplace.subCategory.model.SubCategory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "description", unique = true, columnDefinition = "text")
    private String description; //Si no especificamos el tipo de dato por defecto VARCHAR(255)
    //columnDefinition = Especificar el tipo de dato en base de datos

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<SubCategory> subcategory;


    public Category() {
    }


    public Category(String description, Status status) {
        this.description = description;
        this.status = status;
    }

    public Category(long id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
