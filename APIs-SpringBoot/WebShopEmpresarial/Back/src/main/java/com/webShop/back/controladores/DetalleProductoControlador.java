package com.webShop.back.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.webShop.back.modelo.DTO.DetalleProductoDTO;
import com.webShop.back.modelo.Entidad.DetalleProducto;
import com.webShop.back.services.DetalleProductoServices;

import io.swagger.v3.oas.annotations.*;

@RestController
@RequestMapping ("/detalleProducto")
@CrossOrigin(origins = "*")
public class DetalleProductoControlador {

    @Autowired
    private DetalleProductoServices detalleProductoServices;

    @GetMapping("/{id}")
    public ResponseEntity<DetalleProductoDTO> buscarPorId(@PathVariable Long id){
        try {
            DetalleProductoDTO detalleProductoEncontrado = detalleProductoServices.buscarPorId(id);
            if (detalleProductoEncontrado == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return  ResponseEntity.ok(detalleProductoEncontrado);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }

    @PostMapping("/guardar")
    public ResponseEntity<DetalleProducto> guardarDetalleProducto(@RequestBody DetalleProductoDTO detalleProducto){  
        try {
            DetalleProducto detalleProductoGuardado = detalleProductoServices.guardar(detalleProducto);
            if (detalleProductoGuardado == null){
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
            } else {
                return  ResponseEntity.status(HttpStatus.CREATED).body(detalleProductoGuardado);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        } 
        
    }

    @Operation(summary = "Guardar las imágenes de un detalleProducto ya creado",
            description = "End Point para subir imagenes a la nube")
    @Parameter(name = "imagen1", description = "Imagen 1 que se va a guardar")
    @Parameter(name = "imagen2", description = "Imagen 2 que se va a guardar")
    @Parameter(name = "imagen3", description = "Imagen 3 que se va a guardar")
    @Parameter(name = "productoId", description = "Id del producto a la que se le van a asociar las imagenes")
    @PostMapping("/guardarImagenes")
    public ResponseEntity<Void> guardarImagen(
            @RequestParam("productoId") Long detalleId,
            @RequestParam("imagen1") MultipartFile imagen1,
            @RequestParam("imagen2") MultipartFile imagen2,
            @RequestParam("imagen3") MultipartFile imagen3) {
        try {

            detalleProductoServices.guardarImagen(imagen1, imagen2, imagen3, detalleId);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }

}