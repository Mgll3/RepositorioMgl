package com.webShop.back.modelo.Entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.webShop.back.modelo.DTO.DetallePedidoDTO;


@Entity 
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Producto producto;
    private int cantidad;
    private double precioPonderado;

    public DetallePedido(long id, Producto producto, int cantidad, double precioPonderado) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioPonderado = precioPonderado;
    }

    public DetallePedido(DetallePedidoDTO detallePedidoDTO) {
        this.id = detallePedidoDTO.getId();
        this.producto = new Producto(detallePedidoDTO.getProducto());
        this.cantidad = detallePedidoDTO.getCantidad();
        this.precioPonderado = detallePedidoDTO.getPrecioPonderado();

    }

    public DetallePedido() {
    }

    public DetallePedidoDTO crearDto(){
        return new DetallePedidoDTO(this.id, this.producto.crearDto(), this.cantidad, this.precioPonderado);
    }

    public List<DetallePedidoDTO> crearListaDto(List<DetallePedido> detallePedidos){
        List<DetallePedidoDTO> detallePedidosDTO = new ArrayList<DetallePedidoDTO>();
        for (DetallePedido detallePedido : detallePedidos) {
            detallePedidosDTO.add(detallePedido.crearDto());
        }
        return detallePedidosDTO;
    }


}
