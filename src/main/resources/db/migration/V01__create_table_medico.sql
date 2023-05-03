CREATE TABLE IF NOT EXISTS tb_medico (
    id BIGINT AUTO_INCREMENT,
    nome VARCHAR(70) NOT NULL,
    email VARCHAR(100) NOT NULL,
    crm CHAR(10) NOT NULL UNIQUE,
    especialidade VARCHAR(50) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    complemento VARCHAR(100) DEFAULT 'N/A',
    numero VARCHAR(6),
    cidade VARCHAR(50) NOT NULL,
    uf CHAR(2) NOT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT Charset=utf8;