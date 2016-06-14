create database projeto;
use projeto; 

CREATE TABLE `usuario` (
 `usuarioId` int(5) NOT NULL AUTO_INCREMENT,
 `nome` varchar(40) DEFAULT NULL,
 `email` varchar(40) DEFAULT NULL,
 `telefone` varchar(20) DEFAULT NULL,
 `endereco` varchar(70) DEFAULT NULL,
 `login` varchar(20) DEFAULT NULL,
 `senha` varchar(20) DEFAULT NULL,
 PRIMARY KEY (`usuarioId`));

GO

CREATE TABLE `anuncio` ( 
`anuncioId` int(5) NOT NULL AUTO_INCREMENT,
`titulo` varchar(30) DEFAULT NULL,
`descricao` varchar(70) DEFAULT NULL,
`id_usuario` int(5),
PRIMARY KEY (`anuncioId`));

GO

ALTER TABLE `anuncio` ADD constraint `fk_usuario` foreign key ( `id_usuario` ) REFERENCES `usuario` ( `usuarioId` );