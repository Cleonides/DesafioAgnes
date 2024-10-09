// src/app/projeto/ProjetoComponent.ts
import {Component, OnInit, ViewChild} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import {ProjetoService} from '../services/ProjetoService';
import {ClienteService} from '../services/ClienteService';
import {AtividadeService} from '../services/AtividadeService';
import {Projeto} from '../Entity/Projeto';
import {Cliente} from '../Entity/Cliente';
import {Atividade} from '../Entity/Atividade';
import {ToastMensagemComponent} from './ToastMensagemComponent';

@Component({
  selector: 'app-root',
  templateUrl: 'ProjetoList.html',
  standalone: true,
  imports: [FormsModule, CommonModule, ToastMensagemComponent], // Adiciona o FormsModule aqui
  styleUrls: ['../assets/ProjetoComponent.css'],
})

export class ProjetoComponent implements OnInit {
  projetos: Projeto[] = []; // Array para armazenar os projetos
  nome: string = ''; // Campo para o nome do projetos
  descricao: string = ''; // Campo para o cargo do projetos
  error: string | null = null;// Variável para armazenar mensagens de erro
  clientes : Cliente[] = [];
  clienteSelecionado: Cliente | undefined = undefined; // Armazena o cliente selecionado
  atividades: Atividade[] = []; // Array para armazenar os atividades

  @ViewChild(ToastMensagemComponent) toastMensagem!: ToastMensagemComponent;

  mostrarSucesso() {
    this.toastMensagem.showToast('Projeto cadastrado com sucesso!', 'success');
  }

  constructor(private projetoService :ProjetoService,
              private clienteService:ClienteService,
              private atividadeService:AtividadeService) {}

  ngOnInit() {
    this.listarProjetos();
    this.clienteService.listarClientes().subscribe((data) => {
      this.clientes = data;
    });
  }

  listarProjetos() {
    this.projetoService.listarProjetos().subscribe(
      (data) => {
      this.projetos = data;
        console.log(data)
    },
    (error) => {
      console.error('Erro ao carregar projetos:', error);
    });
  }

  cadastrarProjeto() {
    // @ts-ignore
    const novoProjeto: Projeto = {
      nome: this.nome,
      descricao: this.descricao,
      cliente: this.clienteSelecionado
    };

    this.projetoService.cadastrarProjeto(novoProjeto).subscribe(
      () => {
        this.listarProjetos(); // Recarrega a lista de projetos após cadastro
        this.nome = ''; // Limpa o campo nome
        this.descricao = ''; // Limpa o campo cargo
        this.mostrarSucesso();
      },
      (error => {
        console.error('Erro ao cadastrar projeto:', error);
      }));
  }

  listarAtividadesPorProjeto(id: any) {
    this.atividadeService.listarAtividadesPorProjeto(id).subscribe((data) => {
      this.atividades = data;
    });
  }
}
