package com.webShop.back.modelo.Entidad;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.webShop.back.modelo.DTO.DetalleProductoDTO;
@Entity
@Table(name = "detalle_producto")
public class DetalleProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name="inventario_id")
    private Inventario inventario;
    private String descripcion;
    private String caracteristicas;
    private String imagen1;
    private String imagen2;
    private String imagen3;
    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    //Constructores
    public DetalleProducto() {  
    }
    
    public DetalleProducto(Long id, Inventario inventario, String descripcion, String caracteristicas,
        String imagen1, String imagen2, String imagen3, Categoria categoria) {
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