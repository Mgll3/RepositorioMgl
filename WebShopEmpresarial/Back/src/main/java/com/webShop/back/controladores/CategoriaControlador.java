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

import com.webShop.back.modelo.DTO.CategoriaDTO;
import com.webShop.back.modelo.Entidad.Categoria;
import com.webShop.back.services.CategoriaServices;


@RestController
@RequestMapping ("/categoria")
@CrossOrigin(origins = "*")
public class CategoriaControlador {
    
    @Autowired
    private CategoriaServices categoriaServices;
    
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id){
        CategoriaDTO categoriaEncontrada = categoriaServices.buscarPorId(id);
        if (categoriaEncontrada == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return  ResponseEntity.ok(categoriaEncontrada);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Categoria> guardarcategoria(@RequestBody CategoriaDTO categoria){  
        Categoria categoriaGuardado = categoriaServices.guardar(categoria);
        if (categoriaGuardado == null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        } else {
            return  ResponseEntity.status(HttpStatus.CREATED).body(categoriaGuardado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaDTO> eliminarPorId(@PathVariable Long id){
        Boolean categoriaEncontrada = categoriaServices.eliminarCategoria(id);
        if (categoriaEncontrada == false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return  ResponseEntity.noContent().build();
        }
    }
}
