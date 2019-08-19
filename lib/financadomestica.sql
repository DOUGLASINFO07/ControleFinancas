-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 14-Out-2018 às 12:40
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `financadomestica`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `boleto`
--

CREATE TABLE `boleto` (
  `codigoBoleto` int(11) NOT NULL,
  `empresaBoleto` varchar(40) DEFAULT NULL,
  `servicoBoleto` varchar(40) DEFAULT NULL,
  `valorPagarBoleto` double DEFAULT NULL,
  `vencimentoBoleto` date DEFAULT NULL,
  `parcelasBoleto` int(3) DEFAULT NULL,
  `numeroParcelasBoleto` varchar(5) DEFAULT NULL,
  `cicloBoleto` varchar(20) DEFAULT NULL,
  `formaPagamentoBoleto` varchar(30) DEFAULT NULL,
  `dataPagamentoBoleto` date DEFAULT NULL,
  `valorPagoBoleto` double DEFAULT NULL,
  `localPagamentoBoleto` varchar(40) DEFAULT NULL,
  `pagadorBoleto` varchar(40) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `boleto`
--

INSERT INTO `boleto` (`codigoBoleto`, `empresaBoleto`, `servicoBoleto`, `valorPagarBoleto`, `vencimentoBoleto`, `parcelasBoleto`, `numeroParcelasBoleto`, `cicloBoleto`, `formaPagamentoBoleto`, `dataPagamentoBoleto`, `valorPagoBoleto`, `localPagamentoBoleto`, `pagadorBoleto`) VALUES
(23, 'CEMIG', 'Energia elétrica', 200.25, '2019-02-10', 5, '5/5', 'Diário', 'Dinheiro', '2018-10-20', 500.25, 'Banco', 'Douglas Borges Egidio'),
(22, 'CEMIG', 'Energia elétrica', 200.25, '2019-01-10', 5, '4/5', 'Diário', 'Dinheiro', NULL, 0, '', ''),
(21, 'CEMIG', 'Energia elétrica', 200.25, '2018-12-10', 5, '3/5', 'Diário', 'Dinheiro', NULL, 0, '', ''),
(20, 'CEMIG', 'Energia elétrica', 200.25, '2018-11-10', 5, '2/5', 'Diário', 'Dinheiro', NULL, 0, '', ''),
(19, 'CEMIG', 'Energia elétrica', 200.25, '2018-10-10', 5, '1/5', 'Diário', 'Dinheiro', NULL, 0, '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresa`
--

CREATE TABLE `empresa` (
  `codigoEmpresa` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `tipoServico` varchar(30) DEFAULT NULL,
  `telefoneEmpresa` varchar(15) DEFAULT NULL,
  `siteEmpresa` varchar(50) DEFAULT NULL,
  `emailEmpresa` varchar(50) DEFAULT NULL,
  `login` varchar(50) DEFAULT NULL,
  `senha` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `empresa`
--

INSERT INTO `empresa` (`codigoEmpresa`, `nome`, `tipoServico`, `telefoneEmpresa`, `siteEmpresa`, `emailEmpresa`, `login`, `senha`) VALUES
(38, 'Sky', 'TV a Cabo', '(11) 00000-0000', 'ky.com.br', 'sky@atendimentosky.com.br', 'skyLogin', 'senha123456'),
(37, 'Zoonoses', 'trabalho', '(35) 33522-8149', 'zoonoses.com.br', 'zoonoses@gmail.com', 'zoonoseslogin', 'senha123456'),
(36, 'UNIVOX', 'Internet', '(35) 93526-6000', 'univox.com.br', 'univox@gmai.com', 'univoslogin', 'senha12356'),
(34, 'CEMIG', 'Energia elétrica', '(35) 33521-1990', 'www.cemig.com.br', 'atendimento@cemig.com.br', 'cemiglogina', 'senha123'),
(31, 'DIMTECH', 'Informática', '(35) 99841-4867', 'DIMTECH.COM.BR', 'dimtech@dimtech.com', 'dimtechlogin', 'senha456'),
(35, 'SAAE', 'Fornecimento de Água', '(35) 93521-0584', 'saae.com.br', 'saae@gmail.com', 'saaelogin', '321654senha');

-- --------------------------------------------------------

--
-- Estrutura da tabela `salario`
--

CREATE TABLE `salario` (
  `codigoSalario` int(11) NOT NULL,
  `empresaSalario` varchar(40) DEFAULT NULL,
  `valorSalario` double DEFAULT NULL,
  `dataRecebimentoSalario` date DEFAULT NULL,
  `cicloRecebimentoSalario` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `salario`
--

INSERT INTO `salario` (`codigoSalario`, `empresaSalario`, `valorSalario`, `dataRecebimentoSalario`, `cicloRecebimentoSalario`) VALUES
(1, 'DIMTECH', 2565.99, '2018-09-10', 'Quinzenal');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `codigoUsuario` int(11) NOT NULL,
  `nomeUsuario` varchar(30) DEFAULT NULL,
  `telefoneUsuario` varchar(15) DEFAULT NULL,
  `emailUsuario` varchar(50) DEFAULT NULL,
  `loginUsuario` varchar(30) DEFAULT NULL,
  `senhaUsuario` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`codigoUsuario`, `nomeUsuario`, `telefoneUsuario`, `emailUsuario`, `loginUsuario`, `senhaUsuario`) VALUES
(7, 'Douglas Borges Egidio', '(35) 98414-8675', 'douglas.egidio@gmail.com', 'dbegidioitalo', '123456879'),
(9, 'Italo', '(35) 99865-2564', 'asfsd@gmail.com', 'teste', '321987'),
(10, 'Marcia regina', '(35) 99164-6560', 'marcia@gmail.com', 'marica', '321654');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `boleto`
--
ALTER TABLE `boleto`
  ADD PRIMARY KEY (`codigoBoleto`);

--
-- Indexes for table `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`codigoEmpresa`);

--
-- Indexes for table `salario`
--
ALTER TABLE `salario`
  ADD PRIMARY KEY (`codigoSalario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigoUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `boleto`
--
ALTER TABLE `boleto`
  MODIFY `codigoBoleto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `empresa`
--
ALTER TABLE `empresa`
  MODIFY `codigoEmpresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT for table `salario`
--
ALTER TABLE `salario`
  MODIFY `codigoSalario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codigoUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
