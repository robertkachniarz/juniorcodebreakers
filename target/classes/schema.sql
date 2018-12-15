DROP TABLE bike_user IF EXISTS;
CREATE TABLE bike_user (
id INTEGER NOT NULL AUTO_INCREMENT,
login VARCHAR(128) NOT NULL UNIQUE,
password VARCHAR (128) NOT NULL ,
e_mail  varchar (128) not null UNIQUE ,
role VARCHAR (128) NOT NULL ,
PRIMARY KEY (id)
);
drop table bikes if exists;
create  table bikes(id INTEGER NOT NULL AUTO_INCREMENT, status varchar(255),primary key (id));
