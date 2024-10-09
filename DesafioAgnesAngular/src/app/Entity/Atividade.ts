import {Cliente} from './Cliente';
import {Projeto} from './Projeto';
import {Colaborador} from './Colaborador';

export interface Atividade {
  nome: string;
  descricao: string;
  status: string;
  projeto?: Projeto;
  colaborador?: Colaborador
}
