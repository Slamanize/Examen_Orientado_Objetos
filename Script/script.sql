DROP DATABASE IF EXISTS ArenaGamers;
CREATE DATABASE ArenaGamers CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE ArenaGamers;

CREATE TABLE clientes(
    rut                     varchar(10)         NOT NULL ,
    nombre                  varchar(30)         NOT NULL ,
    apellido                varchar(30)         NOT NULL ,
    telefono                int(12)             NOT NULL ,
    CONSTRAINT              pk_clientes         PRIMARY KEY (rut)
);

CREATE TABLE EquipoGaming(
    uid                     int(6)          NOT NULL AUTO_INCREMENT,
    tipo                    varchar(15)         NOT NULL ,
    marca                   varchar(60)         not null ,
    modelo                  varchar(60)         not null ,
    anioAdquisicion         int                 not null ,
    horasUso                int                 not null,
    ram                     int                 NULL,
    gpu                     BOOLEAN             NULL,
    tipoVolante             BOOLEAN             NULL,
    cantPedales            int(2)              NULL,
    generacion              int(2)              NULL,
    almacenamiento          int(10)             NULL,
    rut                     varchar(10)         NOT NULL,
    CONSTRAINT pk_EquipoGaming PRIMARY KEY (uid),
    CONSTRAINT fk_rut FOREIGN KEY (rut) REFERENCES clientes (rut)
);