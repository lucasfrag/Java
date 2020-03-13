drop DataBase livros;
create DataBase livros;
CREATE TABLE `livros`.`livros` (
  `id` INT AUTO_INCREMENT,
  `titulo` VARCHAR(200) NULL,
  `autor` VARCHAR(200) NULL,
  `ano` INT(4) NULL,
  `estado` VARCHAR(200) NULL,
  `disponivel` VARCHAR(200) NULL,
   `status` VARCHAR(2) NULL,
   PRIMARY KEY (`id`));