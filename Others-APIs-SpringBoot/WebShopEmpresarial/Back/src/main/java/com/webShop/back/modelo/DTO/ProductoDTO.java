package com.webShop.back.modelo.DTO;

import com.webShop.back.modelo.Entidad.Image;

import lombok.Getter;

public class ProductoDTO{
    @Getter
    private Long id;
    @Getter
    private String nombre;
    @Getter
    private int precio;
    @Getter
    private DetalleProductoDTO detalleProducto;
    
    public ProductoDTO(Long id, String nombre, int precio, DetalleProductoDTO detalleProducto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.detalleProducto = detalleProducto;
    }
    
    public ProductoDTO() {
    }

    
    

}
