create database Agenda_curso_03;
use Agenda_curso_03;

drop database Agenda_curso_02;
CREATE TABLE equipe (
  ID_equipe int(11) primary key NOT NULL AUTO_INCREMENT, -- O que ta na tela figma
  Nome_equipe varchar(50),
  data_criacao timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  Descricao varchar(50),
  setor varchar (50),
  ID_Funcionario_equipe int(11) ,
  id_instrutor_equipe int(11) ,
  FOREIGN KEY (id_instrutor_equipe) REFERENCES instrutor (id_instrutor)
 );



CREATE TABLE funcionario (
  matricula int(11) NOT NULL AUTO_INCREMENT, -- O que ta na tela figma
  nome_funcionario varchar(50) ,
  sobre_nome varchar(50) ,
  Telefone_funcionario int(11) ,
  Email_funcionario varchar(50) ,
  setor enum("Adiministração","Recursos humanos","Recursos financeiros","Automação"),
  turno enum('Matutino','Vespertino','Noturno') ,
  data_adimissao date ,
  cargo_funcionario varchar(50) ,
  CPF int (11),
  PRIMARY KEY (matricula)
); 

CREATE TABLE instrutor (
  id_instrutor int(11) NOT NULL AUTO_INCREMENT,-- O que ta na tela figma
  nome_instrutor varchar(50) ,
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

  Local_treinamento varchar(50) ,
  Treinamento_aplicado varchar(50) ,
  Horario_prev_comeco date ,
  Horario_prev_fim date ,
  id_equipe_treinamento int(11) ,
  id_instrutor_treinamento int(11),
  PRIMARY KEY (id_treinamento),
  FOREIGN KEY (ID_equipe_treinamento) REFERENCES equipe (id_equipe),
  FOREIGN KEY (ID_instrutor_treinamento) REFERENCES instrutor (id_instrutor)
) ;