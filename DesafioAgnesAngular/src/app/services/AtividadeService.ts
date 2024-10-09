// src/services/atividade.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import { API_ATIVIDADE } from '../config/apis';

@Injectable({
  providedIn: 'root',
})
export class AtividadeService {
  constructor(private http: HttpClient) {}

  listarAtividades(): Observable<any[]> {
    return this.http.get<any[]>(API_ATIVIDADE);
  }

  listarAtividadesPorProjeto(idProjeto: string): Observable<any> {
    return this.http.get(`${API_ATIVIDADE}/projeto/${idProjeto}`).pipe(
      catchError(error => {
        console.error('Erro ao carregar as atividades:', error);
        return throwError(error);
      })
    );
  }

  cadastrarAtividade(atividade: any): Observable<any> {
    return this.http.post<any>(API_ATIVIDADE, atividade);
  }
}
