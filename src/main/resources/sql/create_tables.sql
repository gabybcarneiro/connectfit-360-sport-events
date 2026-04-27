create table sports.modalidade_evento
(
    id          integer not null,
    descricao   varchar not null,
    data_inc    timestamp DEFAULT statement_timestamp() NOT NULL  ,
    usuario_inc varchar(50)   NOT NULL
);

comment on column sports.modalidade_evento.id is 'Identificador de modalidade de evento';

--  TABELA DE USUARIO
CREATE  TABLE usuario (
    id_usuario           integer  NOT NULL GENERATED  BY DEFAULT AS IDENTITY ,
    nome                 varchar(50)  NOT NULL  ,
    email                varchar(100)  NOT NULL  ,
    login                varchar(100)  NOT NULL  ,
    senha                varchar(200)  NOT NULL  ,
    telefone             varchar(11)    ,
    telefone_whatsapp    varchar(11)    ,
    ativo                boolean  NOT NULL  ,
    id_usuario_inclusao  integer  NOT NULL  ,
    id_usuario_alteracao integer  NOT NULL  ,
    data_inclusao   timestamp DEFAULT statement_timestamp() NOT NULL  ,
    data_alteracao timestamp DEFAULT statement_timestamp() NOT NULL  ,
    CONSTRAINT pk_usuario PRIMARY KEY ( id_usuario ),
    CONSTRAINT unq_usuario_login UNIQUE ( login ) ,
    CONSTRAINT unq_usuario_email UNIQUE ( email )
);