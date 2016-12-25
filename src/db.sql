DROP DATABASE IF EXISTS simple_blog;
CREATE DATABASE simple_blog DEFAULT CHARACTER SET UTF8;
USE simple_blog;

DROP TABLE IF EXISTS blog;

CREATE TABLE blog (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(128) NOT NULL,
  text TEXT,
  preview VARCHAR(128),
  author VARCHAR(32),
  category VARCHAR(32),
  date TIMESTAMP DEFAULT '2016-12-20 00:00:00'
);

CREATE TABLE user (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(45),
  password VARCHAR(45),
  last_ip VARCHAR(20),
  last_visit DATETIME
);

CREATE TABLE message (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	author VARCHAR(32),
	content TEXT,
	date TIMESTAMP DEFAULT '2016-12-20 00:00:00'
);



insert blog (title, text, preview, author, category, date) values('SSH整合', 'Spring/SpringMVC/HIBERNATE', 'SSH整合', 'Tom', 'Java','2016-12-20 00:00:00');

insert user(id,username,password,last_ip,last_visit) values(1,'Tom','1234','127.0.0.1','2016-12-20 00:00:00');