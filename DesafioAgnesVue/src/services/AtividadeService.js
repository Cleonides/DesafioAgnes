// src/services/AtividadeService.js
import axios from 'axios';
import { API_ATIVIDADE } from '../config/api';

class AtividadeService {

    async listarAtividades() {
        try {
            const response = await axios.get(API_ATIVIDADE);  
            return response.data;
        } catch (error) {
            console.error('Erro ao carregar os atividades:', error);
            throw error;  
        }
    }

    async listarAtividadesPorProjeto(idProjeto) {
        try {
            const response = await axios.get(`${API_ATIVIDADE}/projeto/${idProjeto}`);  
            return response.data;
        } catch (error) {
            console.error('Erro ao carregar os atividades:', error);
            throw error; 
        }
    }

    
    async cadastrarAtividade(atividade) {
        try {
            const response = await axios.post(API_ATIVIDADE, atividade) 
            return response.data;
        } catch (error) {
            console.error('Erro ao cadastrar atividade:', error);
            throw error;  
        }
    }
}

export default new AtividadeService();
