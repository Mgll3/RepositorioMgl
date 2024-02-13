import axios from "axios";

export class ProductService {

    baseUrl = "http://localhost:8080/producto/";

    getAll() {
        return axios.get(this.baseUrl + "buscar" ).then(res => res.data);
    }

    getById(id) {
        return axios.get(this.baseUrl + id).then(res => res.data);
    }
}
