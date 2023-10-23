package com.webShop.back.persistencia;

import org.springframework.data.repository.CrudRepository;

import com.webShop.back.modelo.Entidad.Producto;
//extends CrudRepository<Producto, Integer>
public interface IEntityDAO<T>  {
    // T buscarPorId(int id);
    // List<T> buscarTodos();
    // void guardar(T producto);
    // void actualizar(T producto);
    // void eliminar(T producto);
}
