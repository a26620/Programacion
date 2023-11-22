CREATE DATABASE TeatroDB;

USE TeatroDB;

CREATE TABLE SALA (
    id_sala INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    capacidad INT,
    PRIMARY KEY (id_sala)
);

CREATE TABLE GENERO (
    id_genero INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (id_genero)
);

CREATE TABLE OBRA (
    id_obra INT AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT,
    img VARCHAR(255),
    precio DECIMAL(10, 2),
    id_sala INT,
    fechaActuacion DATE,
    edadRecomendada INT,
    id_genero INT,
    PRIMARY KEY (id_obra),
    FOREIGN KEY (id_sala) REFERENCES SALA(id_sala),
    FOREIGN KEY (id_genero) REFERENCES GENERO(id_genero),
    UNIQUE (id_sala, fechaActuacion)
);

CREATE TABLE USR (
    id_user INT AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) UNIQUE,
    pass VARCHAR(100) NOT NULL,
    rol VARCHAR(1) NOT NULL,
    PRIMARY KEY (id_user)
);

CREATE TABLE ASIENTO(
    id_asiento INT AUTO_INCREMENT PRIMARY KEY,
    n_identificacion VARCHAR(5) UNIQUE,
    id_sala INT,
    FOREIGN KEY (id_sala) REFERENCES SALA(id_sala)
);

CREATE TABLE COMPRA (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    id_obra INT,
    id_asiento INT,
    fechaCompra DATE,
    FOREIGN KEY (user_id) REFERENCES USR(id_user),
    FOREIGN KEY (id_obra) REFERENCES OBRA(id_obra),
    FOREIGN KEY (id_asiento) REFERENCES ASIENTO(id_asiento),
    UNIQUE (id_asiento, id_obra)

);

CREATE TABLE VALORACION (
    id_rating INT AUTO_INCREMENT PRIMARY KEY,
    id_user INT,
    id_obra INT,
    puntuacion DECIMAL(3, 1),
    fechaValoracion DATE,
    FOREIGN KEY (id_user) REFERENCES USR(id_user),
    FOREIGN KEY (id_obra) REFERENCES OBRA(id_obra)
);



INSERT INTO GENERO (nombre) VALUES 
('Teatro'),
('Musical'),
('Ballet'),
('Ópera');

-- Insertar usuarios y salas --
INSERT INTO USR (username, email, pass, rol) VALUES 
('admin', 'admin@example.com', 'adminpass', 'A'),
('JohnSmith', 'john.smith@gmail.com', 'userpass1', 'U'),
('EmmaJohnson', 'emma.johnson@gmail.com', 'userpass2', 'U'),
('MichaelBrown', 'michael.brown@gmail.com', 'userpass3', 'U'),
('SophiaWilliams', 'sophia.williams@gmail.com', 'userpass4', 'U'),
('WilliamTaylor', 'william.taylor@gmail.com', 'userpass5', 'U'),
('OliviaAnderson', 'olivia.anderson@gmail.com', 'userpass6', 'U'),
('JamesLee', 'james.lee@gmail.com', 'userpass7', 'U'),
('AvaClark', 'ava.clark@gmail.com', 'userpass8', 'U'),
('DanielHill', 'daniel.hill@gmail.com', 'userpass9', 'U'),
('usuario', 'usuario@gmail.com', 'usuariopass', 'U');


INSERT INTO SALA (nombre, capacidad) VALUES 
('Sala Angela Lansbury', 100),
('Sala Marlon Brando', 120),
('Sala Laurence Olivier', 50),
('Sala Maggie Smith', 70),
('Sala Vanessa Redgrave', 90),
('Sala Michael Caine', 20);


-- Insertar obras con referencia a la tabla de géneros --
INSERT INTO OBRA (titulo, descripcion, img, precio, id_sala, fechaActuacion, edadRecomendada, id_genero)
VALUES 
('El Rey Lear', 'Tragedia de William Shakespeare.', 'reylear.jpg', 23.00, 1, '2023-12-01', 16, 1),
('Cabaret', 'Musical basado en la novela de Christopher Isherwood.', 'cabaret.jpg', 27.50, 3, '2023-12-05', 18, 2),
('La Flauta Mágica', 'Ópera de Wolfgang Amadeus Mozart.', 'flauta.jpg', 31.00, 4, '2023-12-10', 12, 4),
('West Side Story', 'Musical sobre rivalidad entre pandillas.', 'westside.jpg', 25.00, 2, '2023-12-15', 16, 2),
('La Cenicienta', 'Clásico cuento de hadas en versión teatral.', 'cenicienta.jpg', 20.00, 5, '2023-12-20', 0, 3);

-- Insertar obras adicionales - Parte 2 --
INSERT INTO OBRA (titulo, descripcion, img, precio, id_sala, fechaActuacion, edadRecomendada, id_genero)
VALUES 
('Carmen', 'Ópera de Georges Bizet.', 'carmen.jpg', 29.50, 6, '2023-12-25', 12, 4),
('Grease', 'Musical ambientado en los años 50.', 'grease.jpg', 26.00, 1, '2023-12-02', 7, 2),
('La Bohème', 'Ópera de Giacomo Puccini.', 'boheme.jpg', 28.00, 3, '2023-12-06', 16, 4),
('El Diluvio que Viene', 'Musical español de Soler y Garrido.', 'diluvio.jpg', 30.00, 4, '2023-12-11', 18, 2),
('Annie', 'Musical sobre la huérfana Annie.', 'annie.jpg', 22.50, 2, '2023-12-16', 0, 2);

-- Insertar obras adicionales - Parte 3 --
INSERT INTO OBRA (titulo, descripcion, img, precio, id_sala, fechaActuacion, edadRecomendada, id_genero)
VALUES 
('El Lago de los Cisnes', 'Ballet clásico de Piotr Ilich Chaikovski.', 'cisnes.jpg', 33.00, 5, '2023-12-21', 7, 3),
('Les Misérables', 'Musical basado en la novela de Victor Hugo.', 'lesmiserables.jpg', 27.50, 6, '2023-12-26', 16, 2),
('La Traviata', 'Ópera de Giuseppe Verdi.', 'traviata2.jpg', 30.50, 1, '2023-12-03', 18, 4),
('Matilda', 'Musical basado en el libro de Roald Dahl.', 'matilda.jpg', 24.50, 3, '2023-12-07', 12, 2),
('La Sirenita', 'Versión teatral del cuento de Hans Christian Andersen.', 'sirenita.jpg', 21.00, 4, '2023-12-12', 0, 1);

-- Insertar obras adicionales - Parte 4 --
INSERT INTO OBRA (titulo, descripcion, img, precio, id_sala, fechaActuacion, edadRecomendada, id_genero)
VALUES 
('El Barbero de Sevilla', 'Ópera de Gioachino Rossini.', 'barberosevilla.jpg', 26.00, 2, '2023-12-17', 16, 4),
('La Jaula de las Locas', 'Musical sobre un club nocturno gay.', 'jaula.jpg', 29.00, 5, '2023-12-22', 18, 2),
('La Novicia Rebelde', 'Musical sobre la familia Von Trapp.', 'noviciarebelde.jpg', 25.00, 6, '2023-12-27', 12, 2),
('Cats', 'Musical de Andrew Lloyd Webber basado en T.S. Eliot.', 'cats2.jpg', 27.50, 3, '2023-12-08', 16, 1);




-- Inserts Asientos de cada sala --
-- Sala Angela Lansbury (capacidad: 100)
INSERT INTO ASIENTO (n_identificacion, id_sala)
VALUES 
('AL1', 1), ('AL2', 1), ('AL3', 1), ('AL4', 1), ('AL5', 1), ('AL6', 1), ('AL7', 1), ('AL8', 1), ('AL9', 1), ('AL10', 1),
('AL11', 1), ('AL12', 1), ('AL13', 1), ('AL14', 1), ('AL15', 1), ('AL16', 1), ('AL17', 1), ('AL18', 1), ('AL19', 1), ('AL20', 1),
('AL21', 1), ('AL22', 1), ('AL23', 1), ('AL24', 1), ('AL25', 1), ('AL26', 1), ('AL27', 1), ('AL28', 1), ('AL29', 1), ('AL30', 1),
('AL31', 1), ('AL32', 1), ('AL33', 1), ('AL34', 1), ('AL35', 1), ('AL36', 1), ('AL37', 1), ('AL38', 1), ('AL39', 1), ('AL40', 1),
('AL41', 1), ('AL42', 1), ('AL43', 1), ('AL44', 1), ('AL45', 1), ('AL46', 1), ('AL47', 1), ('AL48', 1), ('AL49', 1), ('AL50', 1),
('AL51', 1), ('AL52', 1), ('AL53', 1), ('AL54', 1), ('AL55', 1), ('AL56', 1), ('AL57', 1), ('AL58', 1), ('AL59', 1), ('AL60', 1),
('AL61', 1), ('AL62', 1), ('AL63', 1), ('AL64', 1), ('AL65', 1), ('AL66', 1), ('AL67', 1), ('AL68', 1), ('AL69', 1), ('AL70', 1),
('AL71', 1), ('AL72', 1), ('AL73', 1), ('AL74', 1), ('AL75', 1), ('AL76', 1), ('AL77', 1), ('AL78', 1), ('AL79', 1), ('AL80', 1),
('AL81', 1), ('AL82', 1), ('AL83', 1), ('AL84', 1), ('AL85', 1), ('AL86', 1), ('AL87', 1), ('AL88', 1), ('AL89', 1), ('AL90', 1),
('AL91', 1), ('AL92', 1), ('AL93', 1), ('AL94', 1), ('AL95', 1), ('AL96', 1), ('AL97', 1), ('AL98', 1), ('AL99', 1), ('AL100', 1);

-- Sala Marlon Brando (capacidad: 120)
INSERT INTO ASIENTO (n_identificacion, id_sala)
VALUES 
('MB1', 2), ('MB2', 2), ('MB3', 2), ('MB4', 2), ('MB5', 2), ('MB6', 2), ('MB7', 2), ('MB8', 2), ('MB9', 2), ('MB10', 2),
('MB11', 2), ('MB12', 2), ('MB13', 2), ('MB14', 2), ('MB15', 2), ('MB16', 2), ('MB17', 2), ('MB18', 2), ('MB19', 2), ('MB20', 2),
('MB21', 2), ('MB22', 2), ('MB23', 2), ('MB24', 2), ('MB25', 2), ('MB26', 2), ('MB27', 2), ('MB28', 2), ('MB29', 2), ('MB30', 2),
('MB31', 2), ('MB32', 2), ('MB33', 2), ('MB34', 2), ('MB35', 2), ('MB36', 2), ('MB37', 2), ('MB38', 2), ('MB39', 2), ('MB40', 2),
('MB41', 2), ('MB42', 2), ('MB43', 2), ('MB44', 2), ('MB45', 2), ('MB46', 2), ('MB47', 2), ('MB48', 2), ('MB49', 2), ('MB50', 2),
('MB51', 2), ('MB52', 2), ('MB53', 2), ('MB54', 2), ('MB55', 2), ('MB56', 2), ('MB57', 2), ('MB58', 2), ('MB59', 2), ('MB60', 2),
('MB61', 2), ('MB62', 2), ('MB63', 2), ('MB64', 2), ('MB65', 2), ('MB66', 2), ('MB67', 2), ('MB68', 2), ('MB69', 2), ('MB70', 2),
('MB71', 2), ('MB72', 2), ('MB73', 2), ('MB74', 2), ('MB75', 2), ('MB76', 2), ('MB77', 2), ('MB78', 2), ('MB79', 2), ('MB80', 2),
('MB81', 2), ('MB82', 2), ('MB83', 2), ('MB84', 2), ('MB85', 2), ('MB86', 2), ('MB87', 2), ('MB88', 2), ('MB89', 2), ('MB90', 2),
('MB91', 2), ('MB92', 2), ('MB93', 2), ('MB94', 2), ('MB95', 2), ('MB96', 2), ('MB97', 2), ('MB98', 2), ('MB99', 2), ('MB100', 2),
('MB101', 2), ('MB102', 2), ('MB103', 2), ('MB104', 2), ('MB105', 2), ('MB106', 2), ('MB107', 2), ('MB108', 2), ('MB109', 2), ('MB110', 2),
('MB111', 2), ('MB112', 2), ('MB113', 2), ('MB114', 2), ('MB115', 2), ('MB116', 2), ('MB117', 2), ('MB118', 2), ('MB119', 2), ('MB120', 2);

-- Sala Laurence Olivier (capacidad: 50)
INSERT INTO ASIENTO (n_identificacion, id_sala)
VALUES 
('LO1', 3), ('LO2', 3), ('LO3', 3), ('LO4', 3), ('LO5', 3), ('LO6', 3), ('LO7', 3), ('LO8', 3), ('LO9', 3), ('LO10', 3),
('LO11', 3), ('LO12', 3), ('LO13', 3), ('LO14', 3), ('LO15', 3), ('LO16', 3), ('LO17', 3), ('LO18', 3), ('LO19', 3), ('LO20', 3),
('LO21', 3), ('LO22', 3), ('LO23', 3), ('LO24', 3), ('LO25', 3), ('LO26', 3), ('LO27', 3), ('LO28', 3), ('LO29', 3), ('LO30', 3),
('LO31', 3), ('LO32', 3), ('LO33', 3), ('LO34', 3), ('LO35', 3), ('LO36', 3), ('LO37', 3), ('LO38', 3), ('LO39', 3), ('LO40', 3),
('LO41', 3), ('LO42', 3), ('LO43', 3), ('LO44', 3), ('LO45', 3), ('LO46', 3), ('LO47', 3), ('LO48', 3), ('LO49', 3), ('LO50', 3);

-- Sala Maggie Smith (capacidad: 70)
INSERT INTO ASIENTO (n_identificacion, id_sala)
VALUES 
('MS1', 4), ('MS2', 4), ('MS3', 4), ('MS4', 4), ('MS5', 4), ('MS6', 4), ('MS7', 4), ('MS8', 4), ('MS9', 4), ('MS10', 4),
('MS11', 4), ('MS12', 4), ('MS13', 4), ('MS14', 4), ('MS15', 4), ('MS16', 4), ('MS17', 4), ('MS18', 4), ('MS19', 4), ('MS20', 4),
('MS21', 4), ('MS22', 4), ('MS23', 4), ('MS24', 4), ('MS25', 4), ('MS26', 4), ('MS27', 4), ('MS28', 4), ('MS29', 4), ('MS30', 4),
('MS31', 4), ('MS32', 4), ('MS33', 4), ('MS34', 4), ('MS35', 4), ('MS36', 4), ('MS37', 4), ('MS38', 4), ('MS39', 4), ('MS40', 4),
('MS41', 4), ('MS42', 4), ('MS43', 4), ('MS44', 4), ('MS45', 4), ('MS46', 4), ('MS47', 4), ('MS48', 4), ('MS49', 4), ('MS50', 4),
('MS51', 4), ('MS52', 4), ('MS53', 4), ('MS54', 4), ('MS55', 4), ('MS56', 4), ('MS57', 4), ('MS58', 4), ('MS59', 4), ('MS60', 4),
('MS61', 4), ('MS62', 4), ('MS63', 4), ('MS64', 4), ('MS65', 4), ('MS66', 4), ('MS67', 4), ('MS68', 4), ('MS69', 4), ('MS70', 4);

-- Sala Vanessa Redgrave (capacidad: 90)
INSERT INTO ASIENTO (n_identificacion, id_sala)
VALUES 
('VR1', 5), ('VR2', 5), ('VR3', 5), ('VR4', 5), ('VR5', 5), ('VR6', 5), ('VR7', 5), ('VR8', 5), ('VR9', 5), ('VR10', 5),
('VR11', 5), ('VR12', 5), ('VR13', 5), ('VR14', 5), ('VR15', 5), ('VR16', 5), ('VR17', 5), ('VR18', 5), ('VR19', 5), ('VR20', 5),
('VR21', 5), ('VR22', 5), ('VR23', 5), ('VR24', 5), ('VR25', 5), ('VR26', 5), ('VR27', 5), ('VR28', 5), ('VR29', 5), ('VR30', 5),
('VR31', 5), ('VR32', 5), ('VR33', 5), ('VR34', 5), ('VR35', 5), ('VR36', 5), ('VR37', 5), ('VR38', 5), ('VR39', 5), ('VR40', 5),
('VR41', 5), ('VR42', 5), ('VR43', 5), ('VR44', 5), ('VR45', 5), ('VR46', 5), ('VR47', 5), ('VR48', 5), ('VR49', 5), ('VR50', 5),
('VR51', 5), ('VR52', 5), ('VR53', 5), ('VR54', 5), ('VR55', 5), ('VR56', 5), ('VR57', 5), ('VR58', 5), ('VR59', 5), ('VR60', 5),
('VR61', 5), ('VR62', 5), ('VR63', 5), ('VR64', 5), ('VR65', 5), ('VR66', 5), ('VR67', 5), ('VR68', 5), ('VR69', 5), ('VR70', 5),
('VR71', 5), ('VR72', 5), ('VR73', 5), ('VR74', 5), ('VR75', 5), ('VR76', 5), ('VR77', 5), ('VR78', 5), ('VR79', 5), ('VR80', 5),
('VR81', 5), ('VR82', 5), ('VR83', 5), ('VR84', 5), ('VR85', 5), ('VR86', 5), ('VR87', 5), ('VR88', 5), ('VR89', 5), ('VR90', 5);

-- Sala Michael Caine (capacidad: 20)
INSERT INTO ASIENTO (n_identificacion, id_sala)
VALUES 
('MC1', 6), ('MC2', 6), ('MC3', 6), ('MC4', 6), ('MC5', 6), ('MC6', 6), ('MC7', 6), ('MC8', 6), ('MC9', 6), ('MC10', 6),
('MC11', 6), ('MC12', 6), ('MC13', 6), ('MC14', 6), ('MC15', 6), ('MC16', 6), ('MC17', 6), ('MC18', 6), ('MC19', 6), ('MC20', 6);

-- CREATE TRIGGER valida_relacion BEFORE INSERT ON COMPRA
-- FOR EACH ROW
-- BEGIN
--     DECLARE obra_sala INT;
--     DECLARE asiento_sala INT;

--     SELECT id_sala INTO obra_sala FROM OBRA WHERE id_obra = NEW.obra_id;
--     SELECT id_sala INTO asiento_sala FROM ASIENTO WHERE id_asiento = NEW.id_asiento;

--     IF obra_sala != asiento_sala THEN
--         SIGNAL SQLSTATE '45000'
--         SET MESSAGE_TEXT = 'La id_sala de la obra y el asiento no coinciden';
--     END IF;
-- END;


CREATE USER 'bayron'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON teatrodb.* TO 'bayron'@'localhost';
FLUSH PRIVILEGES;