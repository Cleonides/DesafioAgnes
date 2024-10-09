import {Cliente} from './Cliente';

export interface Projeto {
  id : bigint
  nome: string;
  descricao: string;
  status: string;
  cliente?: Cliente;
}
