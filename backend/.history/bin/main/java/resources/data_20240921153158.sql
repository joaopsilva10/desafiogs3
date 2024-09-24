-- Inserir perfil 
INSERT INTO PERFIL (nome) VALUES ('Administrador');
INSERT INTO PERFIL (nome) VALUES ('Sistema');

-- Inserir um usuário com perfil
INSERT INTO USUARIO (nome, nome_usuario, senha, perfil_id) 
VALUES ('Administrador', 'admin', passwordEncoder.encode("admin"), 1);

INSERT INTO USUARIO (nome, nome_usuario, senha, perfil_id) 
VALUES ('Usuário Sistema', 'user', passwordEncoder.encode("user"), 2);