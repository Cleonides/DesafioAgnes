import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

interface Toast {
  message: string;
  type: 'success' | 'error';
}

@Component({
  selector: 'app-toast-mensagem',
  templateUrl: './ToastMensagemComponent.html',
  standalone: true,
  imports: [FormsModule, CommonModule], // Adiciona o FormsModule aqui
  styleUrls: ['../assets/ToastMensagemComponent.css']
})

export class ToastMensagemComponent {
  toasts: Toast[] = [];

  showToast(message: string, type: 'success' | 'error') {
    this.toasts.push({ message, type });
    setTimeout(() => {
      this.toasts.shift();
    }, 3000);
  }

  removeToast(index: number) {
    this.toasts.splice(index, 1);
  }
}
