CREATE TABLE declarante (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cpf_cnpj VARCHAR(20) NOT NULL UNIQUE,
    nome_declarante VARCHAR(255) NOT NULL,
    tipo VARCHAR(10) NOT NULL
);

CREATE TABLE beneficiario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cpf_cnpj VARCHAR(20) NOT NULL UNIQUE,
    nome VARCHAR(255) NOT NULL,
    tipo VARCHAR(10) NOT NULL,
    declarante_id BIGINT NOT NULL,
    CONSTRAINT fk_beneficiario_declarante FOREIGN KEY (declarante_id) REFERENCES declarante(id)
);

CREATE TABLE rendimento (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipo_rendimento VARCHAR(20) NOT NULL,
    valor DECIMAL(15,2) NOT NULL,
    data_pagamento DATE NOT NULL,
    declarante_id BIGINT NOT NULL,
    CONSTRAINT fk_rendimento_declarante FOREIGN KEY (declarante_id) REFERENCES declarante(id)
);
