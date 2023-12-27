package com.webShop.back.modelo.DTO;

import lombok.Getter;

public class ProductoDTO{
    @Getter
    private Long id;
    @Getter
    private String nombre;
    @Getter
    private int precio;
    @Getter
    private String imagenPrincipal;
    @Getter
    private DetalleProductoDTO detalleProducto;
    
    public ProductoDTO(Long id, String nombre, int precio, String imagenPrincipal, DetalleProductoDTO detalleProducto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagenPrincipal = imagenPrincipal;
        this.detalleProducto = detalleProducto;
    }

    
    public ProductoDTO() {
    }

    
    

}
