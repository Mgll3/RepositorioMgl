package com.webShop.back.services;

import java.util.Optional;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.dao.DataAccessException;


import com.webShop.back.modelo.DTO.ProductoDTO;
import com.webShop.back.modelo.Entidad.*;
import com.webShop.back.persistencia.ProductoDAO;

@Service
public class ProductoServices {
    
    @Autowired
    private ProductoDAO IproductoDAO;
    @Autowired
    private CloudinaryService cloudinaryService;

    private Producto producto = new Producto();

    @Transactional
    public ProductoDTO buscarPorId(Long id) {
        final Optional<Producto> productoEncontrado = IproductoDAO.findById(id);
        
        if (productoEncontrado.isEmpty()){
            return null;  
        } else {
            return productoEncontrado.get().crearDto();
        }
    }

    @Transactional
    public Producto guardarProducto(ProductoDTO producto) {
        Producto productoNuevo = new Producto(producto);
        return IproductoDAO.save(productoNuevo);
        
    }
    
    @Transactional
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

    @Transactional
    public boolean eliminarProducto(Long id) {
        try {
            IproductoDAO.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el producto"+ e);
            return false;
        }
    }

    @Transactional
    public void guardarImagen(MultipartFile imagenPrincipal, Long productoId) {
        String folder = "producto";

        //Busqueda de producto que vamos a modificar
        Producto producto = IproductoDAO.findById(productoId).orElseThrow(() -> 
            new DataAccessException("Publication not found") {
        });

        //Revisar si hay imagen principal y luego guardarla
        if (imagenPrincipal.getOriginalFilename() != ""){
            Map result = cloudinaryService.upload(imagenPrincipal, folder);

            Image mainImage = new Image(result.get("public_id").toString(), 
            result.get("secure_url").toString());
            producto.setImagenPrincipal(mainImage);
        } else{
            throw new DataAccessException("Main image not found") {
            };
        }
        
        IproductoDAO.save(producto);
    }
}
