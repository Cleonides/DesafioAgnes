-- Limpa os dados das tabelas na ordem correta para evitar problemas de chaves estrangeiras
-- TRUNCATE TABLE atividade CASCADE;
-- TRUNCATE TABLE colaborador CASCADE;
-- TRUNCATE TABLE projeto CASCADE;
-- TRUNCATE TABLE cliente CASCADE;

--Insert em cliente
insert into cliente(nome, descricao) values ('Microsoft', 'Multinacional  Empresa de Software');
insert into cliente(nome, descricao) values ("Banco Brasil", "Empresa no setor financeiro");
insert into cliente(nome, descricao) values ('Bradesco', 'Empresa no setor financeiro 2');
--
-- --Insert em colaborador
-- insert into colaborador(nome, cargo, projeto_id) values ('Carlos',  'Desenvolvedor', null);
-- insert into colaborador(nome, cargo, projeto_id) values ('João',  'Desenvolvedor', null);
-- insert into colaborador(nome, cargo, projeto_id) values ('Caio',  'Analista de Teste(QA)', null);
-- insert into colaborador(nome, cargo, projeto_id) values ('Patricia',  'Analista de Teste(QA)', null);
-- insert into colaborador(nome, cargo, projeto_id) values ('Ana',  'Gerente projeto', null);
-- insert into colaborador(nome, cargo, projeto_id) values ('Beatriz', 'Gerente projeto', null);
--
-- --Insert em projeto
-- insert into projeto(nome, descricao, status, cliente_id) values('Sistema de crédito','Sistema responsável pelo setor de pagamentos (débito, crédito, boleto)',0,2);
-- insert into projeto(nome, descricao, status, cliente_id) values('Sistema de vendas','Sistema responsável pelo setor de vendas (produtos e serviços)',0,3)
--
-- --Insert em atividade
--
-- insert into atividade(nome, descricao, status, cliente_id) values("Requesitos e doc", "Criação de requesitos, protótipos e documentação", 1, 3)
-- insert into atividade(nome, descricao, status, cliente_id) values("Implementação", "Fase para desenvolver com base nos requesitos levantados", 2, 2)
