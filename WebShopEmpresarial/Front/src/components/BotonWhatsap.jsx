import React from "react";
import "../styles/BotonWhatsap.css";

const BotonWhatsap = () => {
    const whatsappURL = "https://wa.me/573137266912?text=Hola,%20estoy%20interesado%20en%20sus%20productos.";

    return (
        <a href={whatsappURL} target="_blank" rel="noopener noreferrer">
            <button className="whatsapp-button">
                Chatear en WhatsApp
            </button>
        </a>
    );
}

export default BotonWhatsap;