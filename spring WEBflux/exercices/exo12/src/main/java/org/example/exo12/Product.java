package org.example.exo12;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "products")
public class Product {

    @Id
    String id;
    @NotBlank(message = "Le nom du produit est obligatoire")
    @NotNull
    String name;
    @Min(value = 0, message = "La quantité doit être supérieure ou égale à 0")
    @NotNull
    int quantity;
    @Min(value = 0, message = "Le prix doit être supérieur ou égal à 0")
    @NotNull
    double price;

    public Product() {
    }

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
