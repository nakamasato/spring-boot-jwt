USE db_example;
INSERT INTO role (id, name) VALUES (1, 'STANDARD_USER');
INSERT INTO role (id, name) VALUES (2, 'ADMIN_USER');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO user (id, password, username) VALUES (1, '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'john.doe');
INSERT INTO user (id, password, username) VALUES (2, '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'admin.admin');


INSERT INTO user_role (user_id, role_id) VALUES(1,1);
INSERT INTO user_role (user_id, role_id) VALUES(2,1);
INSERT INTO user_role (user_id, role_id) VALUES(2,2);
