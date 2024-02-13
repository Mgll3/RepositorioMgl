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


    //TODO: Posible union con front:
    //TODO: HAcer que solamente me envien los productos para agregar al carrito
    

}
