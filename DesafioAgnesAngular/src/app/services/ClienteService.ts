// src/services/cliente.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_CLIENTE } from '../config/apis';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  constructor(private http: HttpClient) {}

  listarClientes(): Observable<any[]> {
    return this.http.get<any[]>(API_CLIENTE);
  }

  cadastrarCliente(cliente: any): Observable<any> {
    return this.http.post<any>(API_CLIENTE, cliente);
  }
}
