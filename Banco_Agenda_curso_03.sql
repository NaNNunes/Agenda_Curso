create database Agenda_curso_02;
use Agenda_curso_02;

CREATE TABLE equipe (
  ID_equipe int(11) primary key NOT NULL AUTO_INCREMENT, -- O que ta na tela figma
  Nome_equipe varchar(50),
  data_criacao date,
  Descricao varchar(50),
  setor varchar (50),
  Matricula_equipe int(11) DEFAULT NULL,
  id_instrutor_equipe int(11) DEFAULT NULL,
 FOREIGN KEY (id_instrutor_equipe) REFERENCES instrutor (id_instrutor),
 FOREIGN KEY (Matricula_equipe) REFERENCES funcionario (matricula)
);



CREATE TABLE funcionario (
  matricula int(11) NOT NULL AUTO_INCREMENT, -- O que ta na tela figma
  nome_funcionario varchar(50) DEFAULT NULL,
  sobre_nome varchar(50) DEFAULT NULL,
  Telefone_funcionario int(11) DEFAULT NULL,
  Email_funcionario varchar(50) DEFAULT NULL,
  setor varchar(50) DEFAULT NULL,
  turno enum('Matutino','Vespertino','Noturno') DEFAULT NULL,
  data_adimissao date DEFAULT NULL,
  cargo_funcionario varchar(50) DEFAULT NULL,
  CPF int (11),
  PRIMARY KEY (matricula)
); 

CREATE TABLE instrutor (
  id_instrutor int(11) NOT NULL AUTO_INCREMENT,-- O que ta na tela figma
  nome_instrutor varchar(50) DEFAULT NULL,
  CPF_instrutor int(11),
  SobreNome_instrutor varchar (50),
  Telefone_Instrutor int (12),
  PRIMARY KEY (id_instrutor)
); 



CREATE TABLE treinamento (
  id_treinamento int(11) NOT NULL AUTO_INCREMENT,
  nome_treinamento varchar (50),
  Descricao_treinamento varchar (50),
   Formato_treinamento varchar (50),
Validade_treinamento int (3), -- o que ta na tela figma

  Local_treinamento varchar(50) DEFAULT NULL,
  Treinamento_aplicado varchar(50) DEFAULT NULL,
  Horario_prev_comeco date DEFAULT NULL,
  Horario_prev_fim date DEFAULT NULL,
  id_equipe_treinamento int(11) DEFAULT NULL,
  id_instrutor_treinamento int(11) DEFAULT NULL,
  PRIMARY KEY (id_treinamento),
  FOREIGN KEY (ID_equipe_treinamento) REFERENCES equipe (id_equipe),
  FOREIGN KEY (ID_instrutor_treinamento) REFERENCES instrutor (id_instrutor)
) ;