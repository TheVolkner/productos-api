package com.gestionproductos.productos.controller;

import com.gestionproductos.productos.model.Producto;
import com.gestionproductos.productos.service.ProductoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> findAllProductos(){

      return productoService.listAllProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> findProductoById(@PathVariable Integer id){

       try {
           Producto p = productoService.getProductoById(id);
           if(p != null){

               return new ResponseEntity<Producto>(p, HttpStatus.OK);
           } else {

               return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
           }

       } catch(Exception exception){

          return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
       }
    }

    @PostMapping("/productos")
    public void addProducto(@RequestBody Producto p){

        productoService.addOrUpdateProducto(p);

    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> updateProducto(@RequestBody Producto p, @PathVariable Integer id){

       try {

           Producto pExiste = productoService.getProductoById(id);
           if(pExiste != null){

               pExiste.setNombre(p.getNombre());
               pExiste.setPrecio(p.getPrecio());
               productoService.addOrUpdateProducto(pExiste);

               return new ResponseEntity<Producto>(HttpStatus.OK);
           } else {

               return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);

           }

       } catch(Exception e){

           return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
       }


    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> removeProducto(@PathVariable Integer id){

        try {

            Producto pExiste = productoService.getProductoById(id);
            if(pExiste != null){

                productoService.deleteProductoById(id);

                return new ResponseEntity<Producto>(HttpStatus.OK);
            } else {

                return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);

            }

        } catch(Exception e){

            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }


    }


}
