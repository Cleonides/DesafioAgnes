// src/services/ClienteService.js
import axios from 'axios';
import { API_CLIENTE } from '../config/api';

class ClienteService {

    async listarClientes() {
        try {
            const response = await axios.get(API_CLIENTE);  
            return response.data;
        } catch (error) {
            console.error('Erro ao carregar clientes:', error);
            throw error;  
        }
    }
    
    async cadastrarCliente(cliente) {
        try {
            const response = await axios.post(API_CLIENTE, cliente);  
            return response.data;
        } catch (error) {
            console.error('Erro ao cadastrar cliente:', error);
            throw error;  
        }
    }
}

export default new ClienteService();
