package com.webShop.back.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webShop.back.modelo.DTO.DetallePedidoDTO;
import com.webShop.back.modelo.Entidad.DetallePedido;
import com.webShop.back.persistencia.IDetallePedidoDAO;


@Service
public class DetallePedidoServices {
    
    @Autowired
    private IDetallePedidoDAO IdetallePedidoDAO;
    private DetallePedido detallePedido = new DetallePedido();

    public DetallePedido guardarDetallePedido(DetallePedidoDTO detallePedido) {
        try {
            DetallePedido detallePedidoNuevo = new DetallePedido(detallePedido);
            return IdetallePedidoDAO.saveAndFlush(detallePedidoNuevo);
        } catch (Exception e) {
            System.out.println("Error al guardar el detallePedido"+ e);
            return null;
        }   
    }

    public List<DetallePedidoDTO> buscarTodos() {
        try {
            List<DetallePedido> detallePedidosEncontrados =  IdetallePedidoDAO.findAll();
            List<DetallePedidoDTO> detallePedidosDTO = detallePedido.crearListaDto(detallePedidosEncontrados);
            return detallePedidosDTO;
        } catch (Exception e) {
            System.out.println("Error al buscar todos los detallePedidos"+ e);
            return null;
        }
    }

    public boolean eliminarDetallePedido(Long id) {
        try {
            IdetallePedidoDAO.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el detallePedido"+ e);
            return false;
        }
    }

}
