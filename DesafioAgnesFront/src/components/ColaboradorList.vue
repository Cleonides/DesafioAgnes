<!-- src/components/ColaboradorList.vue -->

<script>
import ColaboradorService from '../services/ColaboradorService'; // Importa o serviço
import Toasts from '../components/ToastMensagens.vue';

export default {
    components: {
      Toasts
    },
    data() {
        return {
            colaboradores: [], // Array para armazenar os colaboradores
            nome: '', // Campo para o nome do colaborador
            cargo: '', // Campo para o cargo do colaborador
            error: null, // Variável para armazenar mensagens de erro
        };
    },
    mounted() {
        // Carrega colaboradores ao montar o componente
        this.listarColaboradores(); // Chama o método para listar colaboradores
    },
    methods: {
        mostrarSucesso() {
          this.$refs.mensagens.showToast('Colaborador cadastrado com sucesso!', 'success');
        },
        mostrarErro() {
          this.$refs.mensagens.showToast('Erro ao cadastrar colaborador.', 'error');
        },
        listarColaboradores() {
            ColaboradorService.listarColaboradores()
                .then(data => {
                    this.colaboradores = data; // Atualiza o estado com os colaboradores carregados
                })
                .catch(error => {
                    console.error('Erro ao carregar colaboradores:', error);
                });
        },
        cadastrarColaborador() {
            const novoColaborador = {
                nome: this.nome,
                cargo: this.cargo
            };

            ColaboradorService.cadastrarColaborador(novoColaborador)
                .then(() => {
                    this.listarColaboradores(); // Recarrega a lista de colaboradores após cadastro
                    this.nome = ''; // Limpa o campo nome
                    this.cargo = ''; // Limpa o campo cargo
                    this.mostrarSucesso();
                })
                .catch(error => {
                    console.error('Erro ao cadastrar colaborador:', error);
                    this.mostrarErro();
                });
        }
    }
};
</script>

<style>
.error {
    color: red; /* Estilo para mensagens de erro */
}
</style>
    <template>
      <div class="container mt-5">
        <!-- Título da página -->
        <h2 class="text-center mb-4">Página do Colaborador</h2>

        <!-- Formulário centralizado -->
        <div class="row justify-content-center">
          <div class="col-md-6">
            <div class="card p-4 shadow">
              <form @submit.prevent="cadastrarColaborador">
                <div class="mb-3">
                  <label for="nome" class="form-label">Nome</label>
                  <input type="text" class="form-control" id="nome" v-model="nome" placeholder="Digite o nome do colaborador">
                </div>
                <div class="mb-3">
                  <label for="cargo" class="form-label">Cargo</label>
                  <input type="text" class="form-control" id="cargo" v-model="cargo" placeholder="Digite a descrição do colaborador">
                </div>
                 <div align="center">
                    <button type="submit" class="btn btn-primary w-20">Cadastrar Colaborador</button>
                 </div>
              </form>
            </div>
          </div>
        </div>

       <!-- Tabela de colaboradores -->
    <div class="mt-5">
      <h4>Colaboradores Cadastrados</h4>
      <table class="table table-striped table-bordered ">
        <thead class="table-primary">
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Projeto</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(colaborador, index) in colaboradores" :key="index">
            <td>{{ colaborador.id }}</td>
            <td>{{ colaborador.nome }}</td>
            <td>{{ colaborador.cargo }}</td>
            <td>
              <span v-if="colaborador.projeto">{{ colaborador.projeto.nome }}</span>
              <span v-else></span>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
<br/><br/><br/>
      <!-- Componente Toast -->
      <Toasts  ref="mensagens"></Toasts >
</template>

