package com.gestionproductos.productos.repository;

import com.gestionproductos.productos.model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto,Integer> {
}
