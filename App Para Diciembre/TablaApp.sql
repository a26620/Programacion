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
    edadRecomendada INT,
    id_genero INT,
    duracion INT,
    PRIMARY KEY (id_obra),
    FOREIGN KEY (id_genero) REFERENCES GENERO(id_genero)
);

CREATE TABLE OBRA_SALA(
    id_actuacion INT AUTO_INCREMENT,
    id_obra INT,
    id_sala INT,
    fechaActuacion DATE,
    horaActuacion TIME,
    PRIMARY KEY (id_actuacion),
    FOREIGN KEY (id_sala) REFERENCES SALA(id_sala),
    FOREIGN KEY (id_obra) REFERENCES OBRA(id_obra),
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

CREATE TABLE COMPRA (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_user INT,
    id_actuacion INT,
    fechaCompra DATE,
    importe DECIMAL(10, 2),
    FOREIGN KEY (id_user) REFERENCES USR(id_user),
    FOREIGN KEY (id_actuacion) REFERENCES OBRA_SALA(id_actuacion)
);

CREATE TABLE VALORACION (
    id_rating INT AUTO_INCREMENT PRIMARY KEY,
    id_user INT,
    id_obra INT,
    puntuacion float,
    fechaValoracion DATE,
    FOREIGN KEY (id_user) REFERENCES USR(id_user),
    FOREIGN KEY (id_obra) REFERENCES OBRA(id_obra),
    UNIQUE (id_user, id_obra)
);


INSERT INTO GENERO (nombre) VALUES 
('TEATRO'),
('MUSICAL'),
('BALLET'),
('ÓPERA');



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
INSERT INTO OBRA (titulo, descripcion, img, precio, edadRecomendada, id_genero, duracion)
VALUES 
('El Rey Lear', 'Tragedia de William Shakespeare.', 'reylear.jpg', 23.00, 16, 1, 150),
('Cabaret', 'Musical basado en la novela de Christopher Isherwood.', 'cabaret.jpg', 27.50, 18, 2, 120),
('La Flauta Mágica', 'Ópera de Wolfgang Amadeus Mozart.', 'flauta.jpg', 31.00, 12, 4, 180),
('West Side Story', 'Musical sobre rivalidad entre pandillas.', 'westside.jpg', 25.00, 16, 2, 135),
('La Cenicienta', 'Clásico cuento de hadas en versión teatral.', 'cenicienta.jpg', 20.00, 0, 3, 105);

-- Insertar obras adicionales - Parte 2 --
INSERT INTO OBRA (titulo, descripcion, img, precio, edadRecomendada, id_genero, duracion)
VALUES 
('Carmen', 'Ópera de Georges Bizet.', 'carmen.jpg', 29.50, 12, 4, 165),
('Grease', 'Musical ambientado en los años 50.', 'grease.jpg', 26.00, 7, 2, 100),
('La Bohème', 'Ópera de Giacomo Puccini.', 'boheme.jpg', 28.00, 16, 4, 150),
('El Diluvio que Viene', 'Musical español de Soler y Garrido.', 'diluvio.jpg', 30.00, 18, 2, 180),
('Annie', 'Musical sobre la huérfana Annie.', 'annie.jpg', 22.50, 0, 2, 120);

-- Insertar obras adicionales - Parte 3 --
INSERT INTO OBRA (titulo, descripcion, img, precio, edadRecomendada, id_genero, duracion)
VALUES 
('El Lago de los Cisnes', 'Ballet clásico de Piotr Ilich Chaikovski.', 'cisnes.jpg', 33.00, 7, 3, 135),
('Les Misérables', 'Musical basado en la novela de Victor Hugo.', 'lesmiserables.jpg', 27.50, 16, 2, 150),
('La Traviata', 'Ópera de Giuseppe Verdi.', 'traviata2.jpg', 30.50, 18, 4, 180),
('Matilda', 'Musical basado en el libro de Roald Dahl.', 'matilda.jpg', 24.50, 12, 2, 105),
('La Sirenita', 'Versión teatral del cuento de Hans Christian Andersen.', 'sirenita.jpg', 21.00, 0, 1, 90);

-- Insertar obras adicionales - Parte 4 --
INSERT INTO OBRA (titulo, descripcion, img, precio, edadRecomendada, id_genero, duracion)
VALUES 
('El Barbero de Sevilla', 'Ópera de Gioachino Rossini.', 'barberosevilla.jpg', 26.00, 16, 4, 120),
('La Jaula de las Locas', 'Musical sobre un club nocturno gay.', 'jaula.jpg', 29.00, 18, 2, 150),
('La Novicia Rebelde', 'Musical sobre la familia Von Trapp.', 'noviciarebelde.jpg', 25.00, 12, 2, 105),
('Cats', 'Musical de Andrew Lloyd Webber basado en T.S. Eliot.', 'cats2.jpg', 27.50, 16, 1, 150);



CREATE USER 'bayron'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON teatrodb.* TO 'bayron'@'localhost';
FLUSH PRIVILEGES;