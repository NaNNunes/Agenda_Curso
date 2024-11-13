create database db_agenda_curso;
use db_agenda_curso;
DROP DATABASE db_agenda_curso;

CREATE TABLE setor (
    id_setor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(20) UNIQUE,
    sigla CHAR(3)
);

CREATE TABLE funcionario(
	id_funcionario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
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
	nome_treinamento varchar(30),
	descricao VARCHAR(200), 
    carga_Horaria INT,
	validade INT(3) -- meses ou anos ou ate anos quebrados
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
    id_instrutor INT,
    prev_fim DATE,
	prev_comeco DATE,
    formato ENUM("Presencial", "Online", "Hibrido"),
	CONSTRAINT FK_EquipeTreinoCad FOREIGN KEY (id_equipe)
		REFERENCES equipe(id_equipe),
	CONSTRAINT FK_TreinoEquipeCad FOREIGN KEY (id_treinamento)
		REFERENCES treinamento(id_treinamento),
	CONSTRAINT FK_InstrutorCad FOREIGN KEY (id_instrutor) 
		REFERENCES funcionario(id_funcionario)
);

-- ///////////////////////////////////////////////////////////////////

CREATE OR REPLACE VIEW vw_getId_setor AS
	SELECT id_setor FROM setor
WITH CHECK OPTION;
DROP VIEW vw_getId_setor;

CREATE OR REPLACE VIEW vw_funcionario AS
    SELECT 
        funcionario.id_funcionario,
        funcionario.cpf, 
        concat(funcionario.nome," ",funcionario.sobrenome) AS `nome_completo`,
        funcionario.telefone,
        funcionario.email,
        funcionario.turno,
        funcionario.cargo,
        setor.sigla AS setor
        FROM
        funcionario
            INNER JOIN
        setor ON funcionario.id_setor = setor.id_setor WITH CHECK OPTION;
DROP VIEW vw_funcionario;

CREATE VIEW vw_Equipe AS
	SELECT
		id_equipe,
		nome,
        turno
        FROM equipe WITH CHECK OPTION;
DROP VIEW vw_Equipe;

CREATE OR REPLACE VIEW vw_treinamento AS 
	SELECT
		id_treinamento,
		nome_treinamento AS nome,
		carga_horaria,
		validade
    FROM treinamento WITH CHECK OPTION;
    
CREATE OR REPLACE VIEW vw_setor AS
	SELECT
		sigla
	FROM setor WITH CHECK OPTION;
        
CREATE OR REPLACE VIEW vw_getID_Instrutor AS
    SELECT 
        funcionario.id_funcionario as id_instrutor
    FROM
        funcionario
    WHERE
        funcionario.cargo LIKE 'instrutor';
          
CREATE OR REPLACE VIEW vw_CadFuncEqp AS
	SELECT
		treinamento.nome_treinamento,
        equipe.nome
	FROM cadastro_equipe_treinamento
    LEFT JOIN treinamento 
		ON treinamento.id_treinamento = cadastro_equipe_treinamento.id_treinamento
    RIGHT JOIN equipe
		ON equipe.id_equipe = cadastro_equipe_treinamento.id_equipe;
    
-- ///////////////////////////////////////////////////////////////////
    
select * from cadastro_funcionario_equipe;
DELETE FROM cadastro_funcionario_equipe WHERE id_cadastro > 0;

select * from vw_funcionario;
select * from vw_equipe;
select * from vw_treinamento;
select * from vw_setor;
select * from vw_getId_Instrutor;
SELECT * from vw_CadFuncEqp;

select * from cadastro_equipe_treinamento;

desc vw_treinamento;
desc vw_equipe;

desc cadastro_equipe_treinamento;
desc cadastro_funcionario_equipe;

