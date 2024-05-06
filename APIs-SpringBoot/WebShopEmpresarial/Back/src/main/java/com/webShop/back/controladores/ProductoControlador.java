package com.webShop.back.controladores;


import com.webShop.back.modelo.DTO.ProductoDTO;
import com.webShop.back.modelo.Entidad.Producto;
import com.webShop.back.services.ProductoServices;

import io.swagger.v3.oas.annotations.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping ("/producto")
@CrossOrigin(origins = "*")
public class ProductoControlador {

    @Autowired
    private ProductoServices productoServices;

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> buscarPorId(@PathVariable Long id){
        try {
            ProductoDTO productoEncontrado = productoServices.buscarPorId(id);
            if (productoEncontrado == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return  ResponseEntity.ok(productoEncontrado);
            } 
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }
    
    /**
     * http://localhost:8080/producto/guardar
     * Guardar un producto
     * @param producto
     * @return
     */
    @PostMapping("/guardarr")
    public ResponseEntity<Producto> guardarProducto(@RequestBody ProductoDTO producto){  
        try {
            Producto productoGuardado = productoServices.guardarProducto(producto);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        }
        
    }

    /**
     * http://localhost:8080/producto/buscar
     * Buscar todos los productos
     * @return 
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<ProductoDTO>> buscarTodos(){
        try {
            List<ProductoDTO> productosEncontrados = productoServices.buscarTodos();
            if (productosEncontrados == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return  ResponseEntity.ok(productosEncontrados);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }

    /**
     * http://localhost:8080/producto/1
     * Eliminar un producto por id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoDTO> eliminarProducto(@PathVariable Long id){
        try {
            Boolean productoEliminado = productoServices.eliminarProducto(id);
            if (productoEliminado){
                return  ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }

    @Operation(summary = "Guardar las imágenes de un producto ya creado",
            description = "End Point para subir una imagen a la nube")
    @Parameter(name = "imagenPrincipal", description = "Imagen principal que se va a guardar")
    @Parameter(name = "productoId", description = "Id del producto a la que se le van a asociar las imagenes")
    @PostMapping("/guardarImagen")
    public ResponseEntity<Void> guardarImagen(
            @RequestParam("productoId") Long productoId,
            @RequestParam("imagenPrincipal") MultipartFile imagenPrincipal) {
        try {

            productoServices.guardarImagen(imagenPrincipal,  productoId);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
