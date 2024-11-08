create database db_agenda_curso;
use db_agenda_curso;
DROP DATABASE db_agenda_curso;

CREATE TABLE setor(
	id_setor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(20) UNIQUE,
	sigla CHAR(3)
);

CREATE TABLE funcionario(
	id_funcionario INT UNIQUE NOT NULL PRIMARY KEY,
	CPF VARCHAR(14) UNIQUE,
	nome VARCHAR(20),
	sobrenome VARCHAR(30),
	Telefone VARCHAR(15),
	email VARCHAR(320) UNIQUE,
	turno ENUM('matutino','vespertino','noturno'),
	data_adimissao DATE DEFAULT CURRENT_TIMESTAMP, -- talvez nao faça sentido no momento
	cargo ENUM("supervisor", "instrutor", "operador"),
	id_setor INT, -- mudar no PF
	CONSTRAINT FK_SetorFuncionario FOREIGN KEY (id_setor)
		REFERENCES setor(id_setor)
);

CREATE TABLE equipe(
	id_equipe INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	nome VARCHAR(15) UNIQUE,
	descricao VARCHAR(200),
    turno ENUM('matutino','vespertino','noturno')
);

CREATE TABLE treinamento(
	id_treinamento INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_instrutor INT,
	nome_treinamento varchar(30),
	descricao VARCHAR(200), 
    carga_Horaria TIME,
	validade INT(3), -- meses ou anos ou ate anos quebrados
	formato ENUM("Presencial", "Online", "Hibrido"),
	CONSTRAINT FK_InstrutorTreino FOREIGN KEY (id_instrutor)
		REFERENCES funcionario(id_funcionario)
);

CREATE TABLE cadastro_funcionario_equipe(
	id_cadastro INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_funcionario INT,
	id_equipe INT,
	CONSTRAINT FK_FuncionarioCad FOREIGN KEY (id_funcionario) 
		REFERENCES funcionario(id_funcionario),
	CONSTRAINT FK_EquipeCad FOREIGN KEY (id_equipe)
		REFERENCES equipe(id_equipe)
);

CREATE TABLE cadastro_equipe_treinamento(
	id_cadastro INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_equipe INT,
	id_treinamento INT,
    prev_fim DATE,
	prev_comeco DATE,
	CONSTRAINT FK_EquipeTreinoCad FOREIGN KEY (id_equipe)
		REFERENCES equipe(id_equipe),
	CONSTRAINT FK_TreinoEquipeCad FOREIGN KEY (id_treinamento)
		REFERENCES treinamento(id_treinamento)
);

CREATE VIEW vw_treinamento AS
	SELECT treinamento.id_treinamento, treinamento.nome_treinamento, treinamento.carga_horaria, treinamento.validade, treinamento.formato, funcionario.nome
		FROM treinamento
	INNER JOIN funcionario
		ON treinamento.id_instrutor = funcionario.id_funcionario
WITH CHECK OPTION;
DESC vw_treinamento;
DROP VIEW vw_treinamento;

SELECT * from cadastro_equipe_treinamento;
SELECT * from equipe;
