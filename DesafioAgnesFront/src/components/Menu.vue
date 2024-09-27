<template>
  <div>
    <!-- Menu Superior -->
    <div class="menu-container p-3 border-bottom shadow-sm bg-white d-flex gap-2">
      <router-link to="/" class="btn btn-primary">Início</router-link>
      <router-link to="/cliente" class="btn btn-primary">Cliente</router-link>
      <router-link to="/colaborador" class="btn btn-primary">Colaborador</router-link>
      <router-link to="/projeto" class="btn btn-primary">Projeto</router-link>
      <router-link to="/atividade" class="btn btn-primary">Atividade</router-link>
    </div>

    <div class="content-container mt-4 p-4 border rounded shadow-sm bg-light text-center" v-if="$route.path === '/'">
      <h2>Bem-vindo à Página Principal</h2>
      <p>Aqui você pode gerenciar clientes, colaboradores, projetos e atividades.</p>
    </div>

    <router-view></router-view>
  </div>
</template>

<style scoped>
.content-container {
  max-width: 800px;
  margin: 0 auto;
  background-color: #f8f9fa;
}
</style>

<script>
export default {
  name: 'App',
};
</script>
