-----------------------------------------------------------------------------
-- CRUDS DE PRODUTO
-----------------------------------------------------------------------------
insert into Cor (cor) values('Rosa');
insert into Cor (cor) values('Azul');
insert into Cor (cor) values('Vermelho');
insert into Cor (cor) values('Marrom');

insert into Tema (nomeTema) values ('Batman - Liga da Justiça');
insert into Tema (nomeTema) values ('Super Homem - Liga da Justiça');
insert into Tema (nomeTema) values ('Super Mulher - Liga da Justiça');
insert into Tema (nomeTema) values ('Mulher Maravilha - Liga da Justiça');

insert into Pauta (quantidadePauta) values (10);
insert into Pauta (quantidadePauta) values (20);
insert into Pauta (quantidadePauta) values (30);
insert into Pauta (quantidadePauta) values (40);
insert into Pauta (quantidadePauta) values (50);

insert into CampoIdentificacao (nomeCampo) values ('Nome');
insert into CampoIdentificacao (nomeCampo) values ('Endereço');
insert into CampoIdentificacao (nomeCampo) values ('Telefone');
insert into CampoIdentificacao (nomeCampo) values ('E-mail');
insert into CampoIdentificacao (nomeCampo) values ('Disciplina');
insert into CampoIdentificacao (nomeCampo) values ('Professor');

insert into Disco (nome,descricao,precoUnitario,estoque,id_cor) values('Disco azul','disco grande azul turquesa',10.50,100,2);
insert into Disco (nome,descricao,precoUnitario,estoque,id_cor) values('Disco vermelho','disco grande vermelho sangue',10.50,100,3);
insert into Disco (nome,descricao,precoUnitario,estoque,id_cor) values('Disco marrom','disco grande marrom terra',10.50,100,4);
insert into Disco (nome,descricao,precoUnitario,estoque,id_cor) values('Disco azul','disco pequeno azul turquesa',10.50,100,2);
insert into Disco (nome,descricao,precoUnitario,estoque,id_cor) values('Disco vermelho','disco pequeno vermelho sangue',10.50,100,3);
insert into Disco (nome,descricao,precoUnitario,estoque,id_cor) values('Disco marrom','disco pequeno marrom terra',10.50,100,4);

insert into CapaContraCapa (nome,descricao,precoUnitario,estoque,id_cor,id_tema) values('Capa imagem do batman','Capa com imagem do batman do liga da justiça desenho',100.00,4,1);
insert into CapaContraCapa (nome,descricao,precoUnitario,estoque,id_cor,id_tema) values('Capa imagem do super-homem','Capa com imagem do super homem do liga da justiça desenho',100.00,4,2);
insert into CapaContraCapa (nome,descricao,precoUnitario,estoque,id_cor,id_tema) values('Capa imagem do super-mulher','Capa com imagem do super mulher do liga da justiça desenho',100.00,4,3);

insert into Folha (nome,descricao,precoUnitario,quantidade,id_cor,id_pauta) values('Folha rosa claro','Folha rosa claro com detalhes de flores',10.55,3,1);
insert into Folha (nome,descricao,precoUnitario,quantidade,id_cor,id_pauta) values('Folha preta ','Folha preta com detalhes de estrelas',10.55,2,3);
insert into Folha (nome,descricao,precoUnitario,quantidade,id_cor,id_pauta) values('Folha marrom ','Folha marrom com detalhes de coelhinho',10.55,5,3);

insert into CadernoPersonalizado (id_folha,tamanho,id_pauta,id_capacontracapa,id_disco) values(1,'GRANDE',1,1,1);
insert into CadernoPersonalizado (id_folha,tamanho,id_pauta,id_capacontracapa,id_disco) values(2,'GRANDE',2,2,2);
insert into CadernoPersonalizado (id_folha,tamanho,id_pauta,id_capacontracapa,id_disco) values(3,'GRANDE',3,3,3);

-----------------------------------------------------------------------------
-- CRUDS DE USUÁRIO/COMPRA/
-----------------------------------------------------------------------------
insert into estado (nome, sigla) values( 'Tocantins', 'TO');
insert into estado (nome, sigla) values( 'Goiás', 'GO');
insert into estado (nome, sigla) values( 'São Paulo', 'SP');
insert into estado (nome, sigla) values( 'Rio de Janeiro', 'RJ');
insert into estado (nome, sigla) values( 'Pará', 'PA');

insert into municipio (nome, id_estado) values( 'Palmas', 1);
insert into municipio (nome, id_estado) values( 'Paraíso', 1);
insert into municipio (nome, id_estado) values( 'Gurupi', 1);
insert into municipio (nome, id_estado) values( 'Goiânia', 2);
insert into municipio (nome, id_estado) values( 'Anápolis', 2);

insert into Endereco (principal,logradouro,bairro,numero,complemento,cep,id_municipio) values('true','Plano diretor sul','906 sul','18','Casa de esquina muro azul','77023388',1);
insert into Endereco (principal,logradouro,bairro,numero,complemento,cep,id_municipio) values('true','Plano diretor sul','1006 sul','18','Casa de esquina muro azul','77023388',2);
insert into Endereco (principal,logradouro,bairro,numero,complemento,cep,id_municipio) values('true','Plano diretor sul','1106 sul','18','Casa de esquina muro azul','77023388',3);

-- insert into Usuario (nome,email,senha,cpf,telefone,perfilUsuario) values();

