ALTER TABLE tb_medico ADD COLUMN ativo TINYINT(0);
UPDATE tb_medico SET ativo = 1;