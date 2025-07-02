import axios from 'axios';
axios.defaults.baseURL = 'http://localhost:8080/api';

class HttpService {

    async save(jsonBody) {
        const res = await axios.post('/memo',jsonBody);
        return res.data;
    } 
    async findAll(params){
        const res = await axios.get('/memo', {params});
        return res.data;
    }
    async findById(id){
        const res = await axios.get(`/memo/${id}`);
        return res.data;
    }
}

export default new HttpService();