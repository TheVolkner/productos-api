package com.gestionproductos.productos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    private String nombre;

    private Double precio;

    public Producto(){

    }

    public Producto(Integer idProducto,String nombre,Double precio){

        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre,Double precio){

        this.nombre = nombre;
        this.precio = precio;
    }
}
