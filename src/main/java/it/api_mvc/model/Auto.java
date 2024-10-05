package it.api_mvc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "automobili")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String marca;
    private String modello;
    private int hp;
    private String carburante;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setCarburante(String carburante) {
        this.carburante = carburante;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getHp() {
        return hp;
    }

    public String getCarburante() {
        return carburante;
    }
}
