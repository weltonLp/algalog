create table lancamento(
	id bigint not null auto_increment,
    descricao text not null,
    data_vencimento date not null,
    data_pagamento date not null,
    valor decimal(10,2) not null,
    observacao text not null,
    tipo varchar(100) not null,
    
    pessoa_id bigint not null,
    categoria_id bigint not null,
    
    primary key(id),
	
    constraint fk_pessoa_lancamento foreign key(pessoa_id) references pessoa(id),
	constraint fk_categoria_lancamento foreign key(categoria_id ) references categoria(id)
);
  