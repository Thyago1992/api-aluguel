-- ============================================
-- INSERTS PARA TABELA: imoveis
-- ============================================

INSERT INTO imoveis (descricao, endereco) VALUES
('Apartamento 2 quartos centro', 'Rua das Flores, 123 - Centro'),
('Casa 3 quartos com garagem', 'Av. Principal, 456 - Jardim Europa'),
('Kitnet mobiliada', NULL),
('Sobrado 4 quartos', 'Rua dos Pinheiros, 789 - Alto da Boa Vista'),
('Apartamento cobertura', 'Rua do Comércio, 321 - Centro'),
('Casa térrea 2 quartos', NULL),
('Apartamento studio', 'Av. Beira Mar, 654 - Praia Grande'),
('Casa geminada', 'Rua das Acácias, 987 - Vila Nova'),
('Loft reformado', NULL),
('Apartamento 1 quarto', 'Rua São João, 159 - Centro');

-- ============================================
-- INSERTS PARA TABELA: inquilinos
-- ============================================

INSERT INTO inquilinos (nome, email) VALUES
('João Silva Santos', 'joao.silva@email.com'),
('Maria Oliveira Costa', 'maria.oliveira@email.com'),
('Pedro Henrique Alves', NULL),
('Ana Paula Ferreira', 'ana.ferreira@email.com'),
('Carlos Eduardo Lima', NULL),
('Juliana Rodrigues Souza', 'juliana.souza@email.com'),
('Rafael Martins Pereira', 'rafael.pereira@email.com'),
('Fernanda Santos Ribeiro', NULL),
('Lucas Gabriel Dias', 'lucas.dias@email.com'),
('Beatriz Almeida Cardoso', NULL);

-- ============================================
-- INSERTS PARA TABELA: alugueis
-- ============================================

INSERT INTO alugueis (imovel_id, inquilino_id, valor, data_vencimento, pago) VALUES
(3, 7, 1200.00, '2025-09-10', false),
(1, NULL, 1500.00, '2025-08-15', true),
(7, 2, 800.00, '2025-09-05', false),
(10, 5, 950.00, '2025-10-10', false),
(4, 9, 2200.00, NULL, true),
(2, 1, 1800.00, '2025-09-20', false),
(9, NULL, 1100.00, '2025-08-25', false),
(5, 4, 3500.00, '2025-10-05', true),
(6, 8, 1350.00, '2025-09-12', false),
(8, 3, 1650.00, NULL, false);