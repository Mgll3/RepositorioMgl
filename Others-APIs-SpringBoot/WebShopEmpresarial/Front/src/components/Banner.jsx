import React from "react";
import "../styles/Banner.css";

const Banner =({children})=>{

    return(
<div className="Banner ">
        <div className="Items">
            {children || <p></p>}
        </div>
</div>
    )
}


export default Banner;