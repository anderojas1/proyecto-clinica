drop table PERSONA cascade;
DROP table AccesoSistema cascade;
DROP table AREA cascade;
DROP table PACIENTE cascade;
DROP table EMPLEADO cascade;
DROP table MEDICO cascade;
DROP table ENFERMERA cascade;
DROP table ENFERMERA_HABILIDAD cascade;
DROP table CAUSA cascade;
DROP table CAMA cascade;
DROP table CAMA_PACIENTE cascade;
DROP table CAMPANA cascade;
DROP table CAMPANA_PACIENTE cascade;
DROP table MEDICAMENTO cascade;
DROP table HISTORIA_C cascade;
DROP table AGENDA_CITA cascade;
DROP table FORMULA_MEDICA cascade;
DROP table REGISTRO CASCADE;
DROP TABLE Telefonos_Persona CASCADE;

CREATE TABLE  Area (

codigo VARCHAR(20) NOT NULL PRIMARY KEY,
nombre VARCHAR(30) NOT NULL,
descripcion VARCHAR(50) NOT NULL ,
estado bool NOT NULL 

);

CREATE TABLE Persona (

identificacion VARCHAR(30) NOT NULL PRIMARY KEY,
nombres VARCHAR(40) NOT NULL,
apellido_uno VARCHAR(20) NOT NULL,
apellido_dos VARCHAR(20),
direccion VARCHAR(25) NOT NULL, 
estado bool NOT NULL 

);

CREATE TABLE Telefonos_Persona (

identificacion VARCHAR(30) NOT NULL,
numero VARCHAR (20) NOT NULL,
tipo VARCHAR (10) NOT NULL,

CONSTRAINT telefono_pk PRIMARY KEY (identificacion, numero),

CONSTRAINT identificacion_fk FOREIGN KEY (identificacion)
REFERENCES Persona (identificacion)

);

CREATE TABLE AccesoSistema (

username varchar(20) NOT NULL PRIMARY KEY,
passzz varchar(30),
identificacion varchar(30) NOT NULL,
estado_cuenta varchar(20) NOT NULL,

CONSTRAINT identificacion_fk FOREIGN KEY (identificacion)
REFERENCES Persona(identificacion)
on update cascade on delete no action


);

CREATE TABLE Paciente (

identificacion VARCHAR(30) NOT NULL,
act_economica VARCHAR(100) NOT NULL,
num_seg_social VARCHAR(25) NOT NULL,
f_nacimiento DATE NOT NULL,
estado bool NOT NULL,

CONSTRAINT identificacion_fk FOREIGN KEY (identificacion)
REFERENCES PERSONA (identificacion)
on update cascade on delete no action
);

CREATE TABLE Empleado (

identificacion VARCHAR(30) NOT NULL,
cod_area VARCHAR(20) NOT NULL,
salario	FLOAT NOT NULL,
email VARCHAR(25) NOT NULL,
cargo VARCHAR(30) NOT NULL,
jefe VARCHAR(60) , 
estado bool NOT NULL ,

CONSTRAINT identificacion_pk PRIMARY KEY(identificacion),


CONSTRAINT identificacion_fk FOREIGN KEY (identificacion)
REFERENCES PERSONA (identificacion)
on update cascade on delete no action,

CONSTRAINT area_fk FOREIGN KEY (cod_area)
REFERENCES Area (codigo) 
on update cascade on delete no action,

CONSTRAINT persona_fk FOREIGN KEY (jefe)
REFERENCES PERSONA (identificacion)
on update cascade on delete no action

);

CREATE TABLE Medico (

identificacion VARCHAR(30) NOT NULL,
especialidad VARCHAR(30) NOT NULL,
universidad VARCHAR(20) NOT NULL, 
num_licencia VARCHAR(15) NOT NULL,
estado bool NOT NULL,

CONSTRAINT identificacion_fk FOREIGN KEY (identificacion)
REFERENCES Persona (identificacion)
on update cascade on delete no action

);

CREATE TABLE Enfermera (

identificacion VARCHAR(30) NOT NULL,
anos_exp INTEGER NOT NULL,
estado bool NOT NULL,

CONSTRAINT indentificacion_fk  FOREIGN KEY (identificacion)
REFERENCES Persona (identificacion)
on update cascade on delete no action

);
CREATE TABLE Enfermera_habilidad (

identificacion VARCHAR(30) NOT NULL,
habilidad VARCHAR(50) NOT NULL,

CONSTRAINT enfermera_habilidad_pk  PRIMARY KEY( identificacion, habilidad),

CONSTRAINT identificacion_fk FOREIGN KEY (identificacion)
REFERENCES persona (identificacion)
on update cascade on delete no action
 
);

CREATE TABLE Causa (

codigo VARCHAR(30) NOT NULL PRIMARY KEY,
nombre VARCHAR(30) NOT NULL,
descripcion VARCHAR(50) NOT NULL,
estado bool NOT NULL 

);

CREATE TABLE Cama (

numero VARCHAR(15) NOT NULL PRIMARY KEY,
descripcion VARCHAR(50) NOT NULL,
estado BOOL NOT NULL,
cod_area VARCHAR(30),
dardebaja bool NOT NULL,

CONSTRAINT  cama_fk FOREIGN KEY (cod_area)
REFERENCES Area (codigo)

);

CREATE TABLE Cama_paciente (

numero_cama VARCHAR(15) NOT NULL,
id_paciente VARCHAR(30) NOT NULL,
f_asignacion DATE NOT NULL,

CONSTRAINT cama_paciente_pk PRIMARY KEY (numero_cama, id_paciente, f_asignacion),

CONSTRAINT numero_cama_fk FOREIGN KEY (numero_cama) 
REFERENCES Cama (numero)
on update cascade on delete no action,

CONSTRAINT id_paciente_fk FOREIGN KEY (id_paciente) 
REFERENCES Persona (identificacion)
on update cascade on delete no action

);


CREATE TABLE Campana (

codigo VARCHAR(15) NOT NULL PRIMARY KEY,
objetivo VARCHAR(60) NOT NULL,
nombre VARCHAR(30) NOT NULL,
f_realizacion DATE NOT NULL,
id_medico VARCHAR(30) NOT NULL,
estado bool NOT NULL,

CONSTRAINT id_medico_fk FOREIGN KEY (id_medico)
REFERENCES Persona (identificacion)
on update cascade on delete no action

);

CREATE TABLE Campana_paciente(

cod_campana VARCHAR(15) NOT NULL, 
id_paciente VARCHAR(30) NOT NULL,

CONSTRAINT campana_paciente_pk PRIMARY KEY (cod_campana, id_paciente),

CONSTRAINT cod_camapana_fk FOREIGN KEY (cod_campana)
REFERENCES Campana (codigo)
on update cascade on delete no action,

CONSTRAINT id_paciente_fk FOREIGN KEY (id_paciente)
REFERENCES Persona (identificacion)
on update cascade on delete no action

);

CREATE TABLE  Medicamento(

codigo VARCHAR(15) NOT NULL PRIMARY KEY,
nombre VARCHAR(30) NOT NULL,
costo DOUBLE PRECISION NOT NULL, 
descripcion VARCHAR(60) NOT NULL,
estado bool NOT NULL
);

CREATE TABLE Historia_c(

numero VARCHAR(25) NOT NULL PRIMARY KEY,
f_apertura DATE NOT NULL,
identificacion VARCHAR(30) NOT NULL,

CONSTRAINT identificacion_fk FOREIGN KEY (identificacion)
REFERENCES Persona (identificacion)
on update cascade on delete no action

);

CREATE TABLE Agenda_cita (

id_medico VARCHAR(30) NOT NULL,
id_paciente VARCHAR(30) NOT NULL,
fecha_hora DATE NOT NULL,
estado VARCHAR(10) NOT NULL,

CONSTRAINT agenda_cita_pk PRIMARY KEY (id_medico, id_paciente, fecha_hora),

CONSTRAINT id_medico_fk FOREIGN KEY (id_medico)
REFERENCES Persona (identificacion)
on update cascade on delete no action,

CONSTRAINT id_paciente_fk FOREIGN KEY (id_paciente)
REFERENCES Persona (identificacion)
on update cascade on delete no action

);

CREATE TABLE Formula_Medica(
id_medico VARCHAR(30) NOT NULL,
id_paciente VARCHAR(30) NOT NULL,
codigo_medicamento  VARCHAR(15) NOT NULL,
fecha_hora DATE NOT NULL,
cantidad_medicamento INTEGER NOT NULL,

CONSTRAINT formula_medica_pk PRIMARY KEY (id_medico, id_paciente,codigo_medicamento, fecha_hora),

CONSTRAINT id_medico_fk FOREIGN KEY (id_medico)
REFERENCES Persona (identificacion)
on update cascade on delete no action,

CONSTRAINT id_paciente_fk FOREIGN KEY (id_paciente)
REFERENCES Persona (identificacion)
on update cascade on delete no action,

CONSTRAINT codigo_medicamento_fk FOREIGN KEY (codigo_medicamento)
REFERENCES Medicamento(codigo)
on update cascade on delete no action

);

CREATE TABLE Registro(
id_medico VARCHAR(30) NOT NULL,
num_historia VARCHAR(25) NOT NULL,
codigo_causa VARCHAR(30) NOT NULL,
fecha_hora DATE NOT NULL,
valor  DOUBLE PRECISION NOT NULL,
estado bool NOT NULL, 

CONSTRAINT registro_pk PRIMARY KEY (id_medico, num_historia, codigo_causa, fecha_hora),

CONSTRAINT id_medico_fk FOREIGN KEY (id_medico)
REFERENCES Persona (identificacion)
on update cascade on delete no action,

CONSTRAINT num_historia_fk FOREIGN KEY (num_historia)
REFERENCES Historia_c (numero)
on update cascade on delete no action,

CONSTRAINT codigo_causa_fk FOREIGN KEY (codigo_causa)
REFERENCES Causa (codigo)
on update cascade on delete no action

);


INSERT INTO Persona (identificacion, nombres, apellido_uno, apellido_dos, direccion, estado)
    VALUES ('1144171818', 'Anderson', 'Enriquez', 'Rojas', '----', true);

INSERT INTO AccesoSistema VALUES ('admin', '12345', '1144171818', 'activo');
