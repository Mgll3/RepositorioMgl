package com.webShop.back.modelo.Entidad;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.webShop.back.modelo.DTO.ProductoDTO;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int precio;
    @Column(name = "imagen_principal")
    private String imagenPrincipal;
    // @OneToOne(mappedBy = "detalleProducto", cascade = CascadeType.ALL)
    // private DetalleProducto detalleProducto;

    public ProductoDTO crearDto(Producto producto){
        return new ProductoDTO(producto.id, producto.nombre, producto.precio, producto.imagenPrincipal);
    }

    public List<ProductoDTO> crearListaDto(List<Producto> productos){
        List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
        for (Producto producto : productos) {
            productosDTO.add(new ProductoDTO(producto.id, producto.nombre, producto.precio, producto.imagenPrincipal));
        }
        return productosDTO;
    }

    public Producto(Long id, String nombre, int precio, String imagenPrincipal) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagenPrincipal = imagenPrincipal;
    }

    // public Producto(String nombre, int precio, String imagenPrincipal) {
    //     this.nombre = nombre;
    //     this.precio = precio;
    //     this.imagenPrincipal = imagenPrincipal;
    // }

    public Producto() {
    }

}
