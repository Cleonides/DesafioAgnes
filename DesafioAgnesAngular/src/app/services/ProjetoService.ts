// src/services/cliente.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_PROJETO } from '../config/apis';

@Injectable({
  providedIn: 'root',
})

export class ProjetoService {
  constructor(private http: HttpClient) {}

  listarProjetos(): Observable<any[]> {
    return this.http.get<any[]>(API_PROJETO);
  }

  cadastrarProjeto(projeto: any): Observable<any> {
    return this.http.post<any>(API_PROJETO, projeto);
  }
}
