package com.webShop.back.modelo.Entidad;



import com.webShop.back.modelo.DTO.CategoriaDTO;

import jakarta.persistence.*;

import java.util.Set;

import lombok.Getter;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    private String nombre;

    public Categoria(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Categoria() {
    }

    public Categoria(CategoriaDTO categoriaDTO) {
        this.id = categoriaDTO.getId();
        this.nombre = categoriaDTO.getNombre();
    }

    public CategoriaDTO crearDto(){
        return new CategoriaDTO(this.id, this.nombre);
    }

}
