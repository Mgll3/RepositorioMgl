package com.webShop.back.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webShop.back.modelo.DTO.InventarioDTO;
import com.webShop.back.modelo.Entidad.Inventario;
import com.webShop.back.persistencia.InventarioDAO;


@Service
public class InventarioServices {
    
    @Autowired
    private InventarioDAO IInventarioDAO;

    public InventarioDTO buscarPorId(Long id){
        final Optional<Inventario> inventarioEncontrado = IInventarioDAO.findById(id);
        if (inventarioEncontrado == null){
            return null;  
        } else {
            return inventarioEncontrado.get().crearDto();
        }
    }

    public Inventario guardar(InventarioDTO inventario) {
        try {
            Inventario inventarioNuevo = new Inventario(inventario);
            return IInventarioDAO.saveAndFlush(inventarioNuevo);
        } catch (Exception e) {
            System.out.println("Error al guardar el inventario"+ e);
            return null;
        }
    }

    public boolean eliminarInventario(Long id) {
        try {
            IInventarioDAO.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el inventario"+ e);
            return false;
        }
    }

}
