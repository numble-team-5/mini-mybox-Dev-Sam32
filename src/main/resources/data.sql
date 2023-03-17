INSERT INTO USER (user_id, user_name, password) VALUES (1, 'admin', 'dGVzdHBhc3N3b3Jk');

INSERT INTO FOLDER(folder_id, folder_name, deleted, user_id) VALUES(1, 'basic', 0, 1);

INSERT INTO FILE(file_id, file_name, file_size, deleted, folder_id) VALUES(1, 'basic', 1, 0, 1);

INSERT INTO STORAGE(storage_id, tot_storage_size, used_storage_size, user_id) VALUES(1, 30, 1, 1);