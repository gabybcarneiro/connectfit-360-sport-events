INSERT INTO sports.eventos (id, nome, data_evento, cidade, estado, pais, tipo, modalidade, data_inclusao, data_alteracao, usuario_inclusao, usuario_alteracao) VALUES (1, 'Black Murrah', '2026-05-31 08:00:00.000000', 'Paraguaçu Paulista', 'SP', 'Brasil', 1, 'CORRIDA', '2026-04-22', null, 'gabriela', null)
    [


INSERT INTO sports.modalidade_evento (id, descricao) VALUES (1, 'CORRIDA');
INSERT INTO sports.modalidade_evento (id, descricao) VALUES (2, 'BIKE');
INSERT INTO sports.modalidade_evento (id, descricao) VALUES (3, 'VOLEI');
INSERT INTO sports.modalidade_evento (id, descricao) VALUES (4, 'TENIS');
INSERT INTO sports.modalidade_evento (id, descricao) VALUES (5, 'NATACAO');
INSERT INTO sports.modalidade_evento (id, descricao) VALUES (6, 'TRIATHLON');


INSERT INTO sports.eventos (nome, data_evento, cidade, estado, pais, id_tipo, id_modalidade, data_inclusao, data_alteracao, usuario_inclusao, usuario_alteracao, id_organizacao, imagem_evento, inscricao_aberta, vagas, vagas_disponiveis) VALUES ('Black murrah', '2026-04-30 16:19:14.000000', 'Assis', 'SP', 'BRasil', 1, 1, '2026-04-27 16:19:37.000000', null, 'gabriela', null, 1, null, true, 20, 5)
