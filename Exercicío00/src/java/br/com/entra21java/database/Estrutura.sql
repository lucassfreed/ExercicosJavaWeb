DROP DATABASE IF EXISTS ex_javaweb_00;
CREATE DATABASE IF NOT EXISTS ex_javaweb_00;
USE ex_javaweb_00;

CREATE TABLE alunos(
    id INT AUTO_INCREMENT PRIMARY KEY;
    nome VARCHAR(200),
    codigo_matricula VARCHAR(11),
    nota_1 FLOAT,
    nota_2 FLOAT,
    nota_3 FLOAT,
    frequencia TINYINT;
    
);
