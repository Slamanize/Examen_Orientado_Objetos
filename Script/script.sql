DROP DATABASE IF EXISTS ArenaGamers;
CREATE DATABASE ArenaGamers CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE EquipoGaming;

CREATE TABLE clientes(
    rut                     varchar(10)         NOT NULL ,
    nombre                  varchar(40)         NOT NULL ,
    telefono                int(12)             NOT NULL ,
    CONSTRAINT              pk_clientes         PRIMARY KEY (rut)
)

CREATE TABLE EquipoGaming(
    id                      int                 NOT NULL AUTO_INCREMENT,
    marca                   varchar(60)         not null ,
    modelo                  varchar(60)         not null ,
    anioAdquisicion         int                 not null ,
    horasUso                int                 not null,
    ram                     int                 NULL,
    gpu                     BOOLEAN             NULL,
    tipoVolante             BOOLEAN             NULL,
    cantVolantes            int(2)              NULL,
    generacion              int(2)              NULL,
    almacenamiente          int(10)             NULL,
    rut                     varchar(10)         NOT NULL,
    CONSTRAINT pk_EquipoGaming PRIMARY KEY (id),
    CONSTRAINT fk_rut FOREIGN KEY (rut) REFERENCES clientes (rut)
)