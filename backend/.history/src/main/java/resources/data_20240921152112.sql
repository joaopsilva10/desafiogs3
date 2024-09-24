-- Criação da tabela PERFIL
CREATE TABLE PERFIL (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Criação da tabela USUARIO
CREATE TABLE USUARIO (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    login VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    perfil_id BIGINT,
    CONSTRAINT fk_perfil FOREIGN KEY (perfil_id) REFERENCES PERFIL(id) ON DELETE SET NULL
);

-- Inserir perfil 
INSERT INTO PERFIL (nome) VALUES ('Administrador');
INSERT INTO PERFIL (nome) VALUES ('Sistema');

-- Inserir um usuário com perfil
INSERT INTO USUARIO (nome, login, senha, perfil_id) 
VALUES ('Administrador', 'admin', passwordEncoder.encode("admin"), 1);

INSERT INTO USUARIO (nome, login, senha, perfil_id) 
VALUES ('Usuário Sistema', 'user', passwordEncoder.encode("user"), 2);