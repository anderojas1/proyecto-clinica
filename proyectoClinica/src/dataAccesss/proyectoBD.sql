DROP TABLE Areas, Personas CASCADE;

CREATE TABLE Areas (

    codigo VARCHAR(20) NOT NULL PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL,
    nombre VARCHAR(30) NOT NULL,

);


CREATE TABLE Personas (

    identificacion VARCHAR(30) NOT NULL PRIMARY KEY,
    nombres VARCHAR(40) NOT NULL,
    apellido_uno VARCHAR(20) NOT NULL,
    apellido_dos VARCHAR(20),
    telefono VARCHAR(10) NOT NULL,
    direccion VARCHAR(25) NOT NULL

);
