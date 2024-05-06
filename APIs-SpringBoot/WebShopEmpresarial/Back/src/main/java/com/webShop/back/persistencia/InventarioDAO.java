package com.webShop.back.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webShop.back.modelo.Entidad.Inventario;

public interface InventarioDAO extends JpaRepository<Inventario, Long>{
    
}
