create table estado (
	idestado serial primary key,
	nomeestado varchar(100) not null,
	siglaestado varchar(2) not null

);

insert into estado(nomeestado, siglaestado)
values('São Paulo', 'SP');

select * from estado;

Create table veiculo(
idveiculo serial primary key,
marca varchar(100) not null,
modelo varchar(100) not null
idmodelo int not null,


);
create table cidade(
	
	idcidade serial primary key ,
	nomecidade varchar(100) not null,
	situacao varchar(1) not null,
	idestado int not null,
	constraint fk_estado FOREIGN key (idestado) references estado(idestado)
	



);

insert into cidade(nomecidade,situacao,idestado) values('Fernandopolis', 'A',15);
insert into cidade(nomecidade,situacao,idestado) values('Jales', 'A',15);



	create table modelo(
	idmodelo serial primary key, 
	descricao varchar(100)

	
				   );
			
				   create table marca(
idmarca serial primary key,
  descricao varchar(100)

	   
				   
				   );
				   Create table veiculo(
idveiculo serial primary key,

idmodelo int not null,
idmarca int not null, 
CONSTRAINT fk_modelo FOREIGN key (idmodelo) references modelo(idmodelo),
constraint fk_marca FOREIGN key (idmarca) REFERENCES marca(idmarca)					   
					   


);
