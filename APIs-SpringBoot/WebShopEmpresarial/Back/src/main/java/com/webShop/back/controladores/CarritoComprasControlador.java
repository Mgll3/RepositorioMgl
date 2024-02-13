package com.webShop.back.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webShop.back.modelo.Entidad.CarritoCompras;
import com.webShop.back.services.CarritoComprasServices;

@RestController
@RequestMapping ("/carritoCompras")
@CrossOrigin(origins = "*")
public class CarritoComprasControlador {
    
    @Autowired
    private CarritoComprasServices carritoComprasServices;

    @GetMapping("/buscar")
    public ResponseEntity<CarritoCompras> buscar(){
        CarritoCompras carritoComprasEncontrado = carritoComprasServices.buscar();
        if (carritoComprasEncontrado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return  ResponseEntity.ok(carritoComprasEncontrado);
        } 
    }

    @PostMapping("/guardar")
    public ResponseEntity<CarritoCompras> guardarCarritoCompras(@RequestBody CarritoCompras carritoCompras){  
        CarritoCompras carritoComprasGuardado = carritoComprasServices.guardarCarritoCompras(carritoCompras);
        if (carritoComprasGuardado == null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(carritoComprasGuardado);
        }
    }



}
