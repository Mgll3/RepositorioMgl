import { Link } from 'react-router-dom';
import "../styles/PromoBox.css";

const PromoBox = ({ product }) => {
    return (
        <Link to={`/${product.id}`}>
            <div className="PromoBox">

                <img src={product.imagenPrincipal} alt={product.nombre} className="promoBox__image" />
                <p className="promoBox__price">${product.precio}</p>
            </div>
        </Link>
    );
}   

export default PromoBox;
