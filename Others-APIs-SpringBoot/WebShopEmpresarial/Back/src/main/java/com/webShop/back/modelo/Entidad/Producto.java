package com.webShop.back.modelo.Entidad;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

import com.webShop.back.modelo.DTO.ProductoDTO;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int precio;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Image imagenPrincipal;
    @OneToOne
    private DetalleProducto detalleProducto;

    public Producto(Long id, String nombre, int precio, Image imagenPrincipal, DetalleProducto detalleProducto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagenPrincipal = imagenPrincipal;
        this.detalleProducto = detalleProducto;
    }

    public Producto() {
    }

    public Producto(ProductoDTO productoDTO) {
        this.id = productoDTO.getId();
        this.nombre = productoDTO.getNombre();
        this.precio = productoDTO.getPrecio();
        this.detalleProducto = new DetalleProducto(productoDTO.getDetalleProducto());
    }

    public ProductoDTO crearDto(){
        return new ProductoDTO(this.id, this.nombre, this.precio, 
        this.detalleProducto.crearDto());
    }

    public List<ProductoDTO> crearListaDto(List<Producto> productos){
        List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
        for (Producto producto : productos) {
            productosDTO.add(producto.crearDto());
        }
        return productosDTO;
    }
}
