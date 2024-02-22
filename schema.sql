-- schema.sql
CREATE TABLE bus (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    capacity INT NOT NULL
);

CREATE TABLE driver (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    license_number VARCHAR(20) NOT NULL
);

CREATE TABLE route (
    id INT PRIMARY KEY AUTO_INCREMENT,
    origin VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    distance INT NOT NULL
);
