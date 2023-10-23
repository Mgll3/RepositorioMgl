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
    //@Getter
    //private DetalleProductoDTO detalleProductoDTO;
    //Constructor sin id
    // public ProductoDTO(String nombre, int precio, String imagenPrincipal) {
    //     this.nombre = nombre;
    //     this.precio = precio;
    //     this.imagenPrincipal = imagenPrincipal;
    //     // this.detalleProductoDTO = detalleProductoDTO;
    // }
    //Constructor con id
    public ProductoDTO(Long idLong, String nombre, int precio, String imagenPrincipal) {
        this.id = idLong;
        this.nombre = nombre;
        this.precio = precio;
        this.imagenPrincipal = imagenPrincipal;
        // this.detalleProductoDTO = detalleProductoDTO;
    }
    public ProductoDTO() {
    }
    

}
