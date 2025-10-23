package br.com.carstore.carstore.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CarDTO {

    private int id;

    @NotBlank(message = "O nome do carro é obrigatório")
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
    private String name;

    @NotBlank(message = "A cor do carro é obrigatória")
    @Size(min = 3, max = 30, message = "A cor deve ter entre 3 e 30 caracteres")
    private String color;

    public CarDTO(){
    }

    public CarDTO(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}