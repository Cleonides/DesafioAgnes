// src/services/ProjetoService.js
import axios from 'axios';
import { API_PROJETO } from '../config/api';

class ProjetoService {

    listarProjetos() {
        return axios.get(API_PROJETO) // Retorna a promessa
            .then(response => response.data) // Extrai os dados da resposta
            .catch(error => {
                console.error('Erro ao carregar os projetos:', error);
                throw error; // Lança o erro para ser tratado no componente
            });
    }
    
    cadastrarProjeto(projeto) {
        return axios.post(API_PROJETO, projeto) // Retorna a promessa
            .then(response => response.data) // Extrai os dados da resposta
            .catch(error => {
                console.error('Erro ao cadastrar projeto:', error);
                throw error; // Lança o erro para ser tratado no componente
            });
    }

}

export default new ProjetoService();
