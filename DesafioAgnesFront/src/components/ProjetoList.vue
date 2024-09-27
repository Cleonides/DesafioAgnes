<!-- src/components/ProjetoList.vue -->

<script>
import ProjetoService from '../services/ProjetoService'; // Importa o serviço
import ClienteService from '../services/ClienteService'; // Importa o serviço
import AtividadeService from '../services/AtividadeService'; // Importa o serviço

export default {
    data() {
        return {
            projetos: [], // Array para armazenar os projetos
            nome: '', // Campo para o nome do projeto
            descricao: '', // Campo para o descricao do projeto
            error: null, // Variável para armazenar mensagens de erro
            clientes: [], // Array para armazenar os clientes
            clienteSelecionado: null, // Armazena o cliente selecionado
            atividades: [], // Array para armazenar os atividades
        };
    },
    mounted() {
        // Carrega projetos ao montar o componente
        this.listarProjetos(); // Chama o método para listar projetos
        this.listarClientes(); // Chama o método para listar clientes
    },
    methods: {
        listarProjetos() {
            ProjetoService.listarProjetos()
                .then(data => {
                    this.projetos = data; // Atualiza o estado com os projetos carregados
                })
                .catch(error => {
                    console.error('Erro ao carregar projetos:', error);
                });
        },
        listarClientes() {
            ClienteService.listarClientes()
                  .then(data => {
                      this.clientes = data; // Atualiza o estado com os clientes carregados
                  })
                  .catch(error => {
                      console.error('Erro ao carregar clientes:', error);
                  });
        },
        listarAtividades(idProjeto) {
            AtividadeService.listarAtividadesPorProjeto(idProjeto)
            .then(data => {
                this.atividades = data; // Atualiza o estado com os atividades carregados
            })
            .catch(error => {
                console.error('Erro ao carregar atividades:', error);
            });
        },
        cadastrarProjeto() {
            const novoProjeto = {
                nome: this.nome,
                descricao: this.descricao,
                cliente: this.clienteSelecionado
            };

            ProjetoService.cadastrarProjeto(novoProjeto)
                .then(() => {
                    this.listarProjetos(); // Recarrega a lista de projetos após cadastro
                    this.nome = ''; // Limpa o campo nome
                    this.descricao = ''; // Limpa o campo descricao
                })
                .catch(error => {
                    console.error('Erro ao cadastrar projeto:', error);
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
        <h2 class="text-center mb-4">Página do Projeto</h2>

        <!-- Formulário centralizado -->
        <div class="row justify-content-center">
          <div class="col-md-6">
            <div class="card p-4 shadow">
              <form @submit.prevent="cadastrarProjeto">
                <div class="mb-3">
                  <label for="nome" class="form-label">Nome</label>
                  <input type="text" class="form-control" id="nome" v-model="nome" placeholder="Digite o nome do projeto">
                </div>
                <div class="mb-3">
                  <label for="descricao" class="form-label">Descrição</label>
                  <input type="text" class="form-control" id="descricao" v-model="descricao" placeholder="Digite a descrição do projeto">
                </div>
                <div class="mb-2 row">
                  <div class="col">
                    <label for="cliente" class="form-label">Cliente</label>
                    <select class="form-select" aria-label="Default" v-model="clienteSelecionado">
                      <option value="" selected></option>
                      <!-- Itera sobre a lista de clientes para exibir cada um -->
                      <option v-for="cliente in clientes" :key="cliente.id" :value="cliente">
                        {{ cliente.nome }}
                      </option>
                    </select>
                  </div>
                </div><br/>
                 <div align="center">
                    <button type="submit" class="btn btn-primary w-20">Cadastrar Projeto</button>
                 </div>
              </form>
            </div>
          </div>
        </div>

       <!-- Tabela de projetos -->
    <div class="mt-5">
      <h4>Projetos Cadastrados</h4>
      <table class="table table-striped table-bordered ">
        <thead class="table-primary">
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Cliente</th>
            <th>Status</th>
            <th>Atividades</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(projeto, index) in projetos" :key="index">
            <td>{{ projeto.id }}</td>
            <td>{{ projeto.nome }}</td>
            <td>{{ projeto.descricao }}</td>
            <td>{{ projeto.cliente.nome }}</td>
            <td>{{ projeto.status }}</td>
            <td>
                <a class="btn btn-link" data-bs-toggle="modal" data-bs-target="#atividade" @click="listarAtividades(projeto.id, projeto.nome)">
                  <i class="bi bi-eye"></i> Detalhar
                </a>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
<br/><br/><br/>

<div class="modal fade" id="atividade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Atividades do projeto</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="mt-5">
          <table class="table table-striped table-bordered">
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
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</template>

