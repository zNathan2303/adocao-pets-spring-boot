CREATE DATABASE db_adocao_pets;

USE db_adocao_pets;

CREATE TABLE tb_especie (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE tb_ong (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(14) NOT NULL,
    data_fundacao DATE NOT NULL,
    ativa BOOLEAN DEFAULT TRUE NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(200) NOT NULL
);

CREATE TABLE tb_adotante (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    idade INT NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    email VARCHAR(200) NOT NULL,
    telefone VARCHAR(11)
);

CREATE TABLE tb_endereco_adotante (
	id INT PRIMARY KEY AUTO_INCREMENT,
    logradouro VARCHAR(200) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    id_adotante INT NOT NULL,
    FOREIGN KEY (id_adotante) REFERENCES tb_adotante(id)
);

CREATE TABLE tb_raca (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    id_especie INT NOT NULL,
    FOREIGN KEY (id_especie) REFERENCES tb_especie(id)
);

CREATE TABLE tb_endereco_ong (
	id INT PRIMARY KEY AUTO_INCREMENT,
    logradouro VARCHAR(200) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    inscricao_municipal VARCHAR(20) NOT NULL,
    id_ong INT NOT NULL,
    FOREIGN KEY (id_ong) REFERENCES tb_ong(id)
);

CREATE TABLE tb_pet (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    foto_url VARCHAR(250) NOT NULL,
    idade_aproximada INT NOT NULL,
    porte VARCHAR(7) NOT NULL,
    sexo VARCHAR(5) NOT NULL,
    descricao TEXT,
    id_raca INT NOT NULL,
    id_ong INT NOT NULL,
    FOREIGN KEY (id_raca) REFERENCES tb_raca(id),
    FOREIGN KEY (id_ong) REFERENCES tb_ong(id)
);

CREATE TABLE tb_adocao (
	id INT PRIMARY KEY AUTO_INCREMENT,
    data_adocao DATE NOT NULL,
    id_adotante INT NOT NULL,
    id_pet INT NOT NULL,
    FOREIGN KEY (id_adotante) REFERENCES tb_adotante(id),
    FOREIGN KEY (id_pet) REFERENCES tb_pet(id)
);
