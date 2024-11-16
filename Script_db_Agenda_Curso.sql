create database db_agenda_curso;
use db_agenda_curso;
DROP DATABASE db_agenda_curso;

CREATE TABLE usuario(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) UNIQUE,
    senha VARCHAR(50),
    tipo_usuario ENUM('admin', 'operador', 'supervisor') DEFAULT 'operador'
);

CREATE TABLE setor (
    id_setor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(20) UNIQUE,
    sigla CHAR(3)
);

CREATE TABLE funcionario (
    id_funcionario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE,
    nome VARCHAR(20),
    sobrenome VARCHAR(30),
    telefone VARCHAR(15),
    email VARCHAR(320) UNIQUE,
    turno ENUM('matutino', 'vespertino', 'noturno'),
    data_adimissao DATE DEFAULT CURRENT_TIMESTAMP,
    cargo ENUM('supervisor', 'instrutor', 'operador'),
    id_setor INT,
    CONSTRAINT FK_SetorFuncionario FOREIGN KEY (id_setor) REFERENCES setor (id_setor)
);

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) UNIQUE,
    senha VARCHAR(50),
    tipo_usuario ENUM('admin', 'operador', 'supervisor') DEFAULT 'operador'
);
DROP TABLE usuarios;

CREATE TABLE equipe (
    id_equipe INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(15) UNIQUE,
    descricao VARCHAR(200),
    turno ENUM('matutino', 'vespertino', 'noturno')
);

CREATE TABLE treinamento (
    id_treinamento INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome_treinamento VARCHAR(30),
    descricao VARCHAR(200),
    carga_horaria INT,
    validade INT
);

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

CREATE VIEW vw_getId_setor AS
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
    
<<<<<<< HEAD
=======
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
          
CREATE OR REPLACE VIEW vw_CadFuncEqp AS -- maturar
	SELECT
        equipe.id_equipe,
        funcionario.id_funcionario
	FROM cadastro_funcionario_equipe
    LEFT JOIN equipe ON cadastro_funcionario_equipe.id_equipe = equipe.id_equipe
    RIGHT JOIN funcionario ON cadastro_funcionario_equipe.id_funcionario = funcionario.id_funcionario;
DROP VIEW vw_CadFuncEqp; 

CREATE OR REPLACE VIEW vw AS
	SELECT 
		treinamento.nome,
        treinamento.validade;
        
-- ///////////////////////////////////////////////////////////////////

-- erro code 1034 para criação de usuarios e permissoes

-- CREATE USER 'nome'@localhost IDENTIFIED BY '12345';
/* ERRO 1194
	GRANT SELECT(id_funcionario, nome_completo, telefone, turno, cargo, setor) 
	ON db_agenda_curso.vw_funcionario TO 'nome'@localhost WITH GRANT OPTION;
*/
-- //////////////////////////////////////////////////////////////////
    
>>>>>>> 35ef3e234012f2009d2ba8032a6812f1031013d0
select * from cadastro_funcionario_equipe;
DELETE FROM cadastro_funcionario_equipe WHERE id_cadastro > 0;

select * from vw_funcionario;


<<<<<<< HEAD

    
=======
desc vw_treinamento;
desc vw_equipe;

desc cadastro_equipe_treinamento;
desc cadastro_funcionario_equipe;
-- //////////////////////////////////////////////////////
INSERT INTO usuario(usuario, senha) VALUES("login", "login"); -- senha e login padrao
select * from usuario;
>>>>>>> 35ef3e234012f2009d2ba8032a6812f1031013d0
