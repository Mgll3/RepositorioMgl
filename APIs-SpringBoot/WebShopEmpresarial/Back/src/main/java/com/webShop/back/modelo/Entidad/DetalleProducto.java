package com.webShop.back.modelo.Entidad;


import jakarta.persistence.*;

import com.webShop.back.modelo.DTO.DetalleProductoDTO;

import lombok.Data;

@Entity
@Data
@Table(name = "detalle_producto")
public class DetalleProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String caracteristicas;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Image imagen1;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Image imagen2;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Image imagen3;
    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;
    @JoinColumn(name="inventario_id")
    @OneToOne
    private Inventario inventario;
    

    //Constructores
    public DetalleProducto() {  
    }
    
    public DetalleProducto(Long id, Inventario inventario, String descripcion, String caracteristicas,
        Image imagen1, Image imagen2, Image imagen3, Categoria categoria) {
        this.id = id;
        this.inventario = inventario;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
        this.categoria = categoria;
    }

    public DetalleProducto(DetalleProductoDTO detalleProductoDTO){
        this.id = detalleProductoDTO.getId();
        this.inventario = new Inventario(detalleProductoDTO.getInventario());
        this.descripcion = detalleProductoDTO.getDescripcion();
        this.caracteristicas = detalleProductoDTO.getCaracteristicas();
        this.imagen1 = detalleProductoDTO.getImagen1();
        this.imagen2 = detalleProductoDTO.getImagen2();
        this.imagen3 = detalleProductoDTO.getImagen3();
        this.categoria = new Categoria(detalleProductoDTO.getCategoria());
    }

    public DetalleProductoDTO crearDto(){
        return new DetalleProductoDTO(this.id, this.inventario.crearDto(), 
        this.descripcion, this.caracteristicas, this.imagen1, this.imagen2, this.imagen3, 
        this.categoria.crearDto());
    }  
}