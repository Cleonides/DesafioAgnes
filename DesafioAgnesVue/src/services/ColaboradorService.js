// src/services/ColaboradorService.js
import axios from 'axios';
import { API_COLABORADOR } from '../config/api';

class ColaboradorService {

    async listarColaboradores() {
        try {
            const response = await axios.get(API_COLABORADOR);
            return response.data;
        } catch (error) {
            console.error('Erro ao carregar os colaboradores:', error);
            throw error; 
        }
    }
    
    async cadastrarColaborador(colaborador) {
        try {
            const response = await axios.post(API_COLABORADOR, colaborador);
            return response.data;
        } catch (error) {
            console.error('Erro ao cadastrar colaborador:', error);
            throw error; 
        }
    }
}

export default new ColaboradorService();
