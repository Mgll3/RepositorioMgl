package com.webShop.back.persistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import com.webShop.back.modelo.Entidad.CarritoCompras;

public interface ICarritoComprasDAO extends JpaRepository<CarritoCompras, Long> {
    
}
