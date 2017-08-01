DELETE FROM role;
DELETE FROM userrole;
DELETE FROM user;
DELETE FROM test;

/*default password for all users 123456*/
INSERT INTO user (id, email, password) VALUES (2, 'user@mail.com', '03e4e5d7f3f0b0a21bdba1e8bcf195a87423023f81c9a5fd4c06ef818e7540ef330005ca776abbe8');
INSERT INTO user (id, email, password) VALUES (3, 'author@mail.com', '03e4e5d7f3f0b0a21bdba1e8bcf195a87423023f81c9a5fd4c06ef818e7540ef330005ca776abbe8');
INSERT INTO user (id, email, password) VALUES (1, 'admin@mail.com', '03e4e5d7f3f0b0a21bdba1e8bcf195a87423023f81c9a5fd4c06ef818e7540ef330005ca776abbe8');

INSERT INTO role (id, name) VALUES (1, 'ADMIN');
INSERT INTO role (id, name) VALUES (2, 'USER');
INSERT INTO role (id, name) VALUES (3, 'AUTHOR');

INSERT INTO userrole (userId, roleId) VALUES (1, 1);
INSERT INTO userrole (userId, roleId) VALUES (2, 2);
INSERT INTO userrole (userId, roleId) VALUES (3, 3);

INSERT INTO test (id, name) VALUES (1, 'Test test');