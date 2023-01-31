package com.gestionproductos.productos.service;

import com.gestionproductos.productos.model.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> listAllProductos();

    public Producto getProductoById(Integer id);

    public void addOrUpdateProducto(Producto p);

    public void deleteProducto(Producto p);

    public void deleteProductoById(Integer id);


}
