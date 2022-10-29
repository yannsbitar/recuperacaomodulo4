create database tiobarnabetur;
use tiobarnabetur;
CREATE TABLE cliente (
cpf VARCHAR(11),
endereço VARCHAR(50),
telefone VARCHAR(15),
nome VARCHAR(60),
idcliente INTEGER PRIMARY KEY
);

CREATE TABLE viagem (
idviagem INTEGER PRIMARY KEY,
ida  VARCHAR(10),
volta VARCHAR(10),
destino VARCHAR(15),
idcliente INTEGER,
FOREIGN KEY(idcliente) REFERENCES cliente (idcliente)
);

