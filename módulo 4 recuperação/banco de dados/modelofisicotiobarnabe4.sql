-- Gera��o de Modelo f�sico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE cliente (
cpf VARCHAR(11),
endere�o VARCHAR(50),
telefone VARCHAR(15),
nome VARCHAR(60),
idcliente INTEGER PRIMARY KEY
)

CREATE TABLE viagem (
idviagem INTEGER PRIMARY KEY,
ida  VARCHAR(10),
volta VARCHAR(10),
destino VARCHAR(15),
idcliente INTEGER,
FOREIGN KEY(idcliente) REFERENCES cliente (idcliente)
)

