create database db_agenda_curso;
use db_agenda_curso;
DROP DATABASE db_agenda_curso;

CREATE TABLE usuario(
    id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login_usuario VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(50) NOT NULL,
    tipo_usuario ENUM('admin', 'operador', 'supervisor','instrutor')
);
DROP TABLE usuario;

CREATE TABLE setor (
    id_setor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(20) UNIQUE,
    sigla CHAR(3)
);

CREATE TABLE funcionario (
    id_funcionario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE,
    nome_func VARCHAR(20),
    sobrenome VARCHAR(30),
    telefone VARCHAR(15),
    email VARCHAR(320) UNIQUE,
    turno ENUM('matutino', 'vespertino', 'noturno'),
    data_adimissao DATE DEFAULT CURRENT_TIMESTAMP,
    cargo ENUM('supervisor', 'instrutor', 'operador'),
    id_setor INT,
    CONSTRAINT FK_SetorFuncionario FOREIGN KEY (id_setor) REFERENCES setor (id_setor)
); 
ALTER TABLE funcionario CHANGE COLUMN nome nome_func VARCHAR(20);

CREATE TABLE equipe (
    id_equipe INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome_eqp VARCHAR(30) UNIQUE,
    descricao VARCHAR(200),
    turno ENUM('matutino', 'vespertino', 'noturno')
);
ALTER TABLE equipe CHANGE COLUMN nome nome_eqp VARCHAR(15) UNIQUE;
ALTER TABLE equipe MODIFY COLUMN nome_eqp VARCHAR(30) UNIQUE;

CREATE TABLE treinamento (
    id_treinamento INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome_treino VARCHAR(30),
    descricao VARCHAR(200),
    carga_horaria INT,
    validade INT
);
ALTER TABLE treinamento CHANGE COLUMN nome_treinamento nome_treino VARCHAR(30);

CREATE TABLE cadastro_funcionario_equipe (
    id_cadastro INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_funcionario INT,
    id_equipe INT,
    CONSTRAINT FK_FuncionarioCad FOREIGN KEY (id_funcionario)
        REFERENCES funcionario (id_funcionario),
    CONSTRAINT FK_EquipeCad FOREIGN KEY (id_equipe)
        REFERENCES equipe (id_equipe)
);

CREATE TABLE cadastro_equipe_treinamento (
    id_cadastro INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_equipe INT,
    id_treinamento INT,
    id_instrutor INT,
    prev_comeco DATE,
    prev_fim DATE,
    formato ENUM('Presencial', 'Online', 'Hibrido'),
    CONSTRAINT FK_EquipeTreinoCad FOREIGN KEY (id_equipe)
        REFERENCES equipe (id_equipe),
    CONSTRAINT FK_TreinoEquipeCad FOREIGN KEY (id_treinamento)
        REFERENCES treinamento (id_treinamento),
    CONSTRAINT FK_InstrutorTreinoEqpCad FOREIGN KEY (id_instrutor)
        REFERENCES funcionario (id_funcionario)
);

CREATE VIEW vw_getid_setor AS
	SELECT id_setor FROM setor
WITH CHECK OPTION;
DROP VIEW vw_getId_setor;

CREATE OR REPLACE VIEW vw_funcionario AS
    SELECT 
        funcionario.id_funcionario,
        funcionario.cpf, 
        concat(funcionario.nome_func," ",funcionario.sobrenome) AS `nome_completo`,
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

CREATE OR REPLACE VIEW vw_dadosfuncionario AS
    SELECT 
        funcionario.id_funcionario,
        funcionario.cpf, 
        funcionario.nome_func,
        funcionario.sobrenome,
        funcionario.telefone,
        funcionario.email,
        funcionario.turno,
        funcionario.cargo,
        setor.sigla AS setor
	FROM
        funcionario
	INNER JOIN
        setor ON funcionario.id_setor = setor.id_setor WITH CHECK OPTION;

CREATE OR REPLACE VIEW vw_Equipe AS
	SELECT
		id_equipe,
		nome_eqp,
        turno
        FROM equipe WITH CHECK OPTION;
DROP VIEW vw_Equipe;

CREATE OR REPLACE VIEW vw_treinamento AS 
	SELECT
		id_treinamento AS id_treino,
		nome_treino AS nome,
		carga_horaria,
		validade
    FROM treinamento WITH CHECK OPTION;
    
CREATE OR REPLACE VIEW vw_setor AS
	SELECT
		sigla
	FROM setor WITH CHECK OPTION;
        
CREATE OR REPLACE VIEW vw_getid_instrutor AS -- nao usado?
    SELECT 
        funcionario.id_funcionario as id_instrutor
    FROM
        funcionario
    WHERE
        funcionario.cargo LIKE 'instrutor';
          
CREATE OR REPLACE VIEW vw_CadFuncEqp AS
    SELECT 
        equipe.id_equipe, funcionario.id_funcionario
    FROM
        cadastro_funcionario_equipe
            RIGHT JOIN
        equipe ON cadastro_funcionario_equipe.id_equipe = equipe.id_equipe
            LEFT JOIN
        funcionario ON cadastro_funcionario_equipe.id_funcionario = funcionario.id_funcionario;
DROP VIEW vw_CadFuncEqp; 

CREATE OR REPLACE VIEW vw_CadEqpTreino AS
    SELECT 
        equipe.id_equipe, 
        treinamento.id_treinamento
    FROM
        cadastro_equipe_treinamento
            LEFT JOIN
        treinamento ON cadastro_equipe_treinamento.id_treinamento = treinamento.id_treinamento
            RIGHT JOIN
        equipe ON cadastro_equipe_treinamento.id_equipe = equipe.id_equipe;
DROP VIEW vw_CadEqpTreino; 

CREATE OR REPLACE VIEW vw_nomeinst AS
	SELECT 
		vw_funcionario.nome_completo,
        vw_funcionario.id_funcionario AS id_inst,
        cadastro_equipe_treinamento.id_treinamento AS treino_id
	FROM
		cadastro_equipe_treinamento
			INNER JOIN 
		vw_funcionario ON vw_funcionario.id_funcionario = cadastro_equipe_treinamento.id_instrutor;
SELECT * FROM vw_nomeinst;
DROP VIEW vw_nomeinst;

-- visualizar nome do treinamento que a equipe do funcionario realizou
CREATE OR REPLACE VIEW vw_treinoFunc AS
	SELECT	
		vw_treinamento.id_treino,
		vw_treinamento.nome,
        vw_cadfunceqp.id_funcionario,
        vw_nomeinst.nome_completo,
        cadastro_equipe_treinamento.prev_fim,
        vw_treinamento.validade
	FROM 
		cadastro_equipe_treinamento
			LEFT JOIN
		vw_treinamento ON cadastro_equipe_treinamento.id_treinamento = vw_treinamento.id_treino
			RIGHT JOIN 
		vw_cadfunceqp ON cadastro_equipe_treinamento.id_equipe = vw_cadfunceqp.id_equipe
			INNER JOIN
		vw_nomeinst ON cadastro_equipe_treinamento.id_treinamento = vw_nomeinst.treino_id;
SELECT * FROM vw_treinoFunc;
DROP VIEW vw_treinoFunc;
-- ///////////////////////////////////////////////////////////////////

-- erro code 1034 para criação de usuarios e permissoes

-- CREATE USER 'nome'@localhost IDENTIFIED BY '12345';
/* ERRO 1194
	GRANT SELECT(id_funcionario, nome_completo, telefone, turno, cargo, setor) 
	ON db_agenda_curso.vw_funcionario TO 'nome'@localhost WITH GRANT OPTION;
*/
-- //////////////////////////////////////////////////////////////////

DELETE FROM cadastro_funcionario_equipe WHERE id_cadastro > 0;
DELETE FROM cadastro_equipe_treinamento WHERE id_cadastro > 0;
DELETE FROM funcionario WHERE id_funcionario > 0;
DELETE FROM equipe WHERE id_equipe > 0;
DELETE FROM treinamento WHERE id_treinamento > 0;

select * from cadastro_funcionario_equipe;
select * from cadastro_equipe_treinamento;

select * from funcionario;
select * from vw_funcionario;
select * from vw_equipe;
select * from vw_treinamento;
select * from vw_setor;
select * from vw_getId_Instrutor;
SELECT * from vw_CadFuncEqp; -- WHERE id_funcionario = 1;
SELECT * FROM vw_CadEqpTreino;

SELECT * FROM vw_treinoFunc WHERE id_funcionario = 1;


-- ////////////////////////////////////////////////////////////

desc vw_treinamento;
desc vw_equipe;
desc equipe;
desc cadastro_equipe_treinamento;
desc cadastro_funcionario_equipe;

-- //////////////////////////////////////////////////////
INSERT INTO usuario(login_usuario, senha, tipo_usuario) VALUES("login", "login", "admin"); -- senha e login padrao
select * from usuario;
select * from vw_funcionario;
select * from funcionario;
TRUNCATE TABLE funcionario;
DELETE FROM funcionario WHERE id_funcionario = 12;
