CREATE TABLE IF NOT EXISTS tb_user (
    id BIGINT AUTO_INCREMENT,
    login VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(200) NOT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT Charset=UTF8MB4;