CREATE TABLE usuario(
    id BIGSERIAL NOT NULL,
    nome varchar(100) NOT NULL,
    email varchar(50) NOT NULL,
    password varchar(100) NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id)
);
