// src/services/AtividadeService.js
import axios from 'axios';
import { API_ATIVIDADE } from '../config/api';

class AtividadeService {

    listarAtividades() {
        return axios.get(API_ATIVIDADE) // Retorna a promessa
            .then(response => response.data) // Extrai os dados da resposta
            .catch(error => {
                console.error('Erro ao carregar os atividades:', error);
                throw error; // Lança o erro para ser tratado no componente
            });
    }

    listarAtividadesPorProjeto(idProjeto) {
        return axios.get(`${API_ATIVIDADE}/projeto/${idProjeto}`) // Retorna a promessa
            .then(response => response.data) // Extrai os dados da resposta
            .catch(error => {
                console.error('Erro ao carregar os atividades:', error);
                throw error; // Lança o erro para ser tratado no componente
            });
    }

    
    cadastrarAtividade(atividade) {
        return axios.post(API_ATIVIDADE, atividade) // Retorna a promessa
            .then(response => response.data) // Extrai os dados da resposta
            .catch(error => {
                console.error('Erro ao cadastrar atividade:', error);
                throw error; // Lança o erro para ser tratado no componente
            });
    }
}

export default new AtividadeService();
