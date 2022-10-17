-- DROP DATABASE IF EXISTS projeto;
-- CREATE DATABASE projeto;
USE projeto;

CREATE TABLE produto(

id INT NOT NULL AUTO_INCREMENT,
nomeproduto VARCHAR(25) NOT NULL,
quantidade INT NOT NULL,
valor FLOAT NOT NULL,
PRIMARY KEY(id)

);

CREATE TABLE cliente (
idcliente INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(45) NOT NULL,
telefone VARCHAR(17) NOT NULL,
email VARCHAR(45),
endereco varchar(50) NOT NULL,
cpf VARCHAR(14),
cidade VARCHAR(30) NOT NULL,
uf VARCHAR(2) NOT NULL,
cep VARCHAR(9) NOT NULL,
PRIMARY KEY(idcliente)

);

CREATE TABLE fornecedor (
idfornecedor INT AUTO_INCREMENT,
nome varchar (45),
valor_a_ser_pago float,
data_entrega date,
cidade VARCHAR (45),
endereco VARCHAR(45),
telefone VARCHAR (45),
email VARCHAR (45),
cep VARCHAR(9),
uf VARCHAR(9),
PRIMARY KEY(idfornecedor)

);

CREATE TABLE caixa (

idDataCaixa DATE,
data Date,
valorentregas FLOAT,
Valorabertura FLOAT,
totalentrada FLOAT,
totalsaida FLOAT,
status VARCHAR(1),
PRIMARY KEY(idDataCaixa)

);

CREATE TABLE  pedido(
idcliente INT NOT NULL,
idvenda int AUTO_INCREMENT,
valortotal Float,
idDataCaixa DATE,
dataentrega date,
datapedido date,
localidade Varchar(30),
status varchar(1),
Primary Key(Idvenda),
foreign key (idcliente) references cliente(idcliente),
foreign key(idDataCaixa) references caixa(idDataCaixa)
);

CREATE TABLE itementrega(
idVenda INT ,
idProduto INT,
quantidade INT,
preco FLOAT,
nome Varchar(30),
-- idItem int,
-- PRIMARY KEY(idItem)
 PRIMARY KEY(idVenda, idProduto),
 FOREIGN KEY (idVenda) REFERENCES pedido(idvenda),
 FOREIGN KEY(idProduto) REFERENCES produto(id)
);

CREATE TABLE sangria(
idDataCaixa DATE,
idsangria INT ,
valor FLOAT,
motivo VARCHAR(35),

PRIMARY KEY(idDatacaixa,idsangria),
FOREIGN KEY (idDataCaixa) REFERENCES caixa(idDataCaixa)

);



INSERT INTO produto (nomeproduto, quantidade, valor)
VALUES ("Pastel", 25, 1.75),
	    ("Croquete",40, 0.80 );

INSERT INTO fornecedor ( nome, valor_a_ser_pago, data_entrega)
VALUES ("Ligeiros", 45, "2020/04/09");
        
 INSERT INTO  cliente ( nome, telefone,cidade ,endereco, uf, cep)
 VALUES("Fernando","997-567", "Presidente Epitacio","Alameda da peroba 45", "SP", 
 19470-000 );
      
INSERT INTO pedido ( dataentrega, localidade, idcliente)
        VALUES ("2022/08/22","Alameda", 1);

        
      INSERT INTO caixa (idDatcaixaaCaixa, valorabertura,
        status)
        VALUES( "2022/04/29" ,200,"a");
        
     
     CREATE TABLE compra (
      idCompra INT,
      idfornecedor INT,
      idDataCaixa DATE,
      valortotal FLOAT,
      -- data Date,
      PRIMARY KEY(IdCompra),
      FOREIGN KEY(idfornecedor) REFERENCES fornecedor(idfornecedor)
    --  FOREIGN KEY(idDataCaixa) REFERENCES caixa(idDataCaixa)
      
      );
      
      CREATE TABLE producao(
      idproducao INT,
      nome VARCHAR(45),
      quantidade INT,
      preco FLOAT
      );
      
      
      CREATE TABLE itemcompra(
      idcompra int,
      idproducao int,
      quantidade int,
      nome Varchar(45),
      preco FLOAT,
      
      FOREIGN KEY(idcompra) References compra(idCompra),
      FOREIGN KEY(idproducao) REFERENCES producao(idproducao)
      
      );
      

DELIMITER $$
USE `projeto`$$
CREATE DEFINER = CURRENT_USER TRIGGER `projeto`.`itementrega_AFTER_UPDATE` AFTER UPDATE ON `itementrega` FOR EACH ROW
BEGIN
     update produto set quantidade = quantidade + old.quantidade - new.quantidade
     where id=new.idproduto;
END$$
DELIMITER ;


DROP TRIGGER IF EXISTS `projeto`.`itemcompra_AFTER_INSERT`;
DELIMITER $$
USE `projeto`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `itemcompra_AFTER_INSERT` AFTER INSERT ON `itemcompra` FOR EACH ROW BEGIN
update producao set quantidade = quantidade  + new.quantidade
     where idproducao=new.idproducao;
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS `projeto`.`sangria_AFTER_INSERT`;

DELIMITER $$
USE `projeto`$$
CREATE DEFINER = CURRENT_USER TRIGGER `projeto`.`sangria_AFTER_INSERT` AFTER INSERT ON `sangria` FOR EACH ROW
BEGIN
update caixa c 
set c.valorabertura = c.valorabertura - new.valor, 
c.totalsaida = c.totalsaida + new.valor 
where c.idDataCaixa = new.idDataCaixa;
END$$
DELIMITER ;
      
     