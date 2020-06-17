CREATE TABLE IF NOT EXISTS livros(
    id integer AUTO_INCREMENT PRIMARY KEY,
    titulo varchar(150) NOT NULL,
    autor varchar(150) NOT NULL,
    ano_lancamento year(4) NOT NULL,
    estado_conservacao varchar(30) NOT NULL,
    disponivel boolean NOT NULL
);