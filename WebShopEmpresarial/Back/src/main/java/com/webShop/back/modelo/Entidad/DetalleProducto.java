package com.webShop.back.modelo.Entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


// @Entity
// public class DetalleProducto {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     // private Inventario inventario;
//     private String descripcion;
//     private String caracteristicas;
//     @ElementCollection
//     @CollectionTable(name = "imagenes", joinColumns = @JoinColumn(name = "imagen_id"))
//     @Column(name = "lista_imagenes")
//     private List<String> listaImagenes;
//     @OneToOne(mappedBy = "detalleProducto")
//     private Categoria categoria;

//     //Constructores
//     public DetalleProducto() {
//     }
    
//     public DetalleProducto(Long id, String descripcion, String caracteristicas,
//             List<String> listaImagenes, Producto producto) {
//         this.id = id;
//         // this.inventario = inventario;
//         this.descripcion = descripcion;
//         this.caracteristicas = caracteristicas;
//         this.listaImagenes = listaImagenes;
//     }
// }