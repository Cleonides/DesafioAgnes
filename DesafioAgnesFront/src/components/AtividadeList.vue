<!-- src/components/AtividadeList.vue -->

<script>
import AtividadeService from '../services/AtividadeService'; // Importa o serviço
import ProjetoService from '../services/ProjetoService'; // Importa o serviço
import ColaboradorService from '../services/ColaboradorService'; // Importa o serviço

export default {
    data() {
        return {
            atividades: [], // Array para armazenar os atividades
            nome: '', // Campo para o nome do atividade
            descricao: '', // Campo para o descricao do atividade
            error: null, // Variável para armazenar mensagens de erro
            projetos: [], // Array para armazenar os projetos
            projetoSelecionado: null, // Armazena o projeto selecionado
            colaboradores: [], // Array para armazenar os colaboradores
            colaboradorSelecionado: null, // Armazena o colaborador selecionado

        };
    },
    mounted() {
        // Carrega atividades ao montar o componente
        this.listarAtividades(); // Chama o método para listar atividades
        this.listarProjetos(); // Chama o método para listar projetos
        this.listarColaboradores(); // Chama o método para listar colaboradores
    },
    methods: {
        listarColaboradores() {
            ColaboradorService.listarColaboradores()
                .then(data => {
                    this.colaboradores = data; // Atualiza o estado com os colaboradores carregados
                })
                .catch(error => {
                    console.error('Erro ao carregar colaboradores:', error);
                });
            },
         listarProjetos() {
            ProjetoService.listarProjetos()
                .then(data => {
                    this.projetos = data; // Atualiza o estado com os projetos carregados
                })
                .catch(error => {
                    console.error('Erro ao carregar projetos:', error);
                });
         },
        listarAtividades() {
            AtividadeService.listarAtividades()
                .then(data => {
                    this.atividades = data; // Atualiza o estado com os atividades carregados
                })
                .catch(error => {
                    console.error('Erro ao carregar atividades:', error);
                });
        },
        cadastrarAtividade() {
            const novaAtividade = {
                nome: this.nome,
                descricao: this.descricao,
                projeto: this.projetoSelecionado,
                colaborador : this.colaboradorSelecionado
            };

            AtividadeService.cadastrarAtividade(novaAtividade)
                .then(() => {
                    this.listarAtividades(); // Recarrega a lista de atividades após cadastro
                    this.nome = ''; // Limpa o campo nome
                    this.descricao = ''; // Limpa o campo descricao
                    this.projeto = ''; // Limpa o campo descricao
                    this.colaborador = ''; // Limpa o campo descricao
                })
                .catch(error => {
                    console.error('Erro ao cadastrar atividade:', error);
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
        <h2 class="text-center mb-4">Página do Atividade</h2>

        <!-- Formulário centralizado -->
        <div class="row justify-content-center">
          <div class="col-md-6">
            <div class="card p-4 shadow">
              <form @submit.prevent="cadastrarAtividade">
                <div class="mb-3">
                  <label for="nome" class="form-label">Nome</label>
                  <input type="text" class="form-control" id="nome" v-model="nome" placeholder="Digite o nome do atividade">
                </div>
                <div class="mb-3">
                  <label for="descricao" class="form-label">Descrição</label>
                  <input type="text" class="form-control" id="descricao" v-model="descricao" placeholder="Digite a descrição do atividade">
                </div>
                <div class="mb-2 row">
                  <div class="col">
                    <label for="projeto" class="form-label">Projeto</label>
                    <select class="form-select" aria-label="Default" v-model="projetoSelecionado">
                      <option value="" selected></option>
                      <!-- Itera sobre a lista de projetos para exibir cada um -->
                      <option v-for="projeto in projetos" :key="projeto.id" :value="projeto">
                        {{ projeto.nome }}
                      </option>
                    </select>
                  </div>
                  <div class="col">
                    <label for="projeto" class="form-label">Colaborador</label>
                    <select class="form-select" aria-label="Default" v-model="colaboradorSelecionado">
                      <option value="" selected></option>
                      <!-- Itera sobre a lista de projetos para exibir cada um -->
                      <option v-for="colaborador in colaboradores" :key="colaborador.id" :value="colaborador">
                        {{ colaborador.nome }} - {{ colaborador.cargo }}
                      </option>
                    </select>
                  </div>
                </div><br/>
                 <div align="center">
                    <button type="submit" class="btn btn-primary w-20">Cadastrar Atividade</button>
                 </div>
              </form>
            </div>
          </div>
        </div>

       <!-- Tabela de atividades -->
    <div class="mt-5">
      <h4>Atividades Cadastradas</h4>
      <table class="table table-striped table-bordered ">
        <thead class="table-primary">
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Projeto</th>
            <th>Colaborador</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(atividade, index) in atividades" :key="index">
            <td>{{ atividade.id }}</td>
            <td>{{ atividade.nome }}</td>
            <td>{{ atividade.descricao }}</td>
            <td>{{ atividade.projeto.nome }}</td>
            <td>{{ atividade.colaborador.nome }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
<br/><br/><br/>

</template>

