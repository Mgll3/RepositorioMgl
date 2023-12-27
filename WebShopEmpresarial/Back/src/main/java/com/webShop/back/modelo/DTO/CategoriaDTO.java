package com.webShop.back.modelo.DTO;


import lombok.Getter;

public class CategoriaDTO {
    
    @Getter
    private Long id;
    @Getter
    private String nombre;



    public CategoriaDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public CategoriaDTO() {
    }

    
}
