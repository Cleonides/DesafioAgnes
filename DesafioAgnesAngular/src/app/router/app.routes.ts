import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteComponent } from '../components/ClienteComponent'; // Certifique-se de ajustar o caminho
import { ColaboradorComponent } from '../components/ColaboradorComponent'; // Ajuste o caminho
import { ProjetoComponent } from '../components/ProjetoComponent'; // Ajuste o caminho
import { AtividadeComponent } from '../components/AtividadeComponent';
import {InicioComponent} from '../components/InicioComponent'; // Ajuste o caminho

export const routes: Routes = [
  { path: '', component: InicioComponent }, // Redireciona para a página de clientes por padrão
  { path: 'cliente', component: ClienteComponent },
  { path: 'colaborador', component: ColaboradorComponent },
  { path: 'projeto', component: ProjetoComponent },
  { path: 'atividade', component: AtividadeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutes { }
