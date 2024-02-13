package com.webShop.back.modelo.DTO;

import lombok.Getter;

public class DetallePedidoDTO {
    @Getter
    private long id;
    @Getter
    private ProductoDTO producto;
    @Getter
    private int cantidad;
    @Getter
    private double precioPonderado;

    public DetallePedidoDTO(long id, ProductoDTO producto, int cantidad, double precioPonderado) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioPonderado = precioPonderado;
    }

    public DetallePedidoDTO() {
    }
    
}
