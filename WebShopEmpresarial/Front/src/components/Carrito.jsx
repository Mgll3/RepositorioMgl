import React from "react";
import "../styles/Carrito.css";
import CarrritoImage from "../images/carrito2.png"

const Carrito =()=>{
    return(

        <div className="Carrito">
        
            <button className="Boton">
                <img src={CarrritoImage} alt="Descripción de la imagen" className="Image" />
            </button>
        </div>
    )
}

export default Carrito;