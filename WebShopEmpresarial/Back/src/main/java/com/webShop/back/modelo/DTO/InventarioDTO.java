package com.webShop.back.modelo.DTO;

import lombok.Getter;
import lombok.Setter;

public class InventarioDTO {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private int cantidad;

    public InventarioDTO(Long id,  int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }
}
