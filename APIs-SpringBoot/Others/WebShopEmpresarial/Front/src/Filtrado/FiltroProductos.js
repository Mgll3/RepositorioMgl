import React, { useState } from 'react';

function FiltroProductos() {
  const [categoriasSeleccionadas, setCategoriasSeleccionadas] = useState([]);

  // Función para manejar la selección/deselección de categorías
  const handleCategoriaChange = (categoria) => {
    if (categoriasSeleccionadas.includes(categoria)) {
      // Si ya está seleccionada, quitarla
      setCategoriasSeleccionadas(categoriasSeleccionadas.filter((c) => c !== categoria));
    } else {
      // Si no está seleccionada, agregarla
      setCategoriasSeleccionadas([...categoriasSeleccionadas, categoria]);
    }
  };

  // Renderizar la lista de checkboxes con categorías
  const renderCategorias = () => {
    const categorias = ['Electrónica', 'Ropa', 'Hogar', 'Deportes']; // Reemplaza con tus categorías reales

    return categorias.map((categoria) => (
      <div key={categoria}>
        <input
          type="checkbox"
          id={categoria}
          value={categoria}
          checked={categoriasSeleccionadas.includes(categoria)}
          onChange={() => handleCategoriaChange(categoria)}
        />
        <label htmlFor={categoria}>{categoria}</label>
      </div>
    ));
  };

  return (
    <div className="FiltroProductos">
      {/* Encabezado y navegación (reutilizados del componente App) */}
      {/* ... */}

      {/* Contenido del filtro de productos */}
      <div className="filtro-contenedor">
        <h2>Filtrar por categoría</h2>
        {renderCategorias()}
      </div>
    </div>
  );
}

export default FiltroProductos;
