import axios from "axios";

export class ProductService{

    baseUrl = "http://localhost:8080/producto/";

    getAll(){
        return axios.get(this.baseUrl + "buscar").then(res => res.data);
    baseUrl = "";

    getAll(){
        return axios.get(this.baseUrl + "all").then(res => res.data);
    }
}