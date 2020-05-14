CREATE DATABASE adm_eletronicos;

USE adm_eletronicos;

CREATE TABLE produto (
  id int(10) NOT NULL AUTO_INCREMENT,
  nome varchar(255) NOT NULL,
  fabricante varchar(255) NOT NULL,
  status varchar(1) DEFAULT 'A',
  PRIMARY KEY (id)
);