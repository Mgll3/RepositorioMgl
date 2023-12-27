package com.webShop.back.modelo.Entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.webShop.back.modelo.DTO.CategoriaDTO;

import java.util.Set;

import lombok.Getter;

@Entity 
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(mappedBy = "categoria")
    private Set<DetalleProducto> detalleProducto;

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
