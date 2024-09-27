<!-- src/components/ClienteList.vue -->

<script>
import ClienteService from '../services/ClienteService'; // Importa o serviço

export default {
    data() {
        return {
            clientes: [], // Array para armazenar os clientes
            nome: '', // Campo para o nome do cliente
            descricao: '', // Campo para a descrição do cliente
            error: null, // Variável para armazenar mensagens de erro
        };
    },
    mounted() {
        // Carrega clientes ao montar o componente
        this.listarClientes(); // Chama o método para listar clientes
    },
    methods: {
        listarClientes() {
            ClienteService.listarClientes()
                .then(data => {
                    this.clientes = data; // Atualiza o estado com os clientes carregados
                })
                .catch(error => {
                    console.error('Erro ao carregar clientes:', error);
                });
        },
        cadastrarCliente() {
            const novoCliente = {
                nome: this.nome,
                descricao: this.descricao
            };

            ClienteService.cadastrarCliente(novoCliente)
                .then(() => {
                    this.listarClientes(); // Recarrega a lista de clientes após cadastro
                    this.nome = ''; // Limpa o campo nome
                    this.descricao = ''; // Limpa o campo descrição
                })
                .catch(error => {
                    console.error('Erro ao cadastrar cliente:', error);
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
        <h2 class="text-center mb-4">Página do Cliente</h2>

        <!-- Formulário centralizado -->
        <div class="row justify-content-center">
          <div class="col-md-6">
            <div class="card p-4 shadow">
              <form @submit.prevent="cadastrarCliente">
                <div class="mb-3">
                  <label for="nome" class="form-label">Nome</label>
                  <input type="text" class="form-control" id="nome" v-model="nome" placeholder="Digite o nome do cliente">
                </div>
                <div class="mb-3">
                  <label for="descricao" class="form-label">Descrição</label>
                  <input type="text" class="form-control" id="descricao" v-model="descricao" placeholder="Digite a descrição do cliente">
                </div>
                 <div align="center">
                    <button type="submit" class="btn btn-primary w-20">Cadastrar Cliente</button>
                 </div>
              </form>
            </div>
          </div>
        </div>

       <!-- Tabela de clientes -->
    <div class="mt-5">
      <h4>Clientes Cadastrados</h4>
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
          <tr v-for="(cliente, index) in clientes" :key="index">
            <td>{{ cliente.id }}</td>
            <td>{{ cliente.nome }}</td>
            <td>{{ cliente.descricao }}</td>
            <td> 
                <div v-for="(projeto, projIndex) in cliente.projetos" :key="projIndex">
                  {{ projeto.nome }}
                </div> 
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
<br/><br/><br/>

</template>

