import React, { Component } from "react";
import PromoBox from "./PromoBox";
import "../styles/PromoSection.css"
import { ProductService } from '../service/ProductService';

class PromoSection extends Component{

    constructor(){
        super();
        this.state = {};
        this.ProductService = new ProductService();
        this.products = []
        this.ProductService.getAll().then(data => this.products.push(data))
      }
    
      componentDidMount(){
        this.ProductService.getAll().then(data => this.setState({productos: data}))
        console.log(this.products)
      }


    render(){

        return (
            <div className="PromoSection">
                <h1 className="promoTitle">Productos en Promoción y Nuevos</h1>
                    <div className="promoProducts">
                    {this.products.map(product => (
                        <PromoBox key={product.id} product={product} />
                    ))}
                </div>
            </div>
        );
    }
};
export default PromoSection;