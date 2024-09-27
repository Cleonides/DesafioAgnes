// src/services/ClienteService.js
import axios from 'axios';
import { API_CLIENTE } from '../config/api';

class ClienteService {

    listarClientes() {
        return axios.get(API_CLIENTE) // Retorna a promessa
            .then(response => response.data) // Extrai os dados da resposta
            .catch(error => {
                console.error('Erro ao carregar clientes:', error);
                throw error; // Lança o erro para ser tratado no componente
            });
    }
    
    cadastrarCliente(cliente) {
        return axios.post(API_CLIENTE, cliente) // Retorna a promessa
            .then(response => response.data) // Extrai os dados da resposta
            .catch(error => {
                console.error('Erro ao cadastrar cliente:', error);
                throw error; // Lança o erro para ser tratado no componente
            });
    }
}

export default new ClienteService();
