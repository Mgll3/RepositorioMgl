package com.webShop.back.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webShop.back.modelo.DTO.InventarioDTO;
import com.webShop.back.modelo.Entidad.Inventario;
import com.webShop.back.services.InventarioServices;

@RestController
@RequestMapping ("/inventario")
@CrossOrigin(origins = "*")
public class InventarioControlador {
    
    @Autowired
    private InventarioServices inventarioServices;


    @GetMapping("/{id}")
    public ResponseEntity<InventarioDTO> buscarPorId(@PathVariable Long id){
        InventarioDTO inventarioEncontrado = inventarioServices.buscarPorId(id);
        if (inventarioEncontrado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return  ResponseEntity.ok(inventarioEncontrado);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Inventario> guardarInventario(@RequestBody InventarioDTO inventario){
        Inventario inventarioGuardado = inventarioServices.guardar(inventario);
        if (inventarioGuardado == null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        } else {
            return  ResponseEntity.status(HttpStatus.CREATED).body(inventarioGuardado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InventarioDTO> eliminarPorId(@PathVariable Long id){
        Boolean inventarioEncontrado = inventarioServices.eliminarInventario(id);
        if (inventarioEncontrado){
            return  ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }




}
