-- INSERÇÃO DE ESPÉCIES
INSERT INTO tb_especie (nome) VALUES
('Cachorro'),
('Gato'),
('Pássaro'),
('Coelho');

-- INSERÇÃO DE RAÇAS
INSERT INTO tb_raca (nome, id_especie) VALUES
('Labrador', 1),
('Poodle', 1),
('Bulldog', 1),
('Vira-lata', 1),
('Beagle', 1),

('Siamês', 2),
('Persa', 2),
('Angorá', 2),
('Vira-lata', 2),

('Calopsita', 3),
('Canário', 3),
('Periquito', 3),

('Lionhead', 4),
('Netherland Dwarf', 4),
('Mini Rex', 4);

-- INSERÇÃO DE ONGs
INSERT INTO tb_ong (nome, cnpj, data_fundacao, ativa, telefone, email) VALUES
('Amor Animal', '12345678000101', '2012-05-14', TRUE, '(11)99999-0001', 'contato@amoranimal.org'),
('Patas Felizes', '12345678000102', '2015-08-09', TRUE, '(11)99999-0002', 'info@patasfelizes.org'),
('Lar dos Peludos', '12345678000103', '2010-03-22', TRUE, '(11)99999-0003', 'contato@lardospeludos.org'),
('Vida Selvagem', '12345678000104', '2018-09-11', TRUE, '(11)99999-0004', 'admin@vidaselvagem.org'),
('Refúgio Animal', '12345678000105', '2016-01-30', TRUE, '(11)99999-0005', 'refugio@refugioanimal.org');

-- ENDEREÇOS DAS ONGs (1 a 3 cada)
INSERT INTO tb_endereco_ong (logradouro, numero, bairro, cidade, estado, inscricao_municipal, id_ong) VALUES
('Rua Flores', '100', 'Centro', 'São Paulo', 'SP', '12345', 1),
('Av. Verde', '250', 'Jardins', 'São Paulo', 'SP', '12346', 1),

('Rua das Rosas', '30', 'Santa Luzia', 'Campinas', 'SP', '22345', 2),

('Av. Brasil', '400', 'Centro', 'Santos', 'SP', '32345', 3),
('Rua do Sol', '55', 'Ponta da Praia', 'Santos', 'SP', '32346', 3),

('Rua das Palmeiras', '88', 'Centro', 'Guarulhos', 'SP', '42345', 4),

('Rua Esperança', '101', 'Centro', 'Osasco', 'SP', '52345', 5),
('Av. Azul', '202', 'Vila Nova', 'Osasco', 'SP', '52346', 5),
('Rua Marrom', '303', 'Jardim Bela Vista', 'Osasco', 'SP', '52347', 5);

-- INSERÇÃO DE ADOTANTES (50)
INSERT INTO tb_adotante (nome, idade, cpf, email, telefone) VALUES
('Ana Souza', 29, '11111111111', 'ana@example.com', '11911111111'),
('Bruno Lima', 34, '22222222222', 'bruno@example.com', '11922222222'),
('Carla Mendes', 26, '33333333333', 'carla@example.com', '11933333333'),
('Daniel Rocha', 41, '44444444444', 'daniel@example.com', '11944444444'),
('Eduarda Pires', 22, '55555555555', 'eduarda@example.com', '11955555555'),
('Felipe Gomes', 37, '66666666666', 'felipe@example.com', '11966666666'),
('Gabriela Nunes', 31, '77777777777', 'gabriela@example.com', '11977777777'),
('Henrique Silva', 28, '88888888888', 'henrique@example.com', '11988888888'),
('Isabela Castro', 25, '99999999999', 'isabela@example.com', '11999999999'),
('João Almeida', 30, '10101010101', 'joao@example.com', '11910101010'),
('Karen Duarte', 27, '11111111112', 'karen@example.com', '11911111112'),
('Lucas Martins', 35, '12121212121', 'lucas@example.com', '11912121212'),
('Mariana Lopes', 24, '13131313131', 'mariana@example.com', '11913131313'),
('Nicolas Pinto', 29, '14141414141', 'nicolas@example.com', '11914141414'),
('Olívia Reis', 33, '15151515151', 'olivia@example.com', '11915151515'),
('Paulo César', 40, '16161616161', 'paulo@example.com', '11916161616'),
('Quésia Andrade', 32, '17171717171', 'quesia@example.com', '11917171717'),
('Rafael Souza', 26, '18181818181', 'rafael@example.com', '11918181818'),
('Sabrina Moura', 27, '19191919191', 'sabrina@example.com', '11919191919'),
('Thiago Farias', 36, '20202020202', 'thiago@example.com', '11920202020'),
('Ursula Ramos', 23, '21212121212', 'ursula@example.com', '11921212121'),
('Vinícius Teles', 38, '22222222223', 'vinicius@example.com', '11922222223'),
('Wagner Duarte', 45, '23232323232', 'wagner@example.com', '11923232323'),
('Xênia Costa', 29, '24242424242', 'xenia@example.com', '11924242424'),
('Yasmin Teixeira', 20, '25252525252', 'yasmin@example.com', '11925252525'),
('Zeca Amorim', 43, '26262626262', 'zeca@example.com', '11926262626'),
('Arthur Melo', 28, '27272727272', 'arthur@example.com', '11927272727'),
('Beatriz Ramos', 35, '28282828282', 'beatriz@example.com', '11928282828'),
('Caio Freitas', 24, '29292929292', 'caio@example.com', '11929292929'),
('Diana Torres', 39, '30303030303', 'diana@example.com', '11930303030'),
('Elias Rocha', 25, '31313131313', 'elias@example.com', '11931313131'),
('Fernanda Leal', 31, '32323232323', 'fernanda@example.com', '11932323232'),
('Gustavo Matos', 29, '33333333334', 'gustavo@example.com', '11933333334'),
('Helena Prado', 27, '34343434343', 'helena@example.com', '11934343434'),
('Ian Ribeiro', 40, '35353535353', 'ian@example.com', '11935353535'),
('Júlia Moraes', 21, '36363636363', 'julia@example.com', '11936363636'),
('Kevin Moreira', 33, '37373737373', 'kevin@example.com', '11937373737'),
('Larissa Gomes', 28, '38383838383', 'larissa@example.com', '11938383838'),
('Mateus Nogueira', 35, '39393939393', 'mateus@example.com', '11939393939'),
('Natália Luz', 23, '40404040404', 'natalia@example.com', '11940404040'),
('Otávio Melo', 27, '41414141414', 'otavio@example.com', '11941414141'),
('Priscila Cunha', 30, '42424242424', 'priscila@example.com', '11942424242'),
('Renato Brito', 42, '43434343434', 'renato@example.com', '11943434343'),
('Sofia Pacheco', 22, '44444444445', 'sofia@example.com', '11944444445'),
('Talita Silva', 29, '45454545454', 'talita@example.com', '11945454545'),
('Ulisses Neves', 37, '46464646464', 'ulisses@example.com', '11946464646'),
('Vera Cruz', 41, '47474747474', 'vera@example.com', '11947474747'),
('Wesley Dias', 28, '48484848484', 'wesley@example.com', '11948484848'),
('Yuri Campos', 32, '49494949494', 'yuri@example.com', '11949494949'),
('Zuleica Prado', 30, '50505050505', 'zuleica@example.com', '11950505050');

-- ENDEREÇOS DOS ADOTANTES (1 ou 2 cada)
INSERT INTO tb_endereco_adotante (logradouro, numero, bairro, cidade, estado, id_adotante) VALUES
('Rua A', '10', 'Centro', 'São Paulo', 'SP', 1),
('Av. B', '20', 'Centro', 'São Paulo', 'SP', 1),
('Rua C', '30', 'Jardins', 'Campinas', 'SP', 2),
('Rua D', '40', 'Centro', 'Santos', 'SP', 3),
('Av. E', '50', 'Centro', 'São Paulo', 'SP', 4),
('Rua F', '60', 'Vila Nova', 'São Paulo', 'SP', 5),
('Av. G', '70', 'Centro', 'Campinas', 'SP', 6),
('Rua H', '80', 'Centro', 'Santos', 'SP', 7),
('Av. I', '90', 'Jardim', 'Guarulhos', 'SP', 8),
('Rua J', '100', 'Centro', 'Osasco', 'SP', 9),
('Rua K', '110', 'Centro', 'Osasco', 'SP', 9),
('Rua L', '120', 'Centro', 'Santos', 'SP', 10);

-- INSERÇÃO DE PETS (30)
INSERT INTO tb_pet (nome, foto_url, idade_aproximada, porte, sexo, descricao, id_raca, id_ong) VALUES
('Rex', 'rex.jpg', 3, 'Grande', 'Macho', 'Cachorro dócil e brincalhão', 1, 1),
('Luna', 'luna.jpg', 2, 'Médio', 'Fêmea', 'Muito carinhosa', 2, 1),
('Toby', 'toby.jpg', 4, 'Pequeno', 'Macho', 'Adora passear', 3, 1),
('Mia', 'mia.jpg', 1, 'Pequeno', 'Fêmea', 'Curiosa e esperta', 6, 2),
('Tom', 'tom.jpg', 2, 'Médio', 'Macho', 'Sociável com outros gatos', 7, 2),
('Bidu', 'bidu.jpg', 5, 'Pequeno', 'Macho', 'Vira-lata fiel', 4, 3),
('Nina', 'nina.jpg', 2, 'Médio', 'Fêmea', 'Adora crianças', 5, 3),
('Mel', 'mel.jpg', 3, 'Pequeno', 'Fêmea', 'Gosta de colo', 8, 2),
('Cacau', 'cacau.jpg', 1, 'Pequeno', 'Macho', 'Brincalhão', 9, 2),
('Pipoca', 'pipoca.jpg', 2, 'Pequeno', 'Fêmea', 'Muito ativa', 10, 4),
('Sol', 'sol.jpg', 1, 'Pequeno', 'Macho', 'Adora cantar', 11, 4),
('Blue', 'blue.jpg', 3, 'Pequeno', 'Macho', 'Periquito falante', 12, 4),
('Snow', 'snow.jpg', 2, 'Pequeno', 'Fêmea', 'Coelho dócil', 13, 5),
('Floco', 'floco.jpg', 1, 'Pequeno', 'Macho', 'Muito fofo', 14, 5),
('Bunny', 'bunny.jpg', 2, 'Pequeno', 'Fêmea', 'Adora carinho', 15, 5),
('Spike', 'spike.jpg', 4, 'Grande', 'Macho', 'Protetor e leal', 1, 1),
('Lola', 'lola.jpg', 3, 'Médio', 'Fêmea', 'Brincalhona e esperta', 2, 1),
('Thor', 'thor.jpg', 2, 'Grande', 'Macho', 'Cheio de energia', 1, 1),
('Nala', 'nala.jpg', 3, 'Médio', 'Fêmea', 'Mansa e carinhosa', 7, 2),
('Bob', 'bob.jpg', 5, 'Pequeno', 'Macho', 'Vira-lata curioso', 4, 3),
('Pingo', 'pingo.jpg', 2, 'Pequeno', 'Macho', 'Muito sociável', 12, 4),
('Cookie', 'cookie.jpg', 1, 'Pequeno', 'Fêmea', 'Calopsita dócil', 10, 4),
('Milo', 'milo.jpg', 3, 'Médio', 'Macho', 'Ativo e curioso', 6, 2),
('Teka', 'teka.jpg', 1, 'Pequeno', 'Fêmea', 'Muito dócil', 15, 5),
('Bolt', 'bolt.jpg', 4, 'Grande', 'Macho', 'Muito energético', 1, 1),
('Simba', 'simba.jpg', 3, 'Médio', 'Macho', 'Afetuoso', 7, 2),
('Kiara', 'kiara.jpg', 2, 'Pequeno', 'Fêmea', 'Carinhosa', 8, 2),
('Fred', 'fred.jpg', 3, 'Médio', 'Macho', 'Curioso e dócil', 9, 2),
('Susi', 'susi.jpg', 2, 'Pequeno', 'Fêmea', 'Gosta de atenção', 3, 1),
('Tico', 'tico.jpg', 1, 'Pequeno', 'Macho', 'Canário alegre', 11, 4);

-- INSERÇÃO DE ADOÇÕES (10 pets adotados por adotantes diferentes)
INSERT INTO tb_adocao (data_adocao, id_adotante, id_pet) VALUES
('2023-01-15', 1, 1),
('2023-02-20', 2, 4),
('2023-03-05', 3, 5),
('2023-04-10', 4, 6),
('2023-05-22', 5, 9),
('2023-06-12', 6, 10),
('2023-07-07', 7, 12),
('2023-08-18', 8, 14),
('2023-09-29', 9, 18),
('2023-10-30', 10, 20);
