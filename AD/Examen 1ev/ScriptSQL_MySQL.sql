create database ventas;
use ventas;

create table cliente( 
dni varchar(9) not null,
nombre varchar(25)  not null,
apellidos varchar(50)  not null,
direccion varchar(50)  not null,
cp integer  not null,
poblacion varchar(25)  not null,
email varchar(35),
constraint pkcli primary key (dni));

create table articulo( 
codart integer, 
nombre varchar(25)  not null,
marca varchar(25)  not null,
modelo varchar(25)  not null,
precio float not null,
vendible tinyint  not null,
constraint pkarticulo primary key (codart));
	   
create table compra( 
dni_a varchar(9) ,
cod_articulo integer,
fecha_compra datetime  not null,
pagado tinyint,
precio float not null,
descuento integer,
unidades integer not null,
constraint pkcompra primary key (dni_a, cod_articulo),
constraint fkcli foreign key (dni_a) references cliente(dni),
constraint fkart foreign key (cod_articulo) references articulo(codart));