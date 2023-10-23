import React from "react";
import "../styles/PromoBox.css"


const PromoBox = ({ product }) => {  // Recibe product como una prop

    return(
        <a href="https://meiko.com.co/cdn/shop/files/4_576f1ab6-d06e-448f-9949-4d2e7f0aac02_1024x1024@2x.jpg?v=1685035230" target="_blank" rel="noopener noreferrer">
            <div className="PromoBox">

                <img src={product.imagenPrincipal} alt={product.nombre} className="promoBox__image" />
                <p className="promoBox__price">${product.precio}</p>
            </div>
        </a>
    )
}

export default PromoBox;
