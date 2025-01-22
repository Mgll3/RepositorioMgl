import React from "react";
import "../styles/BotonWhatsap.css";
import Whatsapp from "../images/Whatsap.png"

const BotonWhatsap = () => {
    const whatsappURL = "https://wa.me/573137266912?text=Hola,%20estoy%20interesado%20en%20sus%20productos.";

    return (
        <a href={whatsappURL} target="_blank" rel="noopener noreferrer">
            <button className="whatsapp-button">
                <img src={Whatsapp} alt="Descripción de la imagen" className="Image" />
                
            </button>
        </a>
    );
}

export default BotonWhatsap;