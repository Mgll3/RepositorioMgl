import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { ProductService } from '../service/ProductService';

const ProductDetail = () => {
    const [product, setProduct] = useState(null);
    const { id } = useParams();
    const productService = new ProductService();

    useEffect(() => {
        productService.getById(id)
            .then(data => setProduct(data));
    }, [id, productService]);

    if (!product) return <div>Cargando...</div>;

    return (
        
        <div className="product-detail">
            <h1>holaaaaaaaaaaaaaaaaaaaaaaaaaaa</h1>
            <h1>{product.nombre}</h1>
            <img src={product.image} alt={product.name} />
            <p>Precio: ${product.precio}</p>
            
        </div>
    );
}

export default ProductDetail;
