package com.webShop.back.persistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import com.webShop.back.modelo.Entidad.DetallePedido;

public interface IDetallePedidoDAO extends JpaRepository<DetallePedido, Long> {
    
}