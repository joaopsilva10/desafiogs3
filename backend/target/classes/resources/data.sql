-- Inserir perfil 
INSERT INTO PERFIL (nome) VALUES ('Administrador');
INSERT INTO PERFIL (nome) VALUES ('Sistema');

-- Inserir um usuário com perfil
INSERT INTO USUARIO (nome, login, senha, perfil_id) 
VALUES ('Administrador', 'admin', '$2a$10$Y/VAUSVHYuXp/qoAOssiQ.fng/WCiWFNhQ7CAkV3ZVp/Mvf7vQIaq', 1);

INSERT INTO USUARIO (nome, login, senha, perfil_id) 
VALUES ('Usuário Sistema', 'user', '$2a$10$Bf/JLqwO/tvithUUhqNwv.jMTzkmI3D7LlpuWX6cY9uvrSqIJ23hq', 2);