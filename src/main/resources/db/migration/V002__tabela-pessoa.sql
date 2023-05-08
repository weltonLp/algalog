create table pessoa (
	id bigint not null auto_increment,
	nome varchar(60) not null,
	ativo boolean not null,
	
	logrdouro varchar(60) not null,
	numero varchar(60) not null,
	complemento varchar(60) not null,
	bairro varchar(60) not null,
	cep varchar(60) not null,
	cidade varchar(60) not null,
	estado varchar(60) not null,
	
	primary key(id)
	
);
