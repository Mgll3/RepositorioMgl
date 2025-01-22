package com.webShop.back.services;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.webShop.back.modelo.DTO.DetalleProductoDTO;
import com.webShop.back.modelo.Entidad.DetalleProducto;
import com.webShop.back.modelo.Entidad.Image;
import com.webShop.back.persistencia.DetalleProductoDAO;

@Service
public class DetalleProductoServices {

    @Autowired     
    private DetalleProductoDAO detalleProductoDAO;

    @Autowired
    private CloudinaryService cloudinaryService;

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
            return detalleProductoDAO.save(detalleProductoNuevo);
        } catch (Exception e) {
            System.out.println("Error al guardar el detalle del producto"+ e);
            return null;
        }
    }

    @Transactional
    public void guardarImagen(MultipartFile imagen1, MultipartFile imagen2, MultipartFile imagen3, Long productoId) {
        String folder = "detalleProducto";

        //Busqueda de producto que vamos a modificar
        DetalleProducto detalleProducto = detalleProductoDAO.findById(productoId)
            .orElseThrow(() -> new DataAccessException("Publication not found") {
        });
        
        Map result1 = cloudinaryService.upload(imagen1, folder);
        Map result2 = cloudinaryService.upload(imagen2, folder);
        Map result3 = cloudinaryService.upload(imagen3, folder);
        
        Image mainImage1 = new Image(result1.get("public_id").toString(), 
            result1.get("secure_url").toString());
        Image mainImage2 = new Image(result2.get("public_id").toString(), 
            result2.get("secure_url").toString());
        Image mainImage3 = new Image(result3.get("public_id").toString(), 
            result3.get("secure_url").toString());

        detalleProducto.setImagen1(mainImage1);
        detalleProducto.setImagen2(mainImage2);
        detalleProducto.setImagen3(mainImage3);
       
        detalleProductoDAO.save(detalleProducto);
    }
}
