create database sistema;

use sistema;

create table tipoUsuario (
	id int primary key not null auto_increment,
    nome varchar(255) not null
);

select * from tipoUsuario;

insert into tipoUsuario (nome) values ("Administrador"), ("Comum");

create table pessoa (
	id int not null primary key auto_increment,
    nome varchar(255) not null,
    email varchar(255) unique not null,
    senha varchar(255) not null,
    data_criacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    idTipoUsuario int not null,
    foreign key (idTipoUsuario) references tipoUsuario (id)
);

insert into pessoa (nome, email, senha, idTipoUsuario) values ("admin", "admin", "admin", 1);

select * from pessoa;

CREATE VIEW vw_pessoa AS
    SELECT 
        `pessoa`.`id` as `id`,
        `pessoa`.`nome` as `nome`,
        `pessoa`.`email` as `email`,
        `pessoa`.`senha` as `senha`,
        `pessoa`.`data_criacao` as `data_criacao`,
        `pessoa`.`idTipoUsuario` as `idTipoUsuario`,
        tipoUsuario.nome as `nome_tipo_usuario`
    FROM
        `pessoa` LEFT JOIN `tipoUsuario`ON  pessoa.idTipoUsuario = tipoUsuario.id;
        
        
create table produto (
	id int not null primary key auto_increment,
    cod_barras int not null,
    preco int not null,
    descricao text not null,
    nome text not null,
    img varchar(255),
    id_pessoa int not null,
    foreign key (id_pessoa) references pessoa (id)
);

select * from produto; 
