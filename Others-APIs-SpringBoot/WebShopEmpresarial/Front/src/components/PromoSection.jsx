import React, { Component } from "react";
import PromoBox from "./PromoBox";
import "../styles/PromoSection.css"
import { ProductService } from '../service/ProductService';

class PromoSection extends Component{
    constructor(){
        super();
        this.state = {
            products: []
        };
        this.ProductService = new ProductService();
    }
    
    componentDidMount(){
        this.ProductService.getAll().then(data => this.setState({products: data}))
    }

    render(){
        var products = this.state.products;
        return (
            <div className="PromoSection debug">
                <h1 className="promoTitle">Productos en Promoción y Nuevos</h1>
                <div className="promoProducts">
                {products.map(product => (
                        <PromoBox key={product.id} product={product} />
                    ))}
                   
                </div>
            </div>
        );
    }
}

export default PromoSection;