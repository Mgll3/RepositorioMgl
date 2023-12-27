package com.webShop.back.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.webShop.back.modelo.DTO.DetallePedidoDTO;
import com.webShop.back.modelo.Entidad.DetallePedido;
import com.webShop.back.services.DetallePedidoServices;

@RestController
@RequestMapping ("/detallePedido")
@CrossOrigin(origins = "*")
public class DetallePedidoControlador {
    
    @Autowired
    private DetallePedidoServices detallePedidoServices;

    @PostMapping("/guardar")
    public ResponseEntity<DetallePedido> guardarDetallePedido(@RequestBody DetallePedidoDTO detallePedido){  
        DetallePedido detallePedidoGuardado = detallePedidoServices.guardarDetallePedido(detallePedido);
        if (detallePedidoGuardado == null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(detallePedidoGuardado);
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<DetallePedidoDTO>> buscarTodos(){
        List<DetallePedidoDTO> detallePedidoEncontrados = detallePedidoServices.buscarTodos();
        if (detallePedidoEncontrados == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return  ResponseEntity.ok(detallePedidoEncontrados);
        } 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarDetallePedido(@PathVariable Long id){
        boolean detallePedidoEliminado = detallePedidoServices.eliminarDetallePedido(id);
        if (detallePedidoEliminado){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
