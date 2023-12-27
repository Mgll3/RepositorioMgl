package com.webShop.back.controladores;


import com.webShop.back.modelo.DTO.ProductoDTO;
import com.webShop.back.modelo.Entidad.Producto;
import com.webShop.back.services.ProductoServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/producto")
@CrossOrigin(origins = "*")
public class ProductoControlador {

    @Autowired
    private ProductoServices productoServices;

    /**
     * http://localhost:8080/producto/1
     * Buscar un producto por id
     * @param id
     * @return
    */

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> buscarPorId(@PathVariable Long id){
        ProductoDTO productoEncontrado = productoServices.buscarPorId(id);
        if (productoEncontrado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return  ResponseEntity.ok(productoEncontrado);
        } 
    }
    
    /**
     * http://localhost:8080/producto/guardar
     * Guardar un producto
     * @param producto
     * @return
     */
    @PostMapping("/guardar")
    public ResponseEntity<Producto> guardarProducto(@RequestBody ProductoDTO producto){  
        Producto productoGuardado = productoServices.guardarProducto(producto);
        if (productoGuardado == null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);
        }
    }

    /**
     * http://localhost:8080/producto/buscar
     * Buscar todos los productos
     * @return 
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<ProductoDTO>> buscarTodos(){
        List<ProductoDTO> productosEncontrados = productoServices.buscarTodos();
        if (productosEncontrados == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return  ResponseEntity.ok(productosEncontrados);
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
        Boolean productoEliminado = productoServices.eliminarProducto(id);
        if (productoEliminado){
            return  ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
