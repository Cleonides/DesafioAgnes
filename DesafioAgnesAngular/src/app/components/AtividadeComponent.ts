// src/app/projeto/ProjetoComponent.ts
import {Component, OnInit, ViewChild} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import {ProjetoService} from '../services/ProjetoService';
import {AtividadeService} from '../services/AtividadeService';
import {Projeto} from '../Entity/Projeto';
import {ColaboradorService} from '../services/ColaboradorService';
import {Atividade} from '../Entity/Atividade';
import {Colaborador} from '../Entity/Colaborador';
import {ToastMensagemComponent} from './ToastMensagemComponent';

@Component({
  selector: 'app-root',
  templateUrl: 'AtividadeList.html',
  standalone: true,
  imports: [FormsModule, CommonModule, ToastMensagemComponent],
  styleUrls: ['../assets/AtividadeComponent.css'],
})

export class AtividadeComponent implements OnInit {
  atividades: Atividade[] = [];
  projetos: Projeto[] = []; // Array para armazenar os projetos
  colaboradores: Colaborador[] = [];
  nome: string = ''; // Campo para o nome do projetos
  descricao: string = ''; // Campo para o cargo do projetos
  error: string | null = null;// Variável para armazenar mensagens de erro
  projetoSelecionado: Projeto | undefined = undefined; // Armazena o projeto selecionado
  colaboradorSelecionado: Colaborador | undefined = undefined;

  @ViewChild(ToastMensagemComponent) toastMensagem!: ToastMensagemComponent;

  mostrarSucesso() {
    this.toastMensagem.showToast('Atividade cadastrada com sucesso!', 'success');
  }

  constructor(private atividadeService: AtividadeService,
              private projetoService :ProjetoService,
              private colaboradorService: ColaboradorService) {}

  ngOnInit() {
    this.listarAtividades(); // Chama o método para listar atividades
    this.colaboradorService.listarColaboradores().subscribe((data) => {
      this.colaboradores = data;
    });
    this.projetoService.listarProjetos().subscribe((data) => {
      this.projetos = data;
    });
  }

  listarAtividades() {
    this.atividadeService.listarAtividades().subscribe((data) => {
        this.atividades = data;
        console.log(data)
      },
      (error) => {
        console.error('Erro ao carregar atividades:', error);
      });
  }

  listarAtividadesPorProjeto(idProjeto: any) {
    this.atividadeService.listarAtividadesPorProjeto(idProjeto).subscribe(
      (data) => {
        this.atividades = data;
      },
      (error) => {
        console.error('Erro ao carregar atividades:', error);
      }
    );
  }

  cadastrarAtividade() {
    // @ts-ignore
    const novaAtividade: Atividade = {
      nome: this.nome,
      descricao: this.descricao,
      projeto: this.projetoSelecionado,
      colaborador : this.colaboradorSelecionado
    };

    this.atividadeService.cadastrarAtividade(novaAtividade).subscribe(
      () => {
        this.listarAtividades(); // Recarrega a lista de atividades após cadastro
        this.nome = ''; // Limpa o campo nome
        this.descricao = ''; // Limpa o campo descricao
        this.projetoSelecionado = undefined; // Armazena o projeto selecionado
        this.colaboradorSelecionado = undefined; // Armazena o colaborador selecionado
        this.mostrarSucesso();
      },
      (error => {
        console.error('Erro ao cadastrar projeto:', error);
      }));
  }




}
