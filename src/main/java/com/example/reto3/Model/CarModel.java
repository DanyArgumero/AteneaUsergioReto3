package com.example.reto3.Model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Entity
@Table(name = "Car")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCar")
    private Integer idCar;

    @Column(name = "Name")
    private String name;
    @Column(name = "Brand")
    private String brand;

    @Column(name = "Year")
    private Integer year;

    @Column(name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "idGama")
    @JsonIgnoreProperties("cars")
    private GamaModel gama;

    @OneToMany
    @JoinColumn(name = "idMessage")
    @JsonIgnoreProperties({"cars", "clients"})
    private List<MessageModel> messages;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties({"cars", "clients"})
    private List<Reservation> reservations;

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GamaModel getGama() {
        return gama;
    }

    public void setGama(GamaModel gama) {
        this.gama = gama;
    }

    public List<MessageModel> getMesssages() {
        return message;
    }

    public void setMesssages(List<MessageModel> messsages) {
        this.message = messsages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}