import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {API_COLABORADOR} from '../config/apis';

@Injectable({
  providedIn: 'root',
})

export class ColaboradorService{
  constructor(private http:HttpClient) {}

  listarColaboradores(): Observable<any> {
    return this.http.get<any[]>(API_COLABORADOR);
  }

  cadastrarColaborador(colaborador: any):Observable<any>{
    return this.http.post<any>(API_COLABORADOR, colaborador);
  }
}
