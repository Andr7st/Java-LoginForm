create table usuarios (
	id 		serial NOT NULL,
	usuario  	varchar(24) NOT NULL,
	contrasena	varchar(512) NOT NULL,
	
	primary key (id)
);
/*
CREATE SEQUENCE aumento_id
  start 1
  increment 1;*/
  
insert into usuarios (id, usuario, contrasena) 
values (nextval('aumento_id'), 'Andr7st', '1234')
