// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router';
import ClienteList from '../components/ClienteList.vue'; // Componente da página do cliente
import ColaboradorList from '../components/ColaboradorList.vue'; // Componente da página do Colaborador
import ProjetoList from '../components/ProjetoList.vue'; // Componente da página do Projeto
import AtividadeList from '../components/AtividadeList.vue'; // Componente da página do Atividade

const routes = [
  {
    path: '/cliente',
    name: 'ClienteList',
    component: ClienteList,
  },
  {
    path: '/colaborador',
    name: 'ColaboradorList',
    component: ColaboradorList,
  },
  {
      path: '/projeto',
      name: 'ProjetoList',
      component: ProjetoList,
  },
  {
      path: '/atividade',
      name: 'AtividadeList',
      component: AtividadeList,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
