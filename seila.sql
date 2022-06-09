create table compraProdutos (
	idCompra int not null,
    idUsuario int not null,
    idProduto int not null,
    foreign key (idCompra) references  
);

create table compra (
	id int not null primary key auto_increment,
    idPessoa int not null,
    idProdutos varchar(255) not null,
    foreign key (idPessoa) references pessoa (id)
);