package com.webShop.back.services;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webShop.back.modelo.DTO.ProductoDTO;
import com.webShop.back.modelo.Entidad.Producto;
import com.webShop.back.persistencia.IProductoDAO;

@Service
public class ProductoServices {
    
    @Autowired
    private IProductoDAO IproductoDAO;
    private Producto producto = new Producto();

    public ProductoDTO buscarPorId(Long id) {
        final Optional<Producto> productoEncontrado = IproductoDAO.findById(id);
        
        if (productoEncontrado.isEmpty()){
            return null;  
        } else {
            return producto.crearDto(productoEncontrado.get());
        }
    }

    public Producto guardarProducto(ProductoDTO producto) {
        try {
            Producto productoNuevo = new Producto(null, producto.getNombre(), producto.getPrecio(), producto.getImagenPrincipal());
            return IproductoDAO.saveAndFlush(productoNuevo);
        } catch (Exception e) {
            System.out.println("Error al guardar el producto"+ e);
            return null;
        }   
    }
    
    public List<ProductoDTO> buscarTodos() {
        try {
            List<Producto> productosEncontrados =  IproductoDAO.findAll();
            List<ProductoDTO> productosDTO = producto.crearListaDto(productosEncontrados);
            return productosDTO;
        } catch (Exception e) {
            System.out.println("Error al buscar todos los productos"+ e);
            return null;
        }
    }

    public boolean eliminarProducto(Long id) {
        // if (IproductoDAO.existsById(id)){
        //         return false;
        //     }
        try {
            IproductoDAO.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el producto"+ e);
            return false;
        }
    }
}
