package com.webShop.back.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import com.webShop.back.modelo.Entidad.DetalleProducto;

public interface DetalleProductoDAO extends JpaRepository<DetalleProducto, Long> {
    
}
