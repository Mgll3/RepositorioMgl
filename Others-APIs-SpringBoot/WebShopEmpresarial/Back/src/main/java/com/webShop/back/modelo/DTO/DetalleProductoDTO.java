package com.webShop.back.modelo.DTO;

import com.webShop.back.modelo.Entidad.Image;

import lombok.Getter;

public class DetalleProductoDTO {
    @Getter
    private Long id;
    @Getter 
    private InventarioDTO inventario;
    @Getter 
    private String descripcion;
    @Getter 
    private String caracteristicas;
    @Getter
    private Image imagen1;
    @Getter
    private Image imagen2;
    @Getter
    private Image imagen3;
    @Getter 
    private CategoriaDTO categoria;
    
    
    public DetalleProductoDTO(Long id, InventarioDTO inventario, String descripcion, String caracteristicas,
        Image imagen1, Image imagen2, Image imagen3, CategoriaDTO categoria) {
        this.id = id;
        this.inventario = inventario;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
        this.categoria = categoria;
    }


}
