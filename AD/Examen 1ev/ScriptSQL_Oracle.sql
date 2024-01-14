create user c##ventas identified by ventas default tablespace users;
grant connect, resource,DBA to c##ventas;

create table cliente( 
dni varchar2(9) not null,
nombre varchar2(25)  not null,
apellidos varchar2(50)  not null,
direccion varchar2(50)  not null,
cp number  not null,
poblacion varchar2(25)  not null,
email varchar2(35),
constraint pkcli primary key (dni));

create table articulo( 
codart number, 
nombre varchar2(25)  not null,
marca varchar2(25)  not null,
modelo varchar2(25)  not null,
precio number(5,2) not null,
vendible SMALLINT  not null,
constraint pkarticulo primary key (codart));
	   
create table compra( 
dni_a varchar2(9) ,
cod_articulo number,
fecha_compra date not null,
pagado SMALLINT,
precio number(5,2) not null,
descuento number,
unidades number not null,
constraint pkcompra primary key (dni_a, cod_articulo),
constraint fkcli foreign key (dni_a) references cliente(dni),
constraint fkart foreign key (cod_articulo) references articulo(codart));