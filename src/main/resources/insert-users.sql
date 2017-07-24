DELETE FROM user;

#default password for all roles 123456

INSERT INTO user (id, email, password) VALUES (1, 'admin@mail.com', '03e4e5d7f3f0b0a21bdba1e8bcf195a87423023f81c9a5fd4c06ef818e7540ef330005ca776abbe8');
INSERT INTO userrole (userId, roleId) VALUES (1, 1);
INSERT INTO user (id, email, password) VALUES (2, 'user@mail.com', '03e4e5d7f3f0b0a21bdba1e8bcf195a87423023f81c9a5fd4c06ef818e7540ef330005ca776abbe8');
INSERT INTO userrole (userId, roleId) VALUES (2, 2);
INSERT INTO user (id, email, password) VALUES (3, 'author@mail.com', '03e4e5d7f3f0b0a21bdba1e8bcf195a87423023f81c9a5fd4c06ef818e7540ef330005ca776abbe8');
INSERT INTO userrole (userId, roleId) VALUES (3, 3);