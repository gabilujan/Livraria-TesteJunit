-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24-Out-2023 às 16:04
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `livraria`
--
Create Database `livraria`;
use `livraria`;
-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `Cod_Cli` int(11) NOT NULL,
  `Nome_Cli` varchar(80) NOT NULL,
  `Tel_Cli` varchar(20) NOT NULL,
  `Email_Cli` varchar(80) NOT NULL,
  `CPF_Cli` varchar(14) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`Cod_Cli`, `Nome_Cli`, `Tel_Cli`, `Email_Cli`, `CPF_Cli`) VALUES
(1, 'Yasmin Souza', '(11) 99999-9999', 'souza156@gmail.com', '496.300.258-24'),
(2, 'Otavio Nunes', '(11) 96692-1015', 'nunesotavio@outlook.com', '936.599.302-18'),
(3, 'Carlos Souza', '(11) 98632-2015', 'carlos99@gmail.com', '225.630.268-21'),
(4, 'Amanda Oliveira', '(11) 95555-1234', 'amanda.oliveira@email.com', '123.456.789-10'),
(5, 'Ricardo Silva', '(11) 94444-5678', 'ricardo.silva@email.com', '234.567.890-12'),
(6, 'Lucia Santos', '(11) 91111-1111', 'lucia.santos@email.com', '333.444.555-67'),
(7, 'Fernando Pereira', '(11) 92222-2222', 'fernando.pereira@email.com', '444.555.666-78'),
(8, 'Marta Oliveira', '(11) 98888-8888', 'marta.oliveira@email.com', '777.888.999-01'),
(9, 'João Santos', '(11) 97777-7777', 'joao.santos@email.com', '888.999.000-12'),
(10, 'Gabriel Souza', '(11) 96666-6666', 'gabriel.souza@email.com', '999.000.111-23'),
(11, 'Camila Silva', '(11) 95555-5555', 'camila.silva@email.com', '000.111.222-34'),
(12, 'Ana Oliveira', '(11) 93333-3333', 'ana.oliveira@email.com', '111.222.333-45'),
(13, 'Marcos Pereira', '(11) 94444-4444', 'marcos.pereira@email.com', '222.333.444-56'),
(14, 'Juliana Santos', '(11) 95555-8888', 'juliana.santos@email.com', '333.444.555-67'),
(15, 'Eduardo Souza', '(11) 96666-9999', 'eduardo.souza@email.com', '444.555.666-78'),
(16, 'Patricia Silva', '(11) 97777-1111', 'patricia.silva@email.com', '555.666.777-89'),
(17, 'Roberto Oliveira', '(11) 98888-2222', 'roberto.oliveira@email.com', '666.777.888-90'),
(18, 'Sandra Santos', '(11) 99999-3333', 'sandra.santos@email.com', '777.888.999-01'),
(19, 'Felipe Pereira', '(11) 91111-4444', 'felipe.pereira@email.com', '888.999.000-12'),
(20, 'Camila Souza', '(11) 92222-5555', 'camila.souza@email.com', '999.000.111-23'),
(21, 'Lucas Silva', '(11) 93333-6666', 'lucas.silva@email.com', '000.111.222-34'),
(22, 'Cristiane Oliveira', '(11) 91111-1111', 'cristiane.oliveira@email.com', '111.222.333-45'),
(23, 'Rafael Pereira', '(11) 92222-2222', 'rafael.pereira@email.com', '222.333.444-56'),
(24, 'Vanessa Santos', '(11) 93333-3333', 'vanessa.santos@email.com', '333.444.555-67'),
(25, 'Rodrigo Souza', '(11) 94444-4444', 'rodrigo.souza@email.com', '444.555.666-78'),
(26, 'Aline Silva', '(11) 95555-5555', 'aline.silva@email.com', '555.666.777-89'),
(27, 'Fernando Oliveira', '(11) 96666-6666', 'fernando.oliveira@email.com', '666.777.888-90'),
(28, 'Carla Santos', '(11) 97777-7777', 'carla.santos@email.com', '777.888.999-01'),
(29, 'Mateus Pereira', '(11) 98888-8888', 'mateus.pereira@email.com', '888.999.000-12'),
(30, 'Priscila Souza', '(11) 99999-9999', 'priscila.souza@email.com', '999.000.111-23'),
(31, 'Tiago Silva', '(11) 91111-1111', 'tiago.silva@email.com', '000.111.222-34'),
(32, 'Mariana Oliveira', '(11) 92222-2222', 'mariana.oliveira@email.com', '111.222.333-45'),
(33, 'Robson Pereira', '(11) 93333-3333', 'robson.pereira@email.com', '222.333.444-56'),
(34, 'Jessica Santos', '(11) 94444-4444', 'jessica.santos@email.com', '333.444.555-67'),
(35, 'Erick Souza', '(11) 95555-5555', 'erick.souza@email.com', '444.555.666-78'),
(36, 'Amanda Silva', '(11) 96666-6666', 'amanda.silva@email.com', '555.666.777-89'),
(37, 'Vinicius Oliveira', '(11) 97777-7777', 'vinicius.oliveira@email.com', '666.777.888-90'),
(38, 'Leticia Santos', '(11) 98888-8888', 'leticia.santos@email.com', '777.888.999-01'),
(39, 'Ricardo Pereira', '(11) 99999-9999', 'ricardo.pereira@email.com', '888.999.000-12'),
(40, 'Isabel Souza', '(11) 91111-1111', 'isabel.souza@email.com', '999.000.111-23'),
(41, 'Gabriela Silva', '(11) 92222-2222', 'gabriela.silva@email.com', '000.111.222-34'),
(42, 'Luciano Oliveira', '(11) 98888-8888', 'luciano.oliveira@email.com', '111.222.333-45'),
(43, 'Natalia Pereira', '(11) 97777-7777', 'natalia.pereira@email.com', '222.333.444-56'),
(44, 'Vitor Santos', '(11) 96666-6666', 'vitor.santos@email.com', '333.444.555-67'),
(45, 'Daniela Souza', '(11) 95555-5555', 'daniela.souza@email.com', '444.555.666-78'),
(46, 'Gustavo Silva', '(11) 94444-4444', 'gustavo.silva@email.com', '555.666.777-89'),
(47, 'Carolina Oliveira', '(11) 93333-3333', 'carolina.oliveira@email.com', '666.777.888-90'),
(48, 'Rafaela Pereira', '(11) 92222-2222', 'rafaela.pereira@email.com', '777.888.999-01'),
(49, 'Thiago Santos', '(11) 91111-1111', 'thiago.santos@email.com', '888.999.000-12'),
(50, 'Juliano Souza', '(11) 91111-1111', 'juliano.souza@email.com', '999.000.111-23'),
(51, 'Renata Silva', '(11) 93333-3333', 'renata.silva@email.com', '000.111.222-34');

-- --------------------------------------------------------

--
-- Estrutura da tabela `compra`
--

CREATE TABLE `compra` (
  `Cod_Comp` int(11) NOT NULL,
  `Id_Ven` int(11) NOT NULL,
  `Id_Liv` int(11) NOT NULL,
  `Qtd_com` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `compra`
--

INSERT INTO `compra` (`Cod_Comp`, `Id_Ven`, `Id_Liv`, `Qtd_com`) VALUES
(1, 1, 1, 3),
(2, 2, 2, 4),
(3, 3, 3, 5),
(4, 3, 4, 55555),
(5, 3, 5, 55555),
(6, 3, 6, 55555),
(7, 3, 7, 55555),
(8, 3, 8, 55555),
(9, 3, 9, 55555),
(10, 3, 10, 55555),
(11, 3, 11, 55555),
(12, 3, 12, 55555),
(13, 3, 13, 55555),
(14, 3, 14, 55555),
(15, 3, 15, 55555),
(16, 3, 16, 55555),
(17, 3, 17, 55555),
(18, 3, 22222, 55555),
(19, 3, 22222, 55555),
(20, 3, 22222, 55555),
(21, 3, 22222, 55555),
(22, 3, 22222, 55555),
(23, 3, 22222, 55555),
(24, 3, 22222, 55555),
(25, 3, 22222, 55555),
(26, 3, 22222, 55555),
(27, 3, 22222, 55555),
(28, 3, 22222, 55555),
(29, 3, 22222, 55555),
(30, 3, 22222, 55555),
(31, 3, 22222, 55555),
(32, 3, 22222, 55555),
(33, 3, 22222, 55555),
(34, 3, 22222, 55555),
(35, 3, 22222, 55555),
(36, 3, 22222, 55555),
(37, 3, 22222, 55555),
(38, 3, 22222, 55555),
(39, 3, 22222, 55555),
(40, 3, 22222, 55555),
(41, 3, 22222, 55555),
(42, 3, 22222, 55555),
(43, 3, 22222, 55555),
(44, 3, 22222, 55555),
(45, 3, 22222, 55555),
(46, 3, 22222, 55555),
(47, 3, 22222, 55555),
(48, 3, 22222, 55555),
(49, 3, 22222, 55555),
(50, 3, 22222, 55555),
(51, 3, 22222, 55555),
(52, 3, 22222, 55555),
(53, 3, 22222, 55555),
(54, 3, 22222, 55555),
(55, 3, 22222, 55555),
(56, 3, 22222, 55555),
(57, 3, 22222, 55555),
(58, 3, 22222, 55555),
(59, 3, 22222, 55555),
(60, 3, 22222, 55555),
(61, 3, 22222, 55555),
(62, 3, 22222, 55555),
(63, 3, 22222, 55555),
(64, 3, 22222, 55555),
(65, 3, 22222, 55555),
(66, 3, 22222, 55555),
(67, 3, 22222, 55555),
(68, 3, 22222, 55555),
(69, 3, 22222, 55555),
(70, 3, 22222, 55555),
(71, 3, 22222, 55555),
(72, 3, 22222, 55555),
(73, 3, 22222, 55555),
(74, 3, 22222, 55555),
(75, 3, 22222, 55555),
(76, 3, 22222, 55555),
(77, 3, 22222, 55555),
(78, 3, 22222, 55555),
(79, 3, 22222, 55555),
(80, 3, 22222, 55555);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `Cod_Func` int(11) NOT NULL,
  `Nome_Fun` varchar(80) NOT NULL,
  `CPF_Fun` varchar(14) NOT NULL,
  `Email_Fun` varchar(80) NOT NULL,
  `Endereço_Fun` varchar(100) NOT NULL,
  `Tel_Fun` varchar(14) NOT NULL,
  `Cargo` varchar(30) NOT NULL,
  `Usuario` varchar(40) NOT NULL,
  `Senha` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`Cod_Func`, `Nome_Fun`, `CPF_Fun`, `Email_Fun`, `Endereço_Fun`, `Tel_Fun`, `Cargo`, `Usuario`, `Senha`) VALUES
(1, 'Camilla Santos', '48699025824', 'camillasantos@gmail.com', 'rua peres silva', '953097836', 'Secretaria', 'A', '123'),
(2, 'Renato Lima', '06530285690', 'limarenato@gmail.com', 'Avenida paulista 123', '973653393', 'Caixa', 'B', '123'),
(3, 'Tatiane Marquezine', '02344598621', 'tatiane123@hotmail.com', 'Rua alecrim', '963024962', 'Balconista', 'C', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
--

CREATE TABLE `livro` (
  `Cod_Liv` int(11) NOT NULL,
  `Titulo` varchar(50) NOT NULL,
  `Categoria` varchar(40) NOT NULL,
  `ISBN` varchar(18) NOT NULL,
  `Idioma` varchar(15) NOT NULL,
  `Qtde_Pg` int(11) NOT NULL,
  `Preço` float NOT NULL,
  `Qtd_Est` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `livro`
--

INSERT INTO `livro` (`Cod_Liv`, `Titulo`, `Categoria`, `ISBN`, `Idioma`, `Qtde_Pg`, `Preço`, `Qtd_Est`) VALUES
(1, 'Romeu & Julieta', 'Romance', '978-3869711423', 'Português', 175, 39.99, 15),
(2, 'Arte da Guerra', 'Estratégia', '978-0140439199', 'Português', 120, 15.99, 60),
(3, 'Harry Potter e a Pedra Filosofal', 'Magia', '978-0807286005', 'Português', 220, 59.99, 22),
(4, '1984', 'Ficção Científica', '978-0451524935', 'Português', 328, 25.99, 45),
(5, 'Dom Quixote', 'Ficção', '978-0060934347', 'Português', 992, 30.99, 18),
(6, 'Crime e Castigo', 'Ficção', '978-0198709711', 'Português', 608, 20.99, 30),
(7, 'Cem Anos de Solidão', 'Ficção', '978-8535928045', 'Português', 448, 35.99, 25),
(8, 'Moby Dick', 'Aventura', '978-0142437247', 'Português', 720, 22.99, 40),
(9, 'O Senhor dos Anéis', 'Fantasia', '978-0345339706', 'Português', 1178, 50.99, 12),
(10, 'A Revolução dos Bichos', 'Ficção', '978-0451526342', 'Português', 144, 18.99, 70),
(11, 'O Alquimista', 'Ficção', '978-0062315007', 'Português', 208, 28.99, 38),
(12, 'A Culpa é das Estrelas', 'Romance', '978-0062348678', 'Português', 336, 24.99, 20),
(13, 'O Código Da Vinci', 'Suspense', '978-0307474278', 'Português', 592, 29.99, 28),
(14, 'O Pequeno Príncipe', 'Fábula', '978-8572329503', 'Português', 96, 15.99, 50),
(15, 'O Hobbit', 'Fantasia', '978-8535915229', 'Português', 328, 27.99, 15),
(16, 'Ensaio Sobre a Cegueira', 'Ficção', '978-8535916820', 'Português', 312, 32.99, 23),
(17, 'A Menina que Roubava Livros', 'Ficção', '978-8535912662', 'Português', 480, 26.99, 35),
(18, 'A Dança dos Dragões', 'Fantasia', '978-8598078949', 'Português', 640, 42.99, 10),
(19, 'A Metamorfose', 'Ficção', '978-8573263670', 'Português', 192, 18.99, 42),
(20, 'O Iluminado', 'Horror', '978-0451160916', 'Português', 688, 30.99, 28),
(21, 'O Nome do Vento', 'Fantasia', '978-8580574421', 'Português', 672, 35.99, 20),
(22, 'A Hospedeira', 'Ficção Científica', '978-0062024043', 'Português', 560, 28.99, 33),
(23, 'O Silmarillion', 'Fantasia', '978-8578277169', 'Português', 480, 40.99, 15),
(24, 'O Último Desejo', 'Fantasia', '978-8532525979', 'Português', 288, 25.99, 25),
(25, 'A Roda do Tempo', 'Fantasia', '978-8528613686', 'Português', 704, 45.99, 10),
(26, 'As Crônicas de Nárnia', 'Fantasia', '978-8578277107', 'Português', 752, 38.99, 18),
(27, 'Os Miseráveis', 'Romance', '978-9726083504', 'Português', 1232, 36.99, 22),
(28, 'A Sombra do Vento', 'Ficção', '978-9722529443', 'Português', 464, 34.99, 20),
(29, 'A Batalha do Labirinto', 'Fantasia', '978-8598078963', 'Português', 368, 22.99, 30),
(30, 'O Clube do Livro do Fim da Vida', 'Ficção', '978-8528616625', 'Português', 272, 28.99, 28),
(31, 'Eu Sou o Mensageiro', 'Ficção', '978-8576570145', 'Português', 360, 26.99, 35),
(32, 'A Revolta de Atlas', 'Ficção', '978-8598078161', 'Português', 1200, 40.99, 12),
(33, 'O Senhor das Moscas', 'Ficção', '978-0061120084', 'Português', 224, 18.99, 55),
(34, 'Memórias Póstumas de Brás Cubas', 'Ficção', '978-8535916714', 'Português', 256, 22.99, 48),
(35, 'O Apanhador no Campo de Centeio', 'Ficção', '978-0316769488', 'Português', 288, 20.99, 50),
(36, 'O Retrato de Dorian Gray', 'Ficção', '978-8572322436', 'Português', 272, 24.99, 42),
(37, 'O Sol é para Todos', 'Ficção', '978-0061120084', 'Português', 384, 26.99, 38),
(38, 'A Máquina do Tempo', 'Ficção Científica', '978-8563560243', 'Português', 128, 16.99, 60),
(39, 'O Médico e o Monstro', 'Ficção', '978-8535913591', 'Português', 112, 14.99, 65),
(40, 'As Vinhas da Ira', 'Ficção', '978-8520932533', 'Português', 496, 28.99, 32),
(41, 'A Insustentável Leveza do Ser', 'Ficção', '978-8535902779', 'Português', 368, 30.99, 30),
(42, 'O Processo', 'Ficção', '978-8572328872', 'Português', 288, 25.99, 40),
(43, 'O Apanhador no Campo de Centeio', 'Ficção', '978-0316769488', 'Português', 288, 20.99, 50),
(44, '1984', 'Ficção', '978-0451524935', 'Português', 328, 25.99, 45),
(45, 'Dom Quixote', 'Ficção', '978-0060934347', 'Português', 992, 30.99, 18),
(46, 'Crime e Castigo', 'Ficção', '978-0198709711', 'Português', 608, 20.99, 30),
(47, 'Cem Anos de Solidão', 'Ficção', '978-8535928045', 'Português', 448, 35.99, 25),
(48, 'Moby Dick', 'Ficção', '978-0142437247', 'Português', 720, 22.99, 40),
(49, 'O Senhor dos Anéis', 'Ficção', '978-0345339706', 'Português', 1178, 50.99, 12),
(50, 'A Revolução dos Bichos', 'Ficção', '978-0451526342', 'Português', 144, 18.99, 70),
(51, 'O Alquimista', 'Ficção', '978-0062315007', 'Português', 208, 28.99, 38),
(52, 'A Culpa é das Estrelas', 'Romance', '978-0062348678', 'Português', 336, 24.99, 20),
(53, 'O Código Da Vinci', 'Suspense', '978-0307474278', 'Português', 592, 29.99, 28),
(54, 'O Pequeno Príncipe', 'Fábula', '978-8572329503', 'Português', 96, 15.99, 50),
(55, 'O Hobbit', 'Ficção', '978-8535915229', 'Português', 328, 27.99, 15),
(56, 'Ensaio Sobre a Cegueira', 'Ficção', '978-8535916820', 'Português', 312, 32.99, 23),
(57, 'A Menina que Roubava Livros', 'Ficção', '978-8535912662', 'Português', 480, 26.99, 35),
(58, 'A Dança dos Dragões', 'Ficção', '978-8598078949', 'Português', 640, 42.99, 10),
(59, 'A Metamorfose', 'Ficção', '978-8573263670', 'Português', 192, 18.99, 42),
(60, 'O Iluminado', 'Ficção', '978-0451160916', 'Português', 688, 30.99, 28),
(61, 'O Nome do Vento', 'Ficção', '978-8580574421', 'Português', 672, 35.99, 20),
(62, 'A Hospedeira', 'Ficção', '978-0062024043', 'Português', 560, 28.99, 33),
(63, 'O Silmarillion', 'Ficção', '978-8578277169', 'Português', 480, 40.99, 15);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `Cod_Venda` int(11) NOT NULL,
  `Id_Cli` int(30) NOT NULL,
  `Id_Fun` int(11) NOT NULL,
  `Dt_Venda` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`Cod_Venda`, `Id_Cli`, `Id_Fun`, `Dt_Venda`) VALUES
(4, 4, 4, '04/04/2004'),
(3, 3, 3, '03/03/2003'),
(2, 2, 2, '22/02/2012'),
(1, 1, 1, '11/11/2011'),
(5, 5, 5, '05/05/2005'),
(6, 6, 6, '06/06/2006'),
(7, 7, 7, '07/07/2007'),
(8, 8, 8, '08/08/2008'),
(9, 9, 9, '09/09/2009'),
(10, 10, 10, '10/10/2010'),
(11, 11, 11, '11/11/2011'),
(12, 12, 12, '12/12/2012'),
(13, 13, 13, '13/01/2013'),
(14, 14, 14, '14/02/2014'),
(15, 15, 15, '15/03/2015'),
(16, 16, 16, '16/04/2016'),
(17, 17, 17, '17/05/2017'),
(18, 18, 18, '18/06/2018'),
(19, 19, 19, '19/07/2019'),
(20, 20, 20, '20/08/2020'),
(21, 21, 21, '21/09/2021'),
(22, 22, 22, '22/10/2022'),
(23, 23, 23, '23/11/2023'),
(24, 24, 24, '24/12/2024'),
(25, 25, 25, '25/01/2025'),
(26, 26, 26, '26/02/2026'),
(27, 27, 27, '27/03/2027'),
(28, 28, 28, '28/04/2028'),
(29, 29, 29, '29/05/2029'),
(30, 30, 30, '30/06/2030'),
(31, 31, 31, '01/07/2031'),
(32, 32, 32, '02/08/2032'),
(33, 33, 33, '03/09/2033'),
(34, 34, 34, '04/10/2034'),
(35, 35, 35, '05/11/2035'),
(36, 36, 36, '06/12/2036'),
(37, 37, 37, '07/01/2037'),
(38, 38, 38, '08/02/2038'),
(39, 39, 39, '09/03/2039'),
(40, 40, 40, '10/04/2040');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Cod_Cli`);

--
-- Índices para tabela `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`Cod_Comp`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`Cod_Func`);

--
-- Índices para tabela `livro`
--
ALTER TABLE `livro`
  ADD PRIMARY KEY (`Cod_Liv`);

--
-- Índices para tabela `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`Cod_Venda`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `Cod_Cli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT de tabela `compra`
--
ALTER TABLE `compra`
  MODIFY `Cod_Comp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `Cod_Func` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `livro`
--
ALTER TABLE `livro`
  MODIFY `Cod_Liv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT de tabela `venda`
--
ALTER TABLE `venda`
  MODIFY `Cod_Venda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
