DROP DATABASE IF EXISTS ex_javaweb_00;
CREATE DATABASE IF NOT EXISTS ex_javaweb_00;
USE ex_javaweb_00;

CREATE TABLE alunos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200),
    codigo_matricula VARCHAR(11),
    nota_1 FLOAT NOT NULL,
    nota_2 FLOAT NOT NULL,
    nota_3 FLOAT NOT NULL,
    media FLOAT NOT NULL,
    frequencia TINYINT NOT NULL
);
INSERT INTO alunos
(nome, codigo_matricula, nota_1, nota_2, nota_3, media, frequencia) VALUES
('Lucas Rodrigo', '#5TGD5', 5.4, 3.1, 8.56, 5.6, 42),
('Camilly Bento', '#54DYG', 7.5, 9.7, 8.3, 8.5, 100),
('Eduardo Borges', '#86TGG', 8.5, 4.2, 9.5, 7.4, 21),
('Lucas Reitz', '#9DDASS', 7.4, 2.3, 6.4, 5.3, 86);
