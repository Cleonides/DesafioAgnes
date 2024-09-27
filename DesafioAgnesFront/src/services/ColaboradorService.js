// src/services/ColaboradorService.js
import axios from 'axios';
import { API_COLABORADOR } from '../config/api';

class ColaboradorService {

    listarColaboradores() {
        return axios.get(API_COLABORADOR) // Retorna a promessa
            .then(response => response.data) // Extrai os dados da resposta
            .catch(error => {
                console.error('Erro ao carregar os colaboradores:', error);
                throw error; // Lança o erro para ser tratado no componente
            });
    }
    
    cadastrarColaborador(colaborador) {
        return axios.post(API_COLABORADOR, colaborador) // Retorna a promessa
            .then(response => response.data) // Extrai os dados da resposta
            .catch(error => {
                console.error('Erro ao cadastrar colaborador:', error);
                throw error; // Lança o erro para ser tratado no componente
            });
    }
}

export default new ColaboradorService();
