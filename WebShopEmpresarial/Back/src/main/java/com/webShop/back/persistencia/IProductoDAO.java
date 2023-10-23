package com.webShop.back.persistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import com.webShop.back.modelo.Entidad.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Long> {
    //interfaz para agregar lo que necesite de más el ProductoDao que no tenga Entity DAO(la general)
    
    
    
}
