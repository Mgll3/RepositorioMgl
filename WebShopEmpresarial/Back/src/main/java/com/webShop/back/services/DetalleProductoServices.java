package com.webShop.back.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webShop.back.modelo.DTO.DetalleProductoDTO;
import com.webShop.back.modelo.Entidad.DetalleProducto;
import com.webShop.back.persistencia.IDetalleProductoDAO;

@Service
public class DetalleProductoServices {

    @Autowired     
    private IDetalleProductoDAO detalleProductoDAO;

    public DetalleProductoDTO buscarPorId(Long id) {   
        final Optional<DetalleProducto> detalleProductoEncontrado = detalleProductoDAO.findById(id);
        if (detalleProductoEncontrado.isEmpty()){
            return null;  
        } else {
            return detalleProductoEncontrado.get().crearDto();
        }
    }

    public DetalleProducto guardar(DetalleProductoDTO detalleProducto) {
        try {
            DetalleProducto detalleProductoNuevo = new DetalleProducto(detalleProducto);
            return detalleProductoDAO.saveAndFlush(detalleProductoNuevo);
        } catch (Exception e) {
            System.out.println("Error al guardar el detalle del producto"+ e);
            return null;
        }
    }
}
