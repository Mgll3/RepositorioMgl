package com.webShop.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webShop.back.modelo.Entidad.CarritoCompras;
import com.webShop.back.persistencia.ICarritoComprasDAO;

@Service
public class CarritoComprasServices {
    
    @Autowired
    private ICarritoComprasDAO IcarritoComprasDAO;
    private CarritoCompras carritoCompras = CarritoCompras.getCarritoCompras();

    public CarritoCompras guardarCarritoCompras(CarritoCompras carritoCompras) {
        try {
            return IcarritoComprasDAO.saveAndFlush(carritoCompras);
        } catch (Exception e) {
            System.out.println("Error al guardar el carritoCompras"+ e);
            return null;
        }   
    }

    public CarritoCompras buscar() {
        try {
            return IcarritoComprasDAO.findById(1L).get();
        } catch (Exception e) {
            System.out.println("Error al buscar el carritoCompras"+ e);
            return null;
        }
    }



}
