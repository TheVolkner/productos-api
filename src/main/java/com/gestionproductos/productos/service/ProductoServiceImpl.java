package com.gestionproductos.productos.service;

import com.gestionproductos.productos.model.Producto;
import com.gestionproductos.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listAllProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Producto getProductoById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void addOrUpdateProducto(Producto p) {
        productoRepository.save(p);
    }

    @Override
    public void deleteProducto(Producto p) {
       productoRepository.delete(p);
    }

    @Override
    public void deleteProductoById(Integer id) {
        productoRepository.deleteById(id);
    }
}
