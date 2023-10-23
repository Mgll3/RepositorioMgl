package com.webShop.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackApplication.class, args);
        // IEntityDAO<ProductoDTO> productoDAO = new ProductoDAO();
        // productoDAO = new ProductoDAO();
        // IProductoDAO productoDAO=context.getBean(IProductoDAO.class);

    }

    //Terminar los modelos como en el diagrama
    //Terminar los controladores y servicios solo del Producto
    //Dto al Producto
    //Inyeccion de dependencias 
    //DAO al Producto
    //Crear base de datos del Producto
    //TODO: Crear base de datos para DetallerProducto y con conexion Producto 
    //TODO: Principio inversion de dependencias, hacer un dao o con adapter, que 
    //TODO: Al mostrar productos de tal categoria si X producto esta en 0 no traerlo
    //TODO: Singleton al carrito de compras
    //TODO: Quitar getter y setters si se necesita el atributo entonces por medio de una funcion dentro de la clase hacer lo necesario y devolver lo que se pida, ejemplo calcular cumpleaños, en vez de mandar el cumpleaños con un getter directamente lo calculamos en la clase para que así no tenga que salir esa información por fuera, solo se va devolver el resultado no la información
    
    

    
    

}
