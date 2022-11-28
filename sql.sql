Create table Pieza(
codigo_pieza varchar(6) primary key,
nombre varchar(20),
precio double,
descripcion varchar(20));

Create table Proveedor(
codigo_proveedor varchar(6) primary key,
nombre varchar(20),
apellido varchar(20),
direccion varchar(20)
);

Create table Proyecto(
codigo_proyecto varchar(6) primary key,
Nombre varchar(40),
ciudad varchar(40)
);

Create table Gestion(
Id_gestion integer primary key,
CDProveedor varchar(6),
CDPieza varchar(6),
CDProyecto varchar(6),
cantidad integer,
foreign key (CDProveedor) references Proveedor(codigo_proveedor),
foreign key (CDPieza) references Pieza(codigo_pieza),
foreign key (CDProyecto) references Proyecto(codigo_proyecto)
);
