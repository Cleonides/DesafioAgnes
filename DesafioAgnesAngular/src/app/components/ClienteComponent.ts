// src/app/cliente/ClienteComponent.ts
import {Component, OnInit, ViewChild} from '@angular/core';
import { ClienteService } from '../services/ClienteService';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import {Cliente} from '../Entity/Cliente';
import {ToastMensagemComponent} from './ToastMensagemComponent';

// @ts-ignore
@Component({
  selector: 'app-root',
  templateUrl: 'ClienteList.html',
  standalone: true,
  imports: [FormsModule, CommonModule, ToastMensagemComponent], // Adiciona o FormsModule aqui
  styleUrls: ['../assets/ClienteComponent.css'],
})

export class ClienteComponent implements OnInit {
  clientes: Cliente[] = [];
  nome: string = '';
  descricao: string = ''; // Adiciona o FormsModule aqui
  error: string | null = null;

  @ViewChild(ToastMensagemComponent) toastMensagem!: ToastMensagemComponent;

  mostrarSucesso() {
    this.toastMensagem.showToast('Cliente cadastrado com sucesso!', 'success');
  }

  constructor(private clienteService: ClienteService) {}

  ngOnInit(): void {
    this.listarClientes();
  }

  listarClientes() {
    this.clienteService.listarClientes().subscribe(
      (data) => {
        this.clientes = data;
      },
      (error) => {
        console.error('Erro ao carregar clientes:', error);
      }
    );
  }

  cadastrarCliente() {
    const novoCliente: Cliente = {
      nome: this.nome,
      descricao: this.descricao,
    };

    this.clienteService.cadastrarCliente(novoCliente).subscribe(
      () => {
        this.listarClientes();
        this.nome = '';
        this.descricao = '';
        this.mostrarSucesso();
      },
      (error) => {
        // this.mostrarErro();
        console.error('Erro ao cadastrar cliente:', error);
      }
    );
  }
}
