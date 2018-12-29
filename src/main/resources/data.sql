/*Dane potrzebne tylko przy pierwszym uruchomieniu, aby w bazie zapisane zostały dwie role*/

INSERT INTO `role`(`role_id`, `role`) VALUES (1,'ADMIN')
INSERT INTO `role`(`role_id`, `role`) VALUES (2,'USER')