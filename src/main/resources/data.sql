INSERT INTO TB_USER (id, email, name, password) VALUES (random_uuid(), 'lucas-barros28@hotmail.com', 'Lucas Barros Santos', '$2a$10$viIoOktkh.1.UmeAUY6ptOWXvoV25A2h3pSuJIU/eS86odejwjjAm');
INSERT INTO TB_PHONE (id, number, ddd, user_id) VALUES (random_uuid(), 996421975, 87, (select top 1 id from TB_USER));

INSERT INTO tb_role (id, role_name) VALUES (random_uuid(), 'ROLE_ADMIN');
INSERT INTO tb_user_role (user_id, role_id) VALUES ((select top 1 id from tb_user), (select top 1 id from tb_role));

