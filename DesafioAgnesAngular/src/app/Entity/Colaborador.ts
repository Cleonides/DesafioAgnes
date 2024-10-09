import {Projeto} from './Projeto';

export interface Colaborador {
  nome: string;
  cargo: string;
  projeto?: Projeto;
}
