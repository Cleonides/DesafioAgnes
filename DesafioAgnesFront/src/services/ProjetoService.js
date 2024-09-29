// src/services/ProjetoService.js
import axios from 'axios';
import { API_PROJETO } from '../config/api';

class ProjetoService {

    async listarProjetos() {
        try {
            const response = await axios.get(API_PROJETO);
            return response.data;
        } catch (error) {
            console.error('Erro ao carregar os projetos:', error);
            throw error; 
        }
    }
    
    async cadastrarProjeto(projeto) {
        try {
            const response = await axios.post(API_PROJETO, projeto);
            return response.data;
        } catch (error) {
            console.error('Erro ao cadastrar projeto:', error);
            throw error; 
        }
    }

}

export default new ProjetoService();
