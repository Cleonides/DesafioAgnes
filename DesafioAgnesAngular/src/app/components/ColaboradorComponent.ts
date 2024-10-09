// src/app/colaborador/ColaboradorComponent.ts
import {Component, OnInit, ViewChild} from '@angular/core';
import {ColaboradorService} from '../services/ColaboradorService';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import {Colaborador} from '../Entity/Colaborador';
import {ToastMensagemComponent} from './ToastMensagemComponent';

// @ts-ignore
@Component({
  selector: 'app-root',
  templateUrl: 'ColaboradorList.html',
  standalone: true,
  imports: [FormsModule, CommonModule, ToastMensagemComponent], // Adiciona o FormsModule aqui
  styleUrls: ['../assets/ColaboradorComponent.css'],
})

export class ColaboradorComponent implements OnInit {
  colaboradores: Colaborador[] = []; // Array para armazenar os colaboradores
  nome: string = ''; // Campo para o nome do colaborador
  cargo: string = ''; // Campo para o cargo do colaborador
  error: string | null = null;// Variável para armazenar mensagens de erro

  @ViewChild(ToastMensagemComponent) toastMensagem!: ToastMensagemComponent;

  mostrarSucesso() {
    this.toastMensagem.showToast('Colaborador cadastrado com sucesso!', 'success');
  }

  constructor(private colaboradorService :ColaboradorService) {}

  ngOnInit() {
    this.listarColaboradores();
  }

  listarColaboradores() {
    this.colaboradorService.listarColaboradores().subscribe(
      (data) => {
      this.colaboradores = data;
    },
    (error) => {
      console.error('Erro ao carregar clientes:', error);
    });
  }

  cadastrarColaborador() {
    const novoColaborador: Colaborador = {
      nome: this.nome,
      cargo: this.cargo
    };

    this.colaboradorService.cadastrarColaborador(novoColaborador).subscribe(
      () => {
        this.listarColaboradores(); // Recarrega a lista de colaboradores após cadastro
        this.nome = ''; // Limpa o campo nome
        this.cargo = ''; // Limpa o campo cargo
        this.mostrarSucesso();
      },
      (error => {
        console.error('Erro ao cadastrar colaborador:', error);
      }));
  }

}
