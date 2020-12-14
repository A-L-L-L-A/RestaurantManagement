DROP DATABASE IF EXISTS restaurantmanagement;
CREATE DATABASE restaurantmanagement;


CREATE TABLE restaurantmanagement.role 
(
id INT NOT NULL UNIQUE PRIMARY KEY,
title VARCHAR(20) NOT NULL UNIQUE
 );
 
 INSERT INTO restaurantmanagement.role
VALUES
(0,'admin'),
(1,'client');

CREATE TABLE restaurantmanagement.clients
(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(30) UNIQUE,
    password VARCHAR(30) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
	last_name  VARCHAR(30) NOT NULL,
	email      VARCHAR(30) NOT NULL UNIQUE,
    bill INT NOT NULL DEFAULT 0,
	role_id INT,
    FOREIGN KEY (role_id) REFERENCES restaurantmanagement.role(id)
);
INSERT INTO restaurantmanagement.clients (login,password,first_name,last_name,email,bill,role_id)
VALUES
("admin","admin","admin","admin","mini_wariors1@mail.ru",0,0),
("ELLA","1234","lexa","drozd","mini_wario1234@mail.ru",150,1),
("ALLA","1234","zzz","sleep","mini_wariors@mail.ru",40,1),
("Nadezda","parole","nadya","sinkevich","mi@mail.ru",70,1);