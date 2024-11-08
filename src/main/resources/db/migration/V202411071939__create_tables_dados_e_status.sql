CREATE TABLE dados (
    id BIGSERIAL NOT NULL,
    peso numeric(5, 2),
    pressao_sistolica numeric(3, 0),
    pressao_diastolica numeric(3, 0),
    glicemia numeric(5, 2),
    frequencia_cardiaca integer,
    sexo character(1) CHECK (sexo IN ('M', 'F')) NOT NULL,
    CONSTRAINT dados_pkey PRIMARY KEY (id)
);

CREATE TABLE status(
    id BIGSERIAL NOT NULL,
    id_usuario bigint NOT NULL,
    id_dados bigint NOT NULL,
    data timestamp NOT NULL,
    CONSTRAINT status_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_fkey FOREIGN KEY(id_usuario) REFERENCES usuario(id),
    CONSTRAINT dados_fkey FOREIGN KEY(id_dados) REFERENCES dados(id)
);