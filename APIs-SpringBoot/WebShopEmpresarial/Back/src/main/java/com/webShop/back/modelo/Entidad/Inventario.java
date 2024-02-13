package com.webShop.back.modelo.Entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.webShop.back.modelo.DTO.InventarioDTO;


@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "inventario")
    private DetalleProducto detalleProducto;
    private int cantidad;

    public Inventario(InventarioDTO inventarioDTO) {
        this.id = inventarioDTO.getId();
        this.cantidad = inventarioDTO.getCantidad();
    }

    public Inventario(Long id,  int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Inventario() {
    }

    public InventarioDTO crearDto(){
        return new InventarioDTO(this.id,  this.cantidad);
    }
}
