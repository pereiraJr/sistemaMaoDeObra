delete from usuario where usuarioId = 10;
use projeto;
select * from usuario;
create database projeto;
select * from 	usuario;
CREATE TABLE `usuario` (  
`usuarioId` int(5) NOT NULL AUTO_INCREMENT,  
`nome` varchar(25) DEFAULT NULL,  
`email` varchar(25) DEFAULT NULL,  
`telefone` varchar(15) DEFAULT NULL,  
`endereco` varchar(15) DEFAULT NULL,  PRIMARY KEY (`usuarioId`));


ALTER TABLE usuario ADD login varchar(15);
ALTER TABLE usuario ADD senha varchar(15);

ALTER TABLE usuario ADD id_anuncio int(5);

ALTER TABLE `usuario` ADD CONSTRAINT `fk_anuncio` FOREIGN KEY ( `id_anuncio` ) REFERENCES `anuncio` ( `anuncioId` ) ;

select login, senha from usuario where login='admin' and senha=123456;

ALTER TABLE usuario AUTO_INCREMENT = 1;
show databases;

show tables;

//drop table anuncio;


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
ALTER TABLE `anuncio` ADD constraint `fk_usuario` foreign key ( `id_usuario` ) REFERENCES `usuario` ( `usuarioId` );

CREATE TABLE `usuario` (
 `usuarioId` int(5) NOT NULL AUTO_INCREMENT,
 `nome` varchar(25) DEFAULT NULL,
 `email` varchar(25) DEFAULT NULL,
 `telefone` varchar(15) DEFAULT NULL,
 `endereco` varchar(15) DEFAULT NULL,
 `login` varchar(10) DEFAULT NULL,
 `senha` varchar(10) DEFAULT NULL,
 PRIMARY KEY (`usuarioId`));



CREATE TABLE `anuncio` ( 
`anuncioId` int(5) NOT NULL AUTO_INCREMENT,
`titulo` varchar(25) DEFAULT NULL,
`descricao` varchar(50) DEFAULT NULL,
`id_usuario` int(5),
PRIMARY KEY (`anuncioId`));

ALTER TABLE anuncio ADD id_usuario int(5);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

select * from anuncio;

SHOW TABLE STATUS FROM projeto LIKE 'usuario';