CREATE DATABASE TeatroDB;

USE TeatroDB;

CREATE TABLE SALA (
    id_sala INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    capacidad INT,
    PRIMARY KEY (id_sala)
);

CREATE TABLE OBRA (
    id_obra INT AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT,
    img VARCHAR(255),
    precio DECIMAL(10, 2),
    id_sala INT,
    fechaActuacion DATE,
    PRIMARY KEY (id_obra),
    FOREIGN KEY (id_sala) REFERENCES SALA(id_sala),
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
    user_id INT,
    obra_id INT,
    fechaCompra DATE,
    FOREIGN KEY (user_id) REFERENCES USR(id_user),
    FOREIGN KEY (obra_id) REFERENCES OBRA(id_obra)
);

CREATE TABLE VALORACION (
    id_rating INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    obra_id INT,
    puntuacion DECIMAL(3, 1),
    fechaValoracion DATE,
    FOREIGN KEY (user_id) REFERENCES USR(id_user),
    FOREIGN KEY (obra_id) REFERENCES OBRA(id_obra)
);

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
('DanielHill', 'daniel.hill@gmail.com', 'userpass9', 'U');

INSERT INTO SALA (nombre, capacidad) VALUES 
('Sala Angela Lansbury', 180),
('Sala Marlon Brando', 120),
('Sala Laurence Olivier', 200),
('Sala Maggie Smith', 150),
('Sala Vanessa Redgrave', 90),
('Sala Michael Caine', 220);

CREATE USER 'bayron'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON teatrodb.* TO 'bayron'@'localhost';
FLUSH PRIVILEGES;