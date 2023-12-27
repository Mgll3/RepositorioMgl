
import React from "react";
import "../styles/Logo.css";
import LogoImage from "../images/Logo.png"

const Logo =()=>{
    return(

        <div className="contenedor-Logo">
        
        <img src={LogoImage} alt="Logo de la tienda" className="Logo" />
        </div>
    )
}

export default Logo;


//https://drive.google.com/uc?export=view&id=1p7kcp7_11nRzouhOTXD9HdOIUmX66FBG