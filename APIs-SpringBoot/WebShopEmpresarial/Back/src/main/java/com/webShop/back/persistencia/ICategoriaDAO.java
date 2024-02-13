package com.webShop.back.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webShop.back.modelo.Entidad.Categoria;


public interface ICategoriaDAO extends JpaRepository<Categoria, Long>{
    
}
