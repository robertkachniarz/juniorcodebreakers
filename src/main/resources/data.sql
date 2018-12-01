drop table bike if exists
create  table bike(id INTEGER NOT NULL AUTO_INCREMENT, status varchar(255),primary key (id))
INSERT into bike(id,status) values (1,'STOLEN')
INSERT into bike(id,status) values (2,'STOLEN')
INSERT into bike(id, status) values (3,'STOLEN')